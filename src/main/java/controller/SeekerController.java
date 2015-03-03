package controller;

import model.AgentSeeker;
import org.gnome.gdk.Event;
import org.gnome.gtk.Widget;
import org.gnome.gtk.Window;
import view.AgentSeekerView;

/**
 * Created by melkir on 03/03/15.
 */
public class SeekerController {
    AgentSeeker model;
    AgentSeekerView view;

    public SeekerController(AgentSeeker model, AgentSeekerView view) {
        this.model = model;
        this.view = view;
        this.view.addWindowCloseEvent(new WindowCloseEvent());
    }

    private class WindowCloseEvent implements Window.DeleteEvent {
        @Override
        public boolean onDeleteEvent(Widget widget, Event event) {
            //TODO Agent disconnect
            System.out.println(model.getAgentInfo() + " deleted");
            return false;
        }
    }
}
