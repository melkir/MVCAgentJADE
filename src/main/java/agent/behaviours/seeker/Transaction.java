package agent.behaviours.seeker;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentProvider;
import model.AgentSeeker;
import model.Music;
import model.ScoredMusic;

import java.util.Iterator;
import java.util.List;

/**
 * Created by melkir on 09/04/15.
 */
public class Transaction extends OneShotBehaviour {
    AgentSeeker agent;
    int result;

    public Transaction(AgentSeeker agent) {
        this.agent = agent;
        result = -1;
    }

    @Override
    public void action() {
        // Debut de la transaction
        List<ScoredMusic> musicsToBuy = agent.getMusicsToBuy();
        Iterator itrMusics = musicsToBuy.iterator();
        int budget = agent.getBudget();
        ACLMessage response;
        if (itrMusics.hasNext() & budget > 0) {
            // Achat d'une musique
            ScoredMusic scoredMusic = (ScoredMusic) itrMusics.next();
            Music music = scoredMusic.getMusic();
            response = new ACLMessage(ACLMessage.REQUEST);
            response.setContent(agent.musicToXml(music));
            response.addReceiver(AgentProvider.IDENTIFIANT);
            agent.send(response);
            result = 1;
            agent.addPurchasedMusic(scoredMusic.getMusic());
            musicsToBuy.remove(scoredMusic);
        } else {
            System.out.println("Seeker : Fin des achats de musiques");
            // Fin des achats de musiques
            result = 0;
        }
        agent.doWait();
        ACLMessage message = agent.receive();
        Logger.log(message);
    }

    @Override
    public int onEnd() {
        return result;
    }
}
