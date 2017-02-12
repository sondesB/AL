package sonde.Composants;

import interfaceswcomp.Acquisition;
import interfaceswcomp.AcquisitionFailure;
import interfaceswcomp.OCComponent;
import interfaceswcomp.OCService;
import log.interfaces.ILogComposant;
import sonde.Services.Configuration;
import sonde.Services.Notification;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class GestionComposant implements Configuration {

    private Notification notification;
    private Acquisition acquisition;
    private ILogComposant logger;
    private int periodicite;

    public int getPeriodicite(){
        return periodicite;
    }
    @Override
    public void definirPeriodicite(int valeur) {
        this.periodicite = valeur;
    }

    /**
     * get components that have appeared, log them and send a list
     * of their services to GestionAgent
     *
     * @return void
     * @throws Exception
     */
    public void getComposantApparu() throws AcquisitionFailure {
        Set<OCComponent> listComposants = acquisition.getNewComponents();
        for (OCComponent composant : listComposants) {
            logger.logApparitionComposant(composant);

            ArrayList<OCService> servicesFournis = composant.getProvidedServices();
            ArrayList<OCService> servicesRequis = composant.getRequiredServices();

            if (servicesFournis != null) {
                notification.servicesApparus(servicesFournis);
            }

            if (servicesRequis != null) {
                notification.servicesApparus(servicesRequis);
            }
        }
    }

    /**
     * get components that have disappeared, log them and send a list
     * of their services to GestionAgent
     *
     * @return void
     * @throws Exception
     */
    public void getComposantDisparu() throws AcquisitionFailure {
        Set<OCComponent> listComposants = acquisition.getDisappearedComponents();
        for (OCComponent composant : listComposants) {
            logger.logDisparitionComposant(composant);

            ArrayList<OCService> servicesFournis = composant.getProvidedServices();
            ArrayList<OCService> servicesRequis = composant.getRequiredServices();

            if (servicesFournis != null) {
                notification.servicesDisparus(servicesFournis);
            }

            if (servicesRequis != null) {
                notification.servicesDisparus(servicesRequis);
            }
        }
    }
}
