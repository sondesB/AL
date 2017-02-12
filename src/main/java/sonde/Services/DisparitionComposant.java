package sonde.Services;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

/**
 * Created by Jaafar on 03/02/2017.
 */
public interface DisparitionComposant {

    /**
     * Permet à un agent de vérifier si son service a disparu
     *
     * @param ref référence de l'agent
     * @return true si le service de l'agent a disparu sinon false
     */
    boolean verifierServiceDisparu(ReferenceAgent ref);
}
