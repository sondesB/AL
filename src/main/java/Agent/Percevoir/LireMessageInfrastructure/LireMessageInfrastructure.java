package Agent.Percevoir.LireMessageInfrastructure;

import Agent.Percevoir.CreerPerception.FabriqueAbstractPerception;
import Agent.Percevoir.CreerPerception.ICreerPerception;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageInfrastructure implements ILireMessageInfrastructure{

    ICreerPerception creerPerception;

    public LireMessageInfrastructure() {
        this.creerPerception = new FabriqueAbstractPerception();
    }

    @Override
    public AbstractPerception lireInfrastructure() {


        return creerPerception.creerPerception();
    }
}