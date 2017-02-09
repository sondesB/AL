package sonde.Composants;

import interfaceswcomp.OCService;
import sonde.Services.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class GestionAgent implements Notification {

    //Liste des nouveaux services
    Set<OCService> listServicesApparus;
    //Liste des service disparus
    Set<OCService> listServicesDisparus;
    //map correspondance entre service et agent
    Map<Integer, Integer> mapServiceAgent = new HashMap<>();

    @Override
    public void servicesApparus(Set<OCService> listServicesApparus) {
        this.listServicesApparus = listServicesApparus;
    }

    @Override
    public void servicesDisparus(Set<OCService> listServicesDisparus) {
        this.listServicesDisparus = listServicesDisparus;
    }
}
