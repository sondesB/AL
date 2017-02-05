package sonde.Services;

import interfaceswcomp.OCComponent;

import java.util.Set;

/**
 * Created by Moghite on 05/02/2017.
 */
public interface ILogComposant {
    /**
     * Tracer le log des nouveaux Composants via la méthode fournit par le composant Log
     * @param nouveauxComposants la liste des nouveaux composants
     */
    void loggerApparition(Set<OCComponent> nouveauxComposants);

    /**
     * Tracer le log des composants disparus via la méthode fournit par le composant Log
     * @param composantsDisparus la liste des composants disparus
     */
    void loggerDisparition(Set<OCComponent> composantsDisparus);
}
