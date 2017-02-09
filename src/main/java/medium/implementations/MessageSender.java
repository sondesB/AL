package medium.implementations;

import interfaceswcomp.OCService;
import medium.interfaces.EnvAnnonce;
import stub.Agent;
import stub.Annonce;
import stub.Communication;
import unifieur.services.Matching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MessageSender fait appel aux services du composant Unifieur
 * pour filtrer les agents compatibles avec l’agent émetteur de l’annonce.
 * L'envoi des annonces est réalisé grâce à l'interface Communication.
 */
public class MessageSender implements EnvAnnonce {

    private Matching matching;
    private Communication communication;

    /**
     * Envoi l'annonce ann aux agents compatibles.
     *
     * @param agents     liste d'agents possible destinataire ainsi que leurs services
     * @param ann        annonce
     */
    @Override
    public void sendAnnonce(HashMap<Agent, List<OCService>> agents, Annonce ann) {
        for (Map.Entry<Agent, List<OCService>> agent : agents.entrySet())
        {
            if (match(ann, agent.getValue())) {
                communication.envoiSimple(ann, agent.getKey());
            }
        }
    }

    /**
     * Return true if the service contained in "annonce"
     * match with one services of the list.
     *
     * @param ann       annonce
     * @param services  liste de services
     * @return boolean
     */
    private boolean match(Annonce ann, List<OCService> services) {
        for (OCService current : services) {
            if (matching.match(ann.getService(), current)) {
                return true;
            }
        }
        return false;
    }
}
