package sonde.Composants;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.fabrique.ICreationService;
import interfaceswcomp.OCService;
import sonde.Services.DisparitionComposant;
import sonde.Services.Notification;
//import Agent.CycleDeVie.EtatPercevoir ;
//import medium.services.enregistrement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class GestionAgent implements Notification, DisparitionComposant {

    private ICreationService creationService;
    //private EtatPercevoir etatPercevoir;
    //private Enregistrement enregistrement;
    /**
     * Une map de chaque service et son agent
     */
    private Map<OCService, ReferenceAgent> listRefAgent = new HashMap<OCService, ReferenceAgent>();
    /**
     * Chaque agent vient verifier si son service a disparu ou pas
     */
    private Map<ReferenceAgent, OCService> messageToAgent = new HashMap<ReferenceAgent, OCService>();

    @Override
    public void servicesApparus(ArrayList<OCService> listServicesApparus) {
        /**
         *
         */
        for (OCService service : listServicesApparus) {
            //ReferenceAgent refAgent = creationService.creer(etatPercevoir.setServiceAgent(service)); //ReferenceAgent createAgent(IEtat) | IEtat SetService(OCService)
            //listRefAgent.put(service, refAgent);
            //enregistrement.addAgent(refAgent, service); //addAgent(RefAgent,OCService
        }
    }

    @Override
    public void servicesDisparus(ArrayList<OCService> listServicesDisparus) {
        for (OCService service : listServicesDisparus) {
            ReferenceAgent refAgent = listRefAgent.get(service);
            messageToAgent.put(refAgent, service);
        }
    }

    @Override
    public boolean verifierServiceDisparu(ReferenceAgent ref) {
        OCService service = messageToAgent.get(ref);
        if(service == null) {
            return false;
        } else {
            messageToAgent.remove(ref);
            return true;
        }
    }
}
