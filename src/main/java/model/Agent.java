package model;

import java.util.Observable;

/**
 * Created by melkir on 02/03/15.
 */
public class Agent extends Observable {
    String name; // The name of the agent
    String type; // The type of the agent (provider, seeker)

    public Agent(String name) {
        this.name = name;
    }

    public Agent(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getAgentInfo() {
        return "Agent " + type + " " + name;
    }

}
