package agent.behaviours.provider;

import jade.core.behaviours.OneShotBehaviour;
import model.AgentProvider;

/**
 * Created by melkir on 09/04/15.
 */
public class FinTransaction extends OneShotBehaviour {
    AgentProvider agent;

    public FinTransaction(AgentProvider agent) {
        this.agent = agent;
    }

    @Override
    public void action() {
        System.out.println(agent.getAID().getLocalName() + " fin transaction");
        agent.doDelete();
    }
}
