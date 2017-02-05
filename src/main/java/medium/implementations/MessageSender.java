package medium.implementations;

import interfaceswcomp.OCService;
import medium.interfaces.EnvAnnonce;
import stub.Agent;
import stub.Annonce;
import stub.Communication;
import unifieur.services.Matching;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benja135 on 03/02/17.
 */
public class MessageSender implements EnvAnnonce {

    private Matching matching;
    private Communication communication;

    @Override
    public void sendAnnonce(ArrayList<Agent> listAgents, Annonce ann) {
        for (Agent agent : listAgents) {
            if (oneServiceMatch(ann.getService(), agent.getServices())) {
                communication.envoiSimple(ann, agent);
            }
        }
    }

    /**
     * Return true if "service" match with one of the OCService in listService.
     *
     * @param service OCService
     * @param listService list of OCService
     * @return boolean
     */
    private boolean oneServiceMatch(OCService service, List<OCService> listService) {
        for (OCService current : listService) {
            if (matching.match(service, current)) {
                return true;
            }
        }
        return false;
    }
}
