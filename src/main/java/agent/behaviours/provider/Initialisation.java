package agent.behaviours.provider;

import agent.Logger;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import model.AgentProvider;
import model.AgentSeeker;
import model.CriteriaList;

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
        CriteriaList criteriaList = agent.convertCriteriaXmlToObject(message.getContent());
        ACLMessage reponse = new ACLMessage(ACLMessage.PROPOSE);
        reponse.setContent("Criteria list received");
        reponse.addReceiver(AgentSeeker.IDENTIFIANT);
        agent.send(reponse);
    }
}
