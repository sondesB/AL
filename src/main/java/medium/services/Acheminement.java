package medium.services;

import stub.Annonce;

/**
 * Interface Acheminement. Service fourni par le Medium.
 * Permet aux agents de transmettre leurs annonces au Medium.
 */
public interface Acheminement {

    /**
     * Permet aux agents de transmettre leurs annonces au Medium.
     *
     * @param ann annonce
     */
    void annoncer(Annonce ann);
}
