package controller;

import model.Agent;
import model.AgentProvider;
import model.AgentSeeker;
import model.PlatformManager;
import org.gnome.gtk.Button;
import org.gnome.gtk.Entry;
import view.AgentProviderView;
import view.AgentSeekerView;
import view.PlatformManagerView;

/**
 * Created by melkir on 03/03/15.
 */
public class PlatformManagerController {
    private PlatformManager model;
    private PlatformManagerView view;

    public PlatformManagerController(PlatformManager model, PlatformManagerView view) {
        this.view = view;
        this.model = model;
        this.view.addButtonAddClickedListener(new ButtonAddClickedListener());
        this.view.addEntryActivateListener(new EntryNameActivateListener());
    }

    private void createAgent() {
        Agent agent;
        try {
            agent = new Agent(view.getAgentName(), view.getAgentType());
            // Insert agent information into model
            model.addAgent(agent);
            // Update the console to add the agent
            view.addAgentToConsole(agent.getAgentInfo());
            // Show the agent corresponding view
            if (agent.getType().equals("provider")) {
                AgentProviderView providerView = new AgentProviderView();
                new ProviderController(new AgentProvider(view.getAgentName()), providerView);
                providerView.setVisible(true);
                providerView.setTitle("Agent " + agent.getType() + " " + agent.getName());
            } else if (agent.getType().equals("seeker")) {
                AgentSeekerView seekerView = new AgentSeekerView();
                new SeekerController(new AgentSeeker(view.getAgentName()), seekerView);
                seekerView.setTitle("Agent " + agent.getType() + " " + agent.getName());
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

    private class EntryNameActivateListener implements Entry.Activate {
        @Override
        public void onActivate(Entry entry) {
            createAgent();
        }
    }

}
