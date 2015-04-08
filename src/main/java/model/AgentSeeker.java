package model;

import agent.behaviours.seeker.InitialisationBehaviour;
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

    public String getAgentInfo() {
        return IDENTIFIANT.getName();
    }

    @Override
    protected void setup() {
        FSMBehaviour behaviour = new FSMBehaviour(this);
        // Etats
        behaviour.registerFirstState(new InitialisationBehaviour(this), "initialisation");
    }

    public Music getPurchasedMusic(int index) {
        return musicPurchasedList.get(index);
    }

    public void addPurchasedMusic(Music music) {
        musicPurchasedList.add(music);
    }

    @Override
    protected void takeDown() {
        System.out.println(getAID().getName() + " terminating.");
        doDelete();
    }

}
