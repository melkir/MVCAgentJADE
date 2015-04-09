package model;

import agent.behaviours.seeker.FinTransaction;
import agent.behaviours.seeker.Initialisation;
import agent.behaviours.seeker.Start;
import agent.behaviours.seeker.Transaction;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melkir on 02/03/15.
 */
public class AgentSeeker extends Agent {

    public static AID IDENTIFIANT = new AID("agentSeeker", AID.ISLOCALNAME);
    private final List<Music> musicPurchasedList = new ArrayList<Music>();
    String genre, artist, album, title, price, nbmusic, budget, note;

    @Override
    protected void setup() {
        FSMBehaviour behaviour = new FSMBehaviour(this);
        // Etats
        behaviour.registerFirstState(new Start(this), "start");
        behaviour.registerState(new Initialisation(this), "initialisation");
        behaviour.registerState(new Transaction(this), "transaction");
        behaviour.registerLastState(new FinTransaction(this), "fin");

        // Transitions
        behaviour.registerDefaultTransition("start", "initialisation");
        behaviour.registerDefaultTransition("initialisation", "transaction");
        behaviour.registerTransition("transaction", "fin", 0);

        addBehaviour(behaviour);
    }

    public String getAgentName() {
        return IDENTIFIANT.getName();
    }

    @Override
    protected void takeDown() {
        System.out.println(getAID().getName() + " terminating.");
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setNbmusic(String nbmusic) {
        this.nbmusic = nbmusic;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Music getPurchasedMusic(int index) {
        return musicPurchasedList.get(index);
    }

    public void addPurchasedMusic(Music music) {
        musicPurchasedList.add(music);
    }

    public String[] getCriteriaList() {
        return new String[] {note, budget, nbmusic, price, title, album, artist, genre};
    }

}
