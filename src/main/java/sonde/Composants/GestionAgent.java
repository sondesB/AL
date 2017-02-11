package sonde.Composants;

import interfaceswcomp.OCService;
import sonde.Services.*;

import java.util.*;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class GestionAgent implements Notification, DisparitionComposant {

    private ICreationService creationService;
    private Etatpercevoir etatpercevoir;
    private ArrayList<ReferenceAgent> RefAgent = new ArrayList<ReferenceAgent>(); //TypeListe : ReffAgent (class equipe infra)

    @Override
    public void servicesApparus(Set<OCService> listServicesApparus) {
        //plan
        for (Iterator<OCService> iterator = listServicesApparus.iterator(); iterator.hasNext(); ) {
            OCService service = iterator.next();
            ReferenceAgent  RefAgent = creationService.creer(etatpercevoir.setServiceAgent(service)); //ReferenceAgent createAgent(IEtat) | IEtat SetService(OCService)
            RefAgent.add(RefAgent );
            addAgent(RefAgent,service); //addAgent(RefAgent,OCService
        }
    }

    @Override
    public void servicesDisparus(Set<OCService> listServicesDisparus) {

    }
}
