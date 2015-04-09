package agent.behaviours.seeker;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentProvider;
import model.AgentSeeker;

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
        ACLMessage message = new ACLMessage(ACLMessage.PROPOSE);
        message.setContent("I wanna buy this !");
        message.addReceiver(AgentProvider.IDENTIFIANT);
        agent.send(message);

        agent.doWait();
        ACLMessage response = agent.receive();
        Logger.log(response);

        result = 0;
    }

    @Override
    public int onEnd() {
        return result;
    }
}
