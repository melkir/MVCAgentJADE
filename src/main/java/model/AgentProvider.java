package model;

import agent.behaviours.provider.InitialisationBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melkir on 02/03/15.
 */
public class AgentProvider extends Agent {

    public static AID IDENTIFIANT = new AID("agentProvider", AID.ISLOCALNAME);

    private final List<Music> musicListAvailable = new ArrayList<Music>();
    private final List<Music> musicListSold = new ArrayList<Music>();

    @Override
    protected void setup() {
        FSMBehaviour behaviour = new FSMBehaviour(this);
        // Etats
        behaviour.registerFirstState(new InitialisationBehaviour(this), "initialisation");
    }

    public String getAgentInfo() {
        return IDENTIFIANT.getName();
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
    }

    public void addMusicSold(Music music) {
        musicListAvailable.remove(music);
        musicListSold.add(music);
    }

    @Override
    protected void takeDown() {
        System.out.println(getAID().getName() + " terminating.");
    }

}
