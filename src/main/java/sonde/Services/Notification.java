package sonde.Services;

import interfaceswcomp.OCComponent;
import interfaceswcomp.OCService;

import java.util.Set;

/**
 * Created by Jaafar on 03/02/2017.
 */
public interface Notification {

    /**
     * Modifie la liste des services apparus
     * @param listServicesApparus les services apparus
     */
    void servicesApparus(Set<OCService> listServicesApparus);

    /**
     * Modifie la liste des service disparus
     * @param listServicesDisparus les services disparus
     */
    void servicesDisparus(Set<OCService> listServicesDisparus);
}
