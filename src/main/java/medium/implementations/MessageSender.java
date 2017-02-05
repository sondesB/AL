package medium.implementations;

import interfaceswcomp.OCService;
import medium.interfaces.EnvAnnonce;
import stub.Agent;
import stub.Annonce;
import stub.Communication;
import unifieur.services.Matching;

import java.util.ArrayList;

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
     * @param listAgents liste d'agents possible destinataire
     * @param ann        annonce
     */
    @Override
    public void sendAnnonce(ArrayList<Agent> listAgents, Annonce ann) {
        for (Agent agent : listAgents) {
            if (match(ann, agent)) {
                communication.envoiSimple(ann, agent);
            }
        }
    }

    /**
     * Return true if the service contained in "annonce"
     * match with one services of the "agent".
     *
     * @param ann   annonce
     * @param agent agent
     * @return boolean
     */
    private boolean match(Annonce ann, Agent agent) {
        for (OCService current : agent.getServices()) {
            if (matching.match(ann.getService(), current)) {
                return true;
            }
        }
        return false;
    }
}
