package agent;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

/**
 * Created by melkir on 05/03/15.
 */
public abstract class MusicAgent extends Agent {

    @Override
    // Agent initializations
    protected void setup() {
        super.setup();
    }

    public void sendMessage(String agentReceiver, String message, int type) {
        doWait(5000);
        ACLMessage msg = new ACLMessage(type);
        msg.addReceiver(new AID(agentReceiver, AID.ISLOCALNAME));
//        msg.setLanguage("English");
//        msg.setOntology("Weather - forecast - ontology");
        msg.setContent(message);
        send(msg);
    }

    public void receiveMessage() {
        // Wait until receive message
        doWait();
        ACLMessage msg = receive();
        if (msg != null)
            System.out.println("Received message from agent : " + msg.getSender().getName() + " > " + msg.getContent());
    }

}
