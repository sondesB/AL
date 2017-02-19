package medium.interfaces;

import interfaceswcomp.OCService;
import stub.Agent;
import stub.Annonce;

import java.util.HashMap;

/**
 * Interface interne du Medium.
 */
public interface EnvAnnonce {

    /**
     * Envoi une annonce.
     *
     * @param agents map d'agents possible destinataire ainsi que leurs services
     * @param ann    annonce
     */
    void sendAnnonce(HashMap<Agent, OCService> agents, Annonce ann);
}
