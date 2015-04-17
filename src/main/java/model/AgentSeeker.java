package model;

import agent.behaviours.seeker.FinTransaction;
import agent.behaviours.seeker.Initialisation;
import agent.behaviours.seeker.Start;
import agent.behaviours.seeker.Transaction;
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
public class AgentSeeker extends Agent {

    public static AID IDENTIFIANT = new AID("agentSeeker", AID.ISLOCALNAME);
    private final List<Music> musicPurchasedList = new ArrayList<Music>();
    private CriteriaList criteriaList;

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

    @Override
    protected void takeDown() {
        System.out.println(getAID().getName() + " terminating.");
    }

    public String getAgentName() {
        return IDENTIFIANT.getName();
    }

    public Music getPurchasedMusic(int index) {
        return musicPurchasedList.get(index);
    }

    public void addPurchasedMusic(Music music) {
        musicPurchasedList.add(music);
    }

    public String getXmlCriteriaList() {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("criteria", CriteriaList.class);
        return xstream.toXML(criteriaList);
    }

    public String musicToXml(Music music) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("music", Music.class);
        return xstream.toXML(music);
    }

    public ArrayList<ScoredMusic> getScoredMusics(String xml) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("ScoredMusics", List.class);
        return (ArrayList<ScoredMusic>) xstream.fromXML(xml);
    }


    public void setCriteriaList(CriteriaList criteriaList) {
        this.criteriaList = criteriaList;
    }

}
