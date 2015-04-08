package model;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManager {

    public void addAgent(AgentProvider agent) throws NullAgentNameException {
//        if (agent.getModelName().isEmpty()) throw new NullAgentNameException("Vous devez entrer un nom d'agent");
    }
    public void addAgent(AgentSeeker agent) throws NullAgentNameException {
//        if (agent.getModelName().isEmpty()) throw new NullAgentNameException("Vous devez entrer un nom d'agent");
    }

    public class NullAgentNameException extends Exception {
        public NullAgentNameException(String message) {
            super(message);
        }
    }

}
