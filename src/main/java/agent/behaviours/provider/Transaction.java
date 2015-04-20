package agent.behaviours.provider;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentProvider;
import model.AgentSeeker;
import model.Music;

/**
 * Created by melkir on 09/04/15.
 */
public class Transaction extends OneShotBehaviour {
    private final AgentProvider agent;
    private int result;

    public Transaction(AgentProvider agent) {
        this.agent = agent;
        result = -1;
    }

    @Override
    public void action() {
        agent.doWait();
        ACLMessage message = agent.receive();
        Logger.log(message);
        ACLMessage response = new ACLMessage(ACLMessage.INFORM);
        Music music = agent.xmlToMusic(message.getContent());
        // Proceed selling
        boolean isSelled = agent.sellMusic(music.getId());
        // Get the result of selling operation
        String content = "Music " + music.getTitre() + " " + (isSelled ? "sold" : "not available");
        response.setContent(content);
        response.addReceiver(AgentSeeker.IDENTIFIANT);
        agent.send(response);
        result = 1;
    }

    @Override
    public int onEnd() {
        return result;
    }
}
