package sonde.Composants;

import interfaceswcomp.OCService;
import sonde.Services.*;

import java.util.*;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class GestionAgent implements Notification,DisparitionComposant {

    private ArrayList<Integer> RefAgent = new ArrayList<>(); //TypeListe : ReffAgent (class equipe infra)

    @Override
    public void servicesApparus(Set<OCService> listServicesApparus){
        //plan
        for(Iterator<OCService> iterator = listServicesApparus.iterator(); iterator.hasNext();){
            OCService service = iterator.next();
            RefferenceAgent RefAgent = createAgent(SetService(service)); //ReferenceAgent createAgent(IEtat) | IEtat SetService(OCService)
            RefAgent.add(RegAgent);
            addAgent(RefAgent,service); //addAgent(RefAgent,OCService
        }
    }

    @Override
    public void servicesDisparus(Set<OCService> listServicesDisparus){

    }
}
