package unifieur.implementations;

import interfaceswcomp.OCService;
import unifieur.services.Matching;

/**
 * Le rôle de l'Unifieur est de proposer un service
 * permettant de savoir si deux OCService sont compatibles.
 */
public class Unifieur implements Matching {

    /**
     * Match retourne si oui ou non deux OCService sont compatibles.
     *
     * @param serviceA OCService A
     * @param serviceB OCService B
     * @return boolean
     */
    @Override
    public boolean match(OCService serviceA, OCService serviceB) {
        return serviceA.getServiceName().equals(serviceB.getServiceName());
    }
}
