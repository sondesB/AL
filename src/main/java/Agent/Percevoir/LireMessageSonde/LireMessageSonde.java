package Agent.Percevoir.LireMessageSonde;

import Agent.Percevoir.CreerPerception.FabriqueAbstractPerception;
import Agent.Percevoir.CreerPerception.ICreerPerception;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageSonde implements ILireMessageSonde{

    ICreerPerception creerPerception;
    IDisparitionComposant disparitionComposant;

    public LireMessageSonde() {
        this.creerPerception = new FabriqueAbstractPerception();
        this.disparitionComposant = new DisparitionComposant();
    }


    @Override
    public AbstractPerception lireSonde(ReferenceAgent referenceAgent) {
        return creerPerception.creerPerception(disparitionComposant.suicide(referenceAgent));
    }
}
