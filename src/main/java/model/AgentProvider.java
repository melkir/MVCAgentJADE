package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melkir on 02/03/15.
 */
public class AgentProvider extends Agent {

    List<Music> musicListAvailable = new ArrayList<Music>(), musicListSold = new ArrayList<Music>();

    public AgentProvider(String name) {
        super(name);
        this.type = "provider";
    }

    public void addMusicAvailable(Music music) {
        musicListAvailable.add(music);
    }

    public void addMusicSold(Music music) {
        musicListSold.add(music);
    }

}
