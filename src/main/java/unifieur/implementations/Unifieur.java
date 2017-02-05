package unifieur.implementations;

import interfaceswcomp.OCService;
import unifieur.services.Matching;

/**
 * Created by benja135 on 03/02/17.
 */
public class Unifieur implements Matching {

    @Override
    public boolean match(OCService serviceA, OCService serviceB) {
        return serviceA.getServiceName().equals(serviceB.getServiceName());
    }
}
