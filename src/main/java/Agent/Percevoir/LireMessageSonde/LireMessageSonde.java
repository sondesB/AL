package Agent.Percevoir.LireMessageSonde;

import Agent.Percevoir.CreerPerception.FabriqueAbstractPerception;
import Agent.Percevoir.CreerPerception.ICreerPerception;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageSonde implements ILireMessageSonde{

    ICreerPerception creerPerception;

    public LireMessageSonde() {
        this.creerPerception = new FabriqueAbstractPerception();
    }


    @Override
    public AbstractPerception lireSonde() {

        return creerPerception.creerPerception();
    }
}
