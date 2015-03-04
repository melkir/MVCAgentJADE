package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManager extends Observable {
    private List<Agent> agentList = new ArrayList<Agent>();

    public void addAgent(Agent agent) throws NullAgentNameException {
        if (agent.getName().isEmpty()) throw new NullAgentNameException("You need to enter the agent name");
        agentList.add(agent);
    }

    public class NullAgentNameException extends Exception {
        public NullAgentNameException(String message) {
            super(message);
        }
    }

}
