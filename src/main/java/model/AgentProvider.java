package model;

import agent.behaviours.provider.FinTransaction;
import agent.behaviours.provider.Initialisation;
import agent.behaviours.provider.Transaction;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
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
        behaviour.registerFirstState(new Initialisation(this), "initialisation");
        behaviour.registerState(new Transaction(this), "transaction");
        behaviour.registerLastState(new FinTransaction(this), "fin");
        // Transitions
        behaviour.registerDefaultTransition("initialisation", "transaction");
        behaviour.registerTransition("transaction", "fin", 0);

        addBehaviour(behaviour);
    }

    @Override
    protected void takeDown() {
        System.out.println(getAID().getName() + " terminating.");
    }

    public String getAgentName() {
        return IDENTIFIANT.getName();
    }

    public List<Music> getMusicsByCrit(CriteriaList list) {
        ArrayList<Music> res = new ArrayList<Music>();
        for (Music music : musicListAvailable) {
            if (isFromCriteriaList(music, list)) res.add(music);
        }
        return res;
    }

    public boolean isFromCriteriaList(Music music, CriteriaList list) {
        boolean title = !isNullOrEmpty(list.getTitle()) & music.getTitre().equals(list.getTitle());
        boolean album = !isNullOrEmpty(list.getAlbum()) & music.getAlbum().equals(list.getAlbum());
        boolean genre = !isNullOrEmpty(list.getGenre()) & music.getGenre().equals(list.getGenre());
        boolean artist = !isNullOrEmpty(list.getArtist()) & music.getArtist().equals(list.getArtist());
        boolean note = !isNullOrEmpty(list.getNote()) & Integer.parseInt(music.getNote()) >= Integer.parseInt(list.getNote());
        return note || genre || artist || album || title;
    }

    public boolean isNullOrEmpty(String str) {
        return str != null && str.isEmpty();
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

    public CriteriaList convertCriteriaXmlToObject(String xml) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("criteria", CriteriaList.class);
        return (CriteriaList) xstream.fromXML(xml);
    }

}
