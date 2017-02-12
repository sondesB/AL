package Agent.Percevoir.CreerPerception.Perceptions;

import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;

/**
 * Created by Kévin on 10/02/2017.
 */
public class PerceptionSonde extends AbstractPerception {
    private boolean suicideDemande;

    public PerceptionSonde(boolean suicide){
        this.suicideDemande = suicide;
    }

    public boolean getSuicideDemande(){
        return suicideDemande;
    }
}