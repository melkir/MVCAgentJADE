package agent;

import jade.lang.acl.ACLMessage;

/**
 * Created by melkir on 04/03/15.
 */
public class MusicSeekerAgent extends MusicAgent {

    @Override
    protected void setup() {
        super.setup();
        receiveMessage();
        sendMessageToProviderAgent("OK", ACLMessage.INFORM);
    }

    public void sendMessageToProviderAgent(String message, int type) {
        super.sendMessage("MusicProviderAgent", message, type);
    }

}
