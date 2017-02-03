package medium.interfaces;

import stub.Agent;
import stub.Annonce;

import java.util.ArrayList;

/**
 * Created by benja135 on 03/02/17.
 */
public interface EnvAnnonce {
    void sendAnnonce(ArrayList<Agent> listAgents, Annonce ann);
}
