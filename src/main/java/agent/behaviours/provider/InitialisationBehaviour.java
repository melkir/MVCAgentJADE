package agent.behaviours.provider;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentProvider;

/**
 * Created by melkir on 08/04/15.
 */
public class InitialisationBehaviour extends OneShotBehaviour {
    AgentProvider agent;

    public InitialisationBehaviour(AgentProvider agent) {
        this.agent = agent;
    }

    @Override
    public void action() {
        // Attente d'un message de l'agent Seeker pour commencer la transaction
        agent.doWait();
        ACLMessage message = agent.receive();
        Logger.log(message);
    }
}
