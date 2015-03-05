package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melkir on 02/03/15.
 */
public class AgentSeeker extends Agent {

    List<Music> musicPurchasedList = new ArrayList<Music>();

    public AgentSeeker(String name) {
        super(name);
        this.type = "seeker";
    }

    public void addPurchasedMusic(Music music) {
        musicPurchasedList.add(music);
    }

}
