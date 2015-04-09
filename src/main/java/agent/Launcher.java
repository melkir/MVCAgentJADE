package agent;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import model.AgentProvider;
import model.AgentSeeker;

/**
 * Created by melkir on 04/03/15.
 */
public class Launcher {

    private static AgentContainer mainContainer;

    /**
     * Create and launch MusicSeeker and MusicProvider agent
     */
    public Launcher(boolean debug) {
        Runtime runtime = Runtime.instance();
        Profile config = new ProfileImpl("localhost", 8888, null);
        config.setParameter("gui", debug ? "true" : "false");
        mainContainer = runtime.createMainContainer(config);
    }

    public static void startAgent(String agentName, Agent agent) {
        AgentController ac;
        try {
            ac = mainContainer.acceptNewAgent(agentName, agent);
            ac.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Launcher(true);
        startAgent("agentProvider", new AgentProvider());
        startAgent("agentSeeker", new AgentSeeker());
    }

}
