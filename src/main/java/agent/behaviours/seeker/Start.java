package agent.behaviours.seeker;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentProvider;
import model.AgentSeeker;

/**
 * Created by melkir on 09/04/15.
 */
public class Start extends OneShotBehaviour {

    private final AgentSeeker agent;

    public Start(AgentSeeker agent) {
        this.agent = agent;
    }

    @Override
    public void action() {
        agent.doWait();
        ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
        message.setContent(agent.getXmlCriteriaList());
        message.addReceiver(AgentProvider.IDENTIFIANT);
        agent.send(message);
    }
}
