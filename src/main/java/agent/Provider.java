package agent;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

/**
 * Created by melkir on 04/03/15.
 */
public class Provider extends Agent {
    @Override
    protected void setup() {
        super.setup();
        sendMessage();
    }

    public void sendMessage() {
        doWait(15000);
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Seeker", AID.ISLOCALNAME));
        msg.setLanguage("English");
        msg.setOntology("Weather - forecast - ontology");
        msg.setContent("Today it’s raining");
        send(msg);
    }
}
