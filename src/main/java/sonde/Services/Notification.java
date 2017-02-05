package sonde.Services;

import interfaceswcomp.OCComponent;

import java.util.Set;

/**
 * Created by Jaafar on 03/02/2017.
 */
public interface Notification {

    /**
     * Communiquer les composants apparus
     * @param composants les composants apparus
     */
    void createAgents(Set<OCComponent> composants);

    /**
     * Communiquer les composants disparus
     * @param composantsDisparus les composants disparus
     */
    void notifyDisappearedComponents(Set<OCComponent> composantsDisparus);
}
