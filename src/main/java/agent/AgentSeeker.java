package agent;

import jade.lang.acl.ACLMessage;

/**
 * Created by melkir on 04/03/15.
 */
public class AgentSeeker extends AbstractAgent {

    @Override
    protected void setup() {
        super.setup();
        System.out.println("Seeker-agent " + getAID().getName() + " is ready.");
        receiveMessage();
        sendMessageToProviderAgent("OK", ACLMessage.INFORM);
    }

    public void sendMessageToProviderAgent(String message, int type) {
        super.sendMessage("TestProvider", message, type);
    }

    @Override
    protected void takeDown() {
        super.takeDown();
        System.out.println("Seeker-agent " + getAID().getName() + " terminating.");
    }
}
