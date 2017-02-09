package medium.interfaces;

import interfaceswcomp.OCService;
import stub.Agent;
import stub.Annonce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    void sendAnnonce(HashMap<Agent, List<OCService>> agents, Annonce ann);
}
