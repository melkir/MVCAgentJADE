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
    private final PlatformManager model;
    private final PlatformManagerView view;

    public PlatformManagerController(PlatformManager model, PlatformManagerView view) {
        this.view = view;
        this.model = model;
        this.view.addButtonAddClickedListener(new ButtonAddClickedListener());
        this.view.addEntryActivateListener(new EntryNameActivateListener());
//        new Launcher("false");
    }

    private void createAgent() {
        Agent agent;
        try {
            if (view.getAgentType().equals("provider")) {
                agent = new AgentProvider(view.getAgentName());
                // Insert agent information into model
                model.addAgent(agent);
                // Update the console to add the agent
                view.addAgentToConsole(agent.getAgentInfo());
                // Show the agent corresponding view
                AgentProviderView providerView = new AgentProviderView();
                AgentProvider providerModel = new AgentProvider(view.getAgentName());
                new ProviderController(providerModel, providerView);
                providerView.setTitle(agent.getAgentInfo());
                providerView.setVisible(true);
            } else if (view.getAgentType().equals("seeker")) {
                agent = new AgentSeeker(view.getAgentName());
                // Insert agent information into model
                model.addAgent(agent);
                // Update the console to add the agent
                view.addAgentToConsole(agent.getAgentInfo());
                // Show the agent corresponding view
                AgentSeekerView seekerView = new AgentSeekerView();
                AgentSeeker seekerModel = new AgentSeeker(view.getAgentName());
                new SeekerController(seekerModel, seekerView);
                seekerView.setTitle(agent.getAgentInfo());
                seekerView.setVisible(true);
            } else System.out.println("unknown");
            // Start the agent
//            agent.start();
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
