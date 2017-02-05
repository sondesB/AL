package medium.interfaces;

import stub.Agent;
import stub.Annonce;

import java.util.ArrayList;

/**
 * Interface interne du Medium.
 */
public interface EnvAnnonce {

    /**
     * Envoi une annonce.
     *
     * @param listAgents liste d'agents possible destinataire
     * @param ann        annonce
     */
    void sendAnnonce(ArrayList<Agent> listAgents, Annonce ann);
}
