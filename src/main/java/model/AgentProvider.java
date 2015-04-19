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
import java.util.Collections;
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
        behaviour.registerTransition("transaction", "transaction", 1);
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

    public List<ScoredMusic> getMusicsScoredByCL(CriteriaList list) {
        ArrayList<ScoredMusic> scoredMusics = new ArrayList<ScoredMusic>();
        ScoredMusic sc;
        for (Music music : musicListAvailable) {
            sc = new ScoredMusic(music, list);
            if (sc.getRevelanceScore() >= 1) scoredMusics.add(sc);
        }
        // sort by revelance and descending order
        Collections.sort(scoredMusics, Collections.reverseOrder());
        return scoredMusics;
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

    public boolean sellMusic(int id) {
        // Retrieve music by id
        boolean isSelled = false;
        for (Music m : musicListAvailable) {
            if (m.getId() == id) {
                addMusicSold(m);
                isSelled = true;
                break;
            }
        }
        return isSelled;
    }

    public String getXmlFromMusics(List<Music> musics) {
        XStream xs = new XStream(new StaxDriver());
        xs.alias("musics", List.class);
        return xs.toXML(musics);
    }

    public Music xmlToMusic(String xml) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("music", Music.class);
        return (Music) xstream.fromXML(xml);
    }

    public String getXmlFromScoredMusic(List<ScoredMusic> scoredMusics) {
        XStream xs = new XStream(new StaxDriver());
        xs.alias("ScoredMusics", List.class);
        return xs.toXML(scoredMusics);
    }

    public CriteriaList getCriteriaList(String xml) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("criteria", CriteriaList.class);
        return (CriteriaList) xstream.fromXML(xml);
    }

}
