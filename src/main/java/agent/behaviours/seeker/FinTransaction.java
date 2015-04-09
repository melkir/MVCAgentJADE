package agent.behaviours.seeker;

import jade.core.behaviours.OneShotBehaviour;
import model.AgentSeeker;

/**
 * Created by melkir on 09/04/15.
 */
public class FinTransaction extends OneShotBehaviour {
    AgentSeeker agent;

    public FinTransaction(AgentSeeker agent) {
        this.agent = agent;
    }

    @Override
    public void action() {
        System.out.println(agent.getAID().getLocalName() + " fin transaction");
        agent.doDelete();
    }
}
