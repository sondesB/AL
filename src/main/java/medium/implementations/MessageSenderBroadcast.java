package main.java.medium.implementations;

import main.java.medium.interfaces.EnvAnnonce;
import main.java.stub.Agent;
import main.java.stub.Annonce;
import main.java.stub.Communication;
import main.java.stub.Matching;

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
