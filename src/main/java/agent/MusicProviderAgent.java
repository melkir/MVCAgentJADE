package agent;

import jade.lang.acl.ACLMessage;

/**
 * Created by melkir on 04/03/15.
 */
public class MusicProviderAgent extends MusicAgent {

    @Override
    protected void setup() {
        super.setup();
        System.out.println("Provider-agent "+getAID().getName()+" is ready.");
        sendMessageToSeekerAgent("Today it's raining", ACLMessage.INFORM);
        receiveMessage();
    }

    public void sendMessageToSeekerAgent(String message, int type) {
        super.sendMessage("TestSeeker", message, type);
    }

    @Override
    protected void takeDown() {
        super.takeDown();
        System.out.println("Provider-agent "+getAID().getName()+" terminating.");
    }
}
