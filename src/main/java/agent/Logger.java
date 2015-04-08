package agent;

import jade.lang.acl.ACLMessage;

/**
 * Created by melkir on 08/04/15.
 */
public class Logger {

    public static void log(ACLMessage message) {
        if (message != null)
            System.out.println("\n" + message.getSender().getLocalName() + "> " + message.getContent());
    }

}
