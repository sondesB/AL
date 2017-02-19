package medium.implementations;

import interfaceswcomp.OCService;
import medium.interfaces.EnvAnnonce;
import stub.Agent;
import stub.Annonce;
import stub.Communication;
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
    private Communication communication;

    /**
     * Envoi l'annonce ann aux agents compatibles.
     *
     * @param agents liste d'agents possible destinataire ainsi que leurs services
     * @param ann    annonce
     */
    @Override
    public void sendAnnonce(HashMap<Agent, OCService> agents, Annonce ann) {
        for (Map.Entry<Agent, OCService> agent : agents.entrySet()) {
            if (match(ann, agent.getValue())) {
                communication.envoiSimple(ann, agent.getKey());
            }
        }
    }

    /**
     * Return true if the service contained in "annonce"
     * match with the OCService service.
     *
     * @param ann     annonce
     * @param service OCService
     * @return boolean
     */
    private boolean match(Annonce ann, OCService service) {
        return (matching.match(ann.getService(), service));
    }
}
