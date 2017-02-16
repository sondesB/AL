package sonde.Services;

import interfaceswcomp.OCService;

import java.util.ArrayList;

/**
 * Created by Jaafar on 03/02/2017.
 */
public interface Notification {

    /**
     * Modifie la liste des services apparus
     *
     * @param listServicesApparus les services apparus
     */
    void servicesApparus(ArrayList<OCService> listServicesApparus);

    /**
     * Modifie la liste des service disparus
     *
     * @param listServicesDisparus les services disparus
     */
    void servicesDisparus(ArrayList<OCService> listServicesDisparus);
}
