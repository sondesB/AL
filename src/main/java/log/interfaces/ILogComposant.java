package log.interfaces;

import interfaceswcomp.OCComponent;

/**
 * Created by seb on 03/02/17.
 */
public interface ILogComposant {

    /**
     * Log l'apparition d'un composant.
     * @param ocComponent Le composant apparu.
     */
    public void logApparitionComposant(OCComponent ocComponent);

    /**
     * Log la disparition du composant au logger.
     * @param component Le composant disparu.
     */
    public void logDisparitionComposant(OCComponent component);
}
