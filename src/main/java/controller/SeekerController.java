package controller;

import agent.Launcher;
import model.AgentSeeker;
import org.gnome.gdk.Event;
import org.gnome.gtk.Button;
import org.gnome.gtk.Widget;
import org.gnome.gtk.Window;
import view.AgentSeekerView;

/**
 * Created by melkir on 03/03/15.
 */
public class SeekerController {
    private final AgentSeeker model;
    private final AgentSeekerView view;

    public SeekerController(AgentSeeker model, AgentSeekerView view) {
        Launcher.startSeeker();
        this.model = model;
        this.view = view;
        this.view.addWindowCloseEvent(new WindowCloseEvent());
        this.view.addButtonAddClickedListener(new ButtonAddClickedListener());
    }

    private class WindowCloseEvent implements Window.DeleteEvent {
        @Override
        public boolean onDeleteEvent(Widget widget, Event event) {
//            model.doDelete();
            return false;
        }
    }

    private class ButtonAddClickedListener implements Button.Clicked {
        @Override
        public void onClicked(Button button) {
            // TODO Retrieve musics
        }
    }

}
