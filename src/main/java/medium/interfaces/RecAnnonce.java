package medium.interfaces;

import Agent.Agir.GenererMessage.Message.Annonce;

/**
 * Interface interne du Medium.
 */
public interface RecAnnonce {

    /**
     * Transmet une annonce.
     *
     * @param ann annonce
     */
    void addAnnonce(Annonce ann);
}
