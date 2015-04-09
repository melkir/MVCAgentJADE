package model;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManager {

    boolean provider, seeker;

    public void addProvider() throws AgentInstanceException {
        if (provider) throw new AgentInstanceException("Only one instance of Agent Provider is allowed");
        provider = true;
    }

    public void addSeeker() throws AgentInstanceException {
        if (seeker) throw new AgentInstanceException("Only one instance of Agent Seeker is allowed");
        seeker = true;
    }

    public class AgentInstanceException extends Exception {
        public AgentInstanceException(String message) {
            super(message);
        }
    }

}
