package agent.behaviours.provider;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentProvider;
import model.AgentSeeker;

/**
 * Created by melkir on 09/04/15.
 */
public class Transaction extends OneShotBehaviour {
    AgentProvider agent;
    int result;

    public Transaction(AgentProvider agent) {
        this.agent = agent;
        result = -1;
    }

    @Override
    public void action() {
        agent.doWait();
        ACLMessage message = agent.receive();
        Logger.log(message);
        // Proceed selling
        result = 0;

        ACLMessage response = new ACLMessage(ACLMessage.INFORM);
        response.setContent("Sell something");
        response.addReceiver(AgentSeeker.IDENTIFIANT);
        agent.send(response);
    }

    @Override
    public int onEnd() {
        return result;
    }
}
