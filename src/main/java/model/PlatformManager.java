package model;

import java.util.Observable;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManager extends Observable {
    private Agent agentSeeker, agentProvider;

    public void addAgent(Agent agent) throws NullAgentNameException {
        if (agent.getName().isEmpty()) throw new NullAgentNameException("Vous devez entrer un nom d'agent");
        if (agent.getType().equals("seeker")) agentSeeker = agent;
        else agentProvider = agent;
    }

    public String getAgentSeekerName() {
        return agentSeeker.getName();
    }

    public String getAgentProviderName() {
        return agentProvider.getName();
    }

    public class NullAgentNameException extends Exception {
        public NullAgentNameException(String message) {
            super(message);
        }
    }

}
