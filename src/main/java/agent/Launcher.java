package agent;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

/**
 * Created by melkir on 04/03/15.
 */
public class Launcher {
    /**
     * Create and launch MusicSeeker and MusicProvider agent
     */
    public Launcher() {
        Runtime runtime = Runtime.instance();
        Profile config = new ProfileImpl("localhost", 8888, null);
//        config.setParameter("gui", "true");
        AgentContainer mc = runtime.createMainContainer(config);
        AgentController acSeeker, acProvider;
        try {
//            Object[] obj = new Object[1];
//            obj[0] = "Hello";
            acProvider = mc.createNewAgent("TestProvider", MusicProviderAgent.class.getName(), null);
            acSeeker = mc.createNewAgent("TestSeeker", MusicSeekerAgent.class.getName(), null);
            acProvider.start();
            acSeeker.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Launcher();
    }

}
