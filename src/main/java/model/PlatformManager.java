package model;

import java.util.Observable;

/**
 * Created by melkir on 02/03/15.
 */
public class PlatformManager extends Observable {
    private String agentInfo;

    public void addAgent(String name, String type) {
        if (name.isEmpty()) throw new NullPointerException();
        agentInfo = "Agent " + type + " " + name;
    }

    public String getAgentInfo() {
        return agentInfo;
    }
}
