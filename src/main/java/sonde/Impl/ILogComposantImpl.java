package sonde.Impl;

import interfaceswcomp.OCComponent;
import sonde.Services.ILogComposant;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Moghite on 05/02/2017.
 */
public class ILogComposantImpl implements ILogComposant {
    @Override
    public void loggerApparition(Set<OCComponent> nouveauxComposants) {
        Iterator <OCComponent> iterator = nouveauxComposants.iterator();
        while (iterator.hasNext()) {
            // Appel la methode fournit par le composant log
        }
    }

    @Override
    public void loggerDisparition(Set<OCComponent> composantsDisparus) {
        Iterator <OCComponent> iterator = composantsDisparus.iterator();
        while (iterator.hasNext()) {
            // Appel la methode fournit par le composant log
        }
    }
}
