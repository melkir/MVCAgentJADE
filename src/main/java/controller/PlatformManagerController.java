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
            if (view.getAgentType().equals("provider")) {
                AgentProvider agent = new AgentProvider();
                // Insert agent information into model
                model.addAgent(agent);
                // Update the console to add the agent
                view.addAgentToConsole(agent.getAgentInfo());
                // Show the agent corresponding view
                AgentProviderView providerView = new AgentProviderView();
                AgentProvider providerModel = new AgentProvider();
                new ProviderController(providerModel, providerView);
                providerView.setTitle(agent.getAgentInfo());
                providerView.setVisible(true);
            } else if (view.getAgentType().equals("seeker")) {
                AgentSeeker agent = new AgentSeeker();
                // Insert agent information into model
                model.addAgent(agent);
                // Update the console to add the agent
                view.addAgentToConsole(agent.getAgentInfo());
                // Show the agent corresponding view
                AgentSeekerView seekerView = new AgentSeekerView();
                AgentSeeker seekerModel = new AgentSeeker();
                new SeekerController(seekerModel, seekerView);
                seekerView.setTitle(agent.getAgentInfo());
                seekerView.setVisible(true);
            } else System.out.println("unknown");
        } catch (PlatformManager.NullAgentNameException e) {
            view.displayErrorMessage(e.getMessage());
        }
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
