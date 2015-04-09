package controller;

import agent.Launcher;
import model.AgentProvider;
import model.AgentSeeker;
import model.PlatformManager;
import org.gnome.gtk.Button;
import view.AgentProviderView;
import view.AgentSeekerView;
import view.PlatformManagerView;

/**
 * Created by melkir on 03/03/15.
 */
public class PlatformManagerController {
    private final PlatformManager model;
    private final PlatformManagerView view;

    public PlatformManagerController(PlatformManager model, PlatformManagerView view) {
        this.view = view;
        this.model = model;
        this.view.addButtonAddClickedListener(new ButtonAddClickedListener());
        new Launcher(true);
    }

    private void createAgent() {
        try {
            if (view.getAgentType().equals("provider")) createAgentProvider();
            else if (view.getAgentType().equals("seeker")) createAgentSeeker();
            else System.out.println("unknown agent type");
        } catch (PlatformManager.AgentInstanceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void createAgentProvider() throws PlatformManager.AgentInstanceException {
        model.addProvider();
        AgentProvider agent = new AgentProvider();
        // Update the console to add the agent
        view.addAgentToConsole(agent.getAgentName());
        // Show the agent corresponding view
        AgentProviderView providerView = new AgentProviderView();
        new ProviderController(agent, providerView);
        providerView.setTitle(agent.getAgentName());
        providerView.setVisible(true);
    }

    private void createAgentSeeker() throws PlatformManager.AgentInstanceException {
        model.addSeeker();
        AgentSeeker agent = new AgentSeeker();
        // Update the console to add the agent
        view.addAgentToConsole(agent.getAgentName());
        // Show the agent corresponding view
        AgentSeekerView seekerView = new AgentSeekerView();
        new SeekerController(agent, seekerView);
        seekerView.setTitle(agent.getAgentName());
        seekerView.setVisible(true);
    }

    /**
     * Create a new agent and show the corresponding view
     */
    private class ButtonAddClickedListener implements Button.Clicked {
        @Override
        public void onClicked(Button button) {
            createAgent();
        }
    }

}
