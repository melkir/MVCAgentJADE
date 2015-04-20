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
    private final AgentProvider agent;

    public Initialisation(AgentProvider agent) {
        this.agent = agent;
    }

    @Override
    public void action() {
        // Attente d'un message de l'agent Seeker pour commencer la transaction
        agent.doWait();
        ACLMessage message = agent.receive();
        Logger.log(message);
        // Recupere la liste des criteres de l'agent seeker
        CriteriaList criteria = agent.getCriteriaList(message.getContent());
        // Effectue un traitement pour recupere les musiques qui correspondent aux criteres
        List<ScoredMusic> scoredMusics = agent.getMusicsScoredByCL(criteria);
        String xmlScoredMusic;
        if (scoredMusics == null) xmlScoredMusic = "Aucun resultat";
        else xmlScoredMusic = agent.getXmlFromScoredMusic(scoredMusics);
        ACLMessage reponse = new ACLMessage(ACLMessage.PROPOSE);
        reponse.setContent(xmlScoredMusic);
        reponse.addReceiver(AgentSeeker.IDENTIFIANT);
        agent.send(reponse);
    }
}
