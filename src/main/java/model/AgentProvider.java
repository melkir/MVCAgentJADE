package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melkir on 02/03/15.
 */
public class AgentProvider extends Agent {

    private final List<Music> musicListAvailable = new ArrayList<Music>();
    private final List<Music> musicListSold = new ArrayList<Music>();
    private final MusicTreeModel musicTreeModel = new MusicTreeModel();

    public AgentProvider(String name) {
        super(name, "provider");
        this.agent = new agent.AgentProvider();
    }

    public List<Music> getMusicByTitle(String title) {
        ArrayList<Music> res = new ArrayList<Music>();
        for (Music music : musicListAvailable) {
            if (music.getTitre().equals(title)) res.add(music);
        }
        return res;
    }

    public List<Music> getMusicByArtist(String artist) {
        ArrayList<Music> res = new ArrayList<Music>();
        for (Music music : musicListAvailable) {
            if (music.getArtist().equals(artist)) res.add(music);
        }
        return res;
    }

    public List<Music> getMusicByAlbum(String album) {
        ArrayList<Music> res = new ArrayList<Music>();
        for (Music music : musicListAvailable) {
            if (music.getAlbum().equals(album)) res.add(music);
        }
        return res;
    }

    public List<Music> getMusicByGenre(String genre) {
        ArrayList<Music> res = new ArrayList<Music>();
        for (Music music : musicListAvailable) {
            if (music.getGenre().equals(genre)) res.add(music);
        }
        return res;
    }

    public Music getMusicByIndex(int index) {
        return musicListAvailable.get(index);
    }

    public Music getMusicSoldByIndex(int index) {
        return musicListSold.get(index);
    }

    public void addMusicAvailable(Music music) {
        musicListAvailable.add(music);
        musicTreeModel.addMusic(music);
    }

    public MusicTreeModel getMusicTreeModel() {
        return musicTreeModel;
    }

    public void addMusicSold(Music music) {
        musicListAvailable.remove(music);
        musicListSold.add(music);
    }

}
