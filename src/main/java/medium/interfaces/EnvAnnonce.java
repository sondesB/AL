package medium.interfaces;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import interfaceswcomp.OCService;

import Agent.Agir.GenererMessage.Message.Annonce;

import java.util.HashMap;

/**
 * Interface interne du Medium.
 */
public interface EnvAnnonce {

    /**
     * Envoi une annonce.
     *
     * @param refAgents map d'agents possible destinataire ainsi que leurs services
     * @param ann       annonce
     */
    void sendAnnonce(HashMap<ReferenceAgent, OCService> refAgents, Annonce ann);
}
