package Agent.Percevoir.LireMessageInfrastructure;

import Agent.Percevoir.CreerPerception.FabriqueAbstractPerception;
import Agent.Percevoir.CreerPerception.ICreerPerception;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageInfrastructure implements ILireMessageInfrastructure{

    ICreerPerception creerPerception;
    ICommunication communication;

    public LireMessageInfrastructure() {
        this.creerPerception = new FabriqueAbstractPerception();
        this.communication = new Communication();
    }

    @Override
    public AbstractPerception lireInfrastructure(ReferenceAgent referenceAgent) {
        return creerPerception.creerPerception(communication.lireMessage(referenceAgent));
    }
}