package model;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManager {

    AgentProvider provider;
    AgentSeeker seeker;

    public AgentProvider getProvider() {
        return provider;
    }

    public void setProvider(AgentProvider provider) {
        this.provider = provider;
    }

    public AgentSeeker getSeeker() {
        return seeker;
    }

    public void setSeeker(AgentSeeker seeker) {
        this.seeker = seeker;
    }

}
