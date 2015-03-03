package controller;

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
        String agentName, agentType;
        try {
            // Retrieve field content
            agentName = view.getAgentName();
            agentType = view.getAgentType();
            // Insert agent information into model
            model.addAgent(agentName, agentType);
            // Update the view to add the agent
            view.addAgentToView(model.getAgentInfo());
            // Show the agent corresponding view
            if (agentType.equals("provider")) {
                AgentProviderView providerView = new AgentProviderView();
                new ProviderController(new AgentProvider(view.getAgentName()), providerView);
                providerView.setVisible(true);
                providerView.setTitle("Agent " + agentType + " " + agentName);
            } else if (agentType.equals("seeker")) {
                AgentSeekerView seekerView = new AgentSeekerView();
                new SeekerController(new AgentSeeker(view.getAgentName()), seekerView);
                seekerView.setTitle("Agent " + agentType + " " + agentName);
                seekerView.setVisible(true);
            } else System.out.println("unknown");

        } catch (NullPointerException ex) {
            // Show error message if name field is empty
            view.displayErrorMessage("You need to enter the agent name");
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
