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
    private static int nbMusicBuyed = 0;
    private final AgentSeeker agent;
    private int result;

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
        int maxNbMusicToBuy = (agent.getCriteriaNbMusic().isEmpty() ?
                100 : Integer.parseInt(agent.getCriteriaNbMusic()));

        if (itrMusics.hasNext() & maxNbMusicToBuy > nbMusicBuyed++) {
            ScoredMusic sm = (ScoredMusic) itrMusics.next();
            Music music = sm.getMusic();
            int price = Integer.parseInt(music.getPrice());
            if (price < budget) {
                // Demande de l'achat de la musique
                ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
                request.setContent(agent.musicToXml(music));
                request.addReceiver(AgentProvider.IDENTIFIANT);
                agent.send(request);
                agent.doWait(200);
                ACLMessage message = agent.receive();
                Logger.log(message);
                // MAJ des musiques
                agent.buyMusic(sm);
                result = 1;
            } else {
                result = 0;
            }
        } else {
            result = 0;
        }
    }

    @Override
    public int onEnd() {
        return result;
    }

}
