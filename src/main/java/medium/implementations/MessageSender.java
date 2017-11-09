package medium.implementations;

import Agent.Agir.GenererMessage.Message.Annonce;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import interfaceswcomp.OCService;
import medium.interfaces.EnvAnnonce;
import unifieur.services.Matching;

import java.util.HashMap;
import java.util.Map;

/**
 * MessageSender fait appel aux services du composant Unifieur
 * pour filtrer les agents compatibles avec l’agent émetteur de l’annonce.
 * L'envoi des annonces est réalisé grâce à l'interface Communication.
 */
public class MessageSender implements EnvAnnonce {
    private Matching matching;
    private ICommunication communication;
     @Override
    public void sendAnnonce(HashMap<ReferenceAgent, OCService> agents, Annonce ann) {
        for (Map.Entry<ReferenceAgent, OCService> agent : agents.entrySet()) {
            if (match(ann, agent.getValue())) {
                communication.diffuserMessage(agent.getKey(), ann);
            }        }     }
    private boolean match(Annonce ann, OCService service) {
        return (matching.match(ann.getService(), service));
    }
}
