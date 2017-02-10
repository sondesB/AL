package sonde.Composants;

import interfaceswcomp.Acquisition;
import interfaceswcomp.AcquisitionFailure;
import interfaceswcomp.OCComponent;
import sonde.Services.Configuration;
import sonde.Services.Notification;

import java.util.Set;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class GestionComposant implements Configuration {

    private Notification notification;
    private Acquisition acquisition;
    //ILogComposant logger;
    //Périodicité du sondage
    private int periodicite;
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
    public void  getComposant() throws AcquisitionFailure {
        Set<OCComponent> composants = acquisition.getNewComponents();
        for(OCComponent c : composants) {
            //Logger Composant
            notification.servicesApparus(c.getProvidedServices());
            notification.servicesApparus(c.getRequiredServices());
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
        Set<OCComponent> composants = acquisition.getDisappearedComponents();
        for(OCComponent c : composants) {
            //Logger Composant
            notification.servicesDisparus(c.getProvidedServices());
            notification.servicesDisparus(c.getRequiredServices());
        }
    }
}
