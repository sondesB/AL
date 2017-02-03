package medium.implementations;

import medium.interfaces.EnvAnnonce;
import stub.Agent;
import stub.Annonce;
import stub.Communication;
import stub.Matching;

import java.util.ArrayList;

/**
 * Created by benja135 on 03/02/17.
 */
public class MessageSenderBroadcast implements EnvAnnonce {

    private Matching matching;
    private Communication communication;

    @Override
    public void sendAnnonce(ArrayList<Agent> listAgents, Annonce ann) {
        for(Agent agent: listAgents) {
            communication.envoiSimple(ann, agent);
        }
    }
}
