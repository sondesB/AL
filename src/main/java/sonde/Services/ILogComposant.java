package sonde.Services;

import interfaceswcomp.OCComponent;

import java.util.Set;

/**
 * Created by Moghite on 05/02/2017.
 */
public interface ILogComposant {
    /**
     * Tracer le log des nouveaux Composants
     * @param nouveauxComposants la liste des nouveaux composants
     */
    void getLogApparitionComposant(Set<OCComponent> nouveauxComposants);

    /**
     * Tracer le log des composants disparus
     * @param composantsDisparus la liste des composants disparus
     */
    void getLogDispparitionComposant(Set<OCComponent> composantsDisparus);
}
