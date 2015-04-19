package agent.behaviours.seeker;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentSeeker;
import model.ScoredMusic;

import java.util.ArrayList;

/**
 * Created by melkir on 08/04/15.
 */
public class Initialisation extends OneShotBehaviour {
    AgentSeeker agent;

    public Initialisation(AgentSeeker agent) {
        this.agent = agent;
    }

    @Override
    public void action() {
        agent.doWait();
        // L'agent recoit une liste de ScoredMusic
        ACLMessage message = agent.receive();
        Logger.log(message);
        // On recupere la liste des musiques que le fournisseur nous proposes
        ArrayList<ScoredMusic> scoredMusics = agent.getScoredMusics(message.getContent());
        // On initialise le modele avec la liste des musiques a achetees
        agent.setMusicsToBuy(scoredMusics);
        System.out.println("\n--- agentSeeker is ready to buy musics ---");
    }
}
