package agent;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

/**
 * Created by melkir on 04/03/15.
 */
public class Seeker extends Agent {
    @Override
    protected void setup() {
        super.setup();
        receiveMessage();
    }

    public void receiveMessage() {
        // Wait until receive message
        doWait();
        ACLMessage msg = receive();
        if (msg != null)
            System.out.println("Received message from agent : "
                    + msg.getSender().getName() + " > "
                    + msg.getContent());
    }
}
