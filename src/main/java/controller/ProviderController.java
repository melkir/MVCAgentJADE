package controller;

import model.AgentProvider;
import model.Music;
import org.gnome.gdk.Event;
import org.gnome.gtk.Button;
import org.gnome.gtk.Widget;
import org.gnome.gtk.Window;
import view.AgentProviderView;

/**
 * Created by melkir on 03/03/15.
 */
public class ProviderController {
    private final AgentProvider model;
    private final AgentProviderView view;

    public ProviderController(AgentProvider model, AgentProviderView view) {
        this.model = model;
        this.view = view;
        this.view.attachMusicTreeModel(model.getMusicTreeModel());
        this.view.addWindowCloseEvent(new WindowCloseEvent());
        this.view.addButtonAddClickedListener(new ButtonAddClickedListener());
    }

    private void createMusic() {
        String genre, artist, album, name, price, note;
        try {
            // Retrieve field content
            artist = view.getArtist();
            album = view.getAlbum();
            name = view.getName();
            price = view.getPrice();
            genre = view.getGenre();
            note = view.getNote();
            Music music = new Music(genre, artist, album, name, price, note);
            // Add music to model
            model.addMusicAvailable(music);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private class WindowCloseEvent implements Window.DeleteEvent {
        @Override
        public boolean onDeleteEvent(Widget widget, Event event) {
            //TODO Agent disconnect
            System.out.println(model.getAgentInfo() + " deleted");
            return false;
        }
    }

    private class ButtonAddClickedListener implements Button.Clicked {
        @Override
        public void onClicked(Button button) {
            createMusic();
        }
    }
}
