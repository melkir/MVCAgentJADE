package controller;

import agent.Launcher;
import model.AgentSeeker;
import model.CriteriaList;
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
        this.model = model;
        this.view = view;
        this.view.addWindowCloseEvent(new WindowCloseEvent());
        this.view.addButtonAddClickedListener(new ButtonAddClickedListener());
        Launcher.startAgent("agentSeeker", model);
    }

    private void initModel() throws NumberFormatException {
        model.setBudget(Integer.parseInt(view.getBudget()));
        CriteriaList criteriaList = new CriteriaList();
        criteriaList.setGenre(view.getGenre());
        criteriaList.setArtist(view.getArtist());
        criteriaList.setAlbum(view.getAlbum());
        criteriaList.setTitle(view.getName());
        criteriaList.setNbmusic(view.getNbMusic());
        criteriaList.setBudget(view.getBudget());
        criteriaList.setNote(view.getNote());
        model.setCriteriaList(criteriaList);
    }

    private class WindowCloseEvent implements Window.DeleteEvent {
        public boolean onDeleteEvent(Widget widget, Event event) {
            model.doDelete();
            return false;
        }
    }

    private class ButtonAddClickedListener implements Button.Clicked {
        public void onClicked(Button button) {
            try {
                initModel();
            } catch (NumberFormatException e) {
                view.displayErrorMessage("Incorrect budget value");
                return;
            }
            model.doWake();
        }
    }

}
