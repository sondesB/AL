package Agent.Percevoir.LireMessageSonde;

import Agent.Percevoir.CreerPerception.FabriqueAbstractPerception;
import Agent.Percevoir.CreerPerception.ICreerPerception;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import sonde.Composants.GestionAgent;
import sonde.Services.DisparitionComposant;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageSonde implements ILireMessageSonde{

    ICreerPerception creerPerception;
    DisparitionComposant disparitionComposant;

    public LireMessageSonde() {
        this.creerPerception = new FabriqueAbstractPerception();
        this.disparitionComposant = new GestionAgent();
    }


    @Override
    public AbstractPerception lireSonde(ReferenceAgent referenceAgent) {
        return creerPerception.creerPerception(disparitionComposant.verifierServiceDisparu(referenceAgent));
    }
}
