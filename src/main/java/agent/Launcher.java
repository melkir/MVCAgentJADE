package agent;

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

    public static void startAgent(String agentName, String className, String[] args) {
        AgentController ac;
        try {
            // Object[] obj = new Object[1];
            // obj[0] = "Hello";
            ac = mainContainer.createNewAgent(agentName, className, args);
            ac.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }

    public static void startProvider() {
        startAgent("agentProvider", AgentProvider.class.getName(), null);
    }

    public static void startSeeker() {
        startAgent("agentSeeker", AgentSeeker.class.getName(), null);
    }

    public static void main(String[] args) {
        new Launcher(false);
        startAgent("agentProvider", AgentProvider.class.getName(), null);
        startAgent("agentSeeker", AgentSeeker.class.getName(), null);
    }

}
