package agent.behaviours.provider;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentProvider;
import model.AgentSeeker;
import model.CriteriaList;
import model.ScoredMusic;

import java.util.List;

/**
 * Created by melkir on 08/04/15.
 */
public class Initialisation extends OneShotBehaviour {
    AgentProvider agent;

    public Initialisation(AgentProvider agent) {
        this.agent = agent;
    }

    @Override
    public void action() {
        // Attente d'un message de l'agent Seeker pour commencer la transaction
        agent.doWait();
        ACLMessage message = agent.receive();
        Logger.log(message);
        CriteriaList crits = agent.getCriteriaList(message.getContent());
        List<ScoredMusic> scoredMusics = agent.getMusicsScoredByCL(crits);
        for (ScoredMusic sc : scoredMusics) System.out.println(sc.toString());

//        String xmlMusics;
//        if (musics == null) xmlMusics = "Vide";
//        else xmlMusics = agent.getXmlFromMusics(musics);
        ACLMessage reponse = new ACLMessage(ACLMessage.PROPOSE);
        reponse.setContent("Hello!");
        reponse.addReceiver(AgentSeeker.IDENTIFIANT);
        agent.send(reponse);
    }
}
