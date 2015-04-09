package agent.behaviours.seeker;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentSeeker;

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
        // Attente d'un message de l'agent Provider contenant la liste des musiques
        agent.doWait();
        ACLMessage message = agent.receive();
        Logger.log(message);
    }
}
