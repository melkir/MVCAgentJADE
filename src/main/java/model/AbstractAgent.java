package model;

import java.util.Observable;

/**
 * Created by melkir on 02/03/15.
 */
public abstract class AbstractAgent extends Observable {
    String name; // The name of the agent
    String type; // The type of the agent (provider, seeker)

    public AbstractAgent(String name) {
        this.name = name;
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
