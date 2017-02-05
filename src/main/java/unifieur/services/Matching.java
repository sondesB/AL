package unifieur.services;

import interfaceswcomp.OCService;

/**
 * Interface Matching. Service fourni par l'Unifieur.
 */
public interface Matching {

    /**
     * Match retourne si oui ou non deux OCService sont compatibles.
     *
     * @param serviceA OCService A
     * @param serviceB OCService B
     * @return boolean
     */
    boolean match(OCService serviceA, OCService serviceB);
}
