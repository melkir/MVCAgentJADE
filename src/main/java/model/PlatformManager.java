package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManager extends Observable {
    private List<Agent> agentList = new ArrayList<Agent>();

    public void addAgent(String name, String type) throws NullAgentNameException {
        if (name.isEmpty()) throw new NullAgentNameException("You need to enter the agent name");
        agentList.add(new Agent(name, type));
    }

    public Agent getLastAgentCreated() {
        return agentList.get(agentList.size() - 1);
    }

    public class NullAgentNameException extends Exception {
        public NullAgentNameException(String message) {
            super(message);
        }
    }

}
