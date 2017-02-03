package unifieur.services;

import interfaceswcomp.OCService;

/**
 * Created by benja135 on 03/02/17.
 */
public interface Matching {
    boolean match(OCService serviceA, OCService serviceB);
}
