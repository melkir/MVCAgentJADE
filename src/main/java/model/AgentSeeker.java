package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melkir on 02/03/15.
 */
public class AgentSeeker extends AbstractAgent {

    private final List<Music> musicPurchasedList = new ArrayList<Music>();

    public AgentSeeker(String name) {
        super(name, "seeker");
    }

    public Music getPurchasedMusic(int index) {
        return musicPurchasedList.get(index);
    }

    public void addPurchasedMusic(Music music) {
        musicPurchasedList.add(music);
    }

}
