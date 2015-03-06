package model;

import agent.AbstractAgent;
import agent.Launcher;

import java.util.Observable;

/**
 * Created by melkir on 02/03/15.
 */
public abstract class Agent extends Observable {
    private final String name; // The name of the agent
    private final String type; // The type of the agent (provider, seeker)
    AbstractAgent agent;

    public Agent(String name, String type) {
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

    public void start() {
        Launcher.startAgent(name, agent.getClass().getName(), null);
    }

}
