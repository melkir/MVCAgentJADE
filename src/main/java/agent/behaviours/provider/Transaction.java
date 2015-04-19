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
    AgentProvider agent;
    int result;

    public Transaction(AgentProvider agent) {
        this.agent = agent;
        result = -1;
    }

    @Override
    public void action() {
        agent.doWait();
        ACLMessage message = agent.receive();
        Logger.log(message);
        ACLMessage response = new ACLMessage(ACLMessage.CONFIRM);
        Music music = agent.xmlToMusic(message.getContent());
        // Proceed selling
        boolean isSelled = agent.sellMusic(music.getId());
        // Get the result of selling operation
        result = (isSelled ? 1 : 0);
        String content = "Music " + music.getTitre() + " " + (isSelled ? "sold" : "not available");
        response.setContent(content);
        response.addReceiver(AgentSeeker.IDENTIFIANT);
        agent.send(response);
    }

    @Override
    public int onEnd() {
        return result;
    }
}
