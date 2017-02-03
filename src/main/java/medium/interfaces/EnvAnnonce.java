package main.java.medium.interfaces;

import main.java.stub.Agent;
import main.java.stub.Annonce;

import java.util.ArrayList;

/**
 * Created by benja135 on 03/02/17.
 */
public interface EnvAnnonce {
    void sendAnnonce(ArrayList<Agent> listAgents, Annonce ann);
}
