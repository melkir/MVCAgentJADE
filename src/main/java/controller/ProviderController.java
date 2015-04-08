package controller;

import model.AgentProvider;
import model.Music;
import org.apache.commons.io.IOUtils;
import org.gnome.gdk.Event;
import org.gnome.gtk.Button;
import org.gnome.gtk.Widget;
import org.gnome.gtk.Window;
import org.json.JSONArray;
import org.json.JSONObject;
import view.AgentProviderView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by melkir on 03/03/15.
 */
public class ProviderController {
    private final AgentProvider model;
    private final AgentProviderView view;

    public ProviderController(AgentProvider model, AgentProviderView view) {
        this.model = model;
        this.view = view;
        try {
            loadMusicFromJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.view.addWindowCloseEvent(new WindowCloseEvent());
        this.view.addButtonAddClickedListener(new ButtonAddClickedListener());
    }

    private void loadMusicFromJson() throws IOException {
        InputStream in = ProviderController.class.getResourceAsStream("/playlist.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String jsonFile = IOUtils.toString(reader);
        JSONObject obj = new JSONObject(jsonFile);
        JSONArray arr = obj.getJSONArray("list");
        String genre, title, artist, album, price, note;
        Music music;
        for (int i = 0; i < arr.length(); i++) {
            genre = arr.getJSONObject(i).getString("genre");
            title = arr.getJSONObject(i).getString("title");
            artist = arr.getJSONObject(i).getString("artist");
            album = arr.getJSONObject(i).getString("album");
            price = arr.getJSONObject(i).getString("price");
            note = arr.getJSONObject(i).getString("note");
            music = new Music(genre, artist, album, title, price, note);
            view.addMusicAvailable(music);
            model.addMusicAvailable(music);
        }
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
            view.addMusicAvailable(music);
            model.addMusicAvailable(music);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private class WindowCloseEvent implements Window.DeleteEvent {
        @Override
        public boolean onDeleteEvent(Widget widget, Event event) {
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
