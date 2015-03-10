package model;

/**
 * Created by melkir on 02/03/15.
 */
public abstract class AbstractAgent {
    private final String name; // The name of the agent
    private final String type; // The type of the agent (provider, seeker)

    public AbstractAgent(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAgentInfo() {
        return "Agent " + type + " " + name;
    }

}
