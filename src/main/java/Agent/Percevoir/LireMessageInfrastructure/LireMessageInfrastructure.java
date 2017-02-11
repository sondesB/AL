package Agent.Percevoir.LireMessageInfrastructure;

import Agent.Percevoir.CreerPerception.FabriqueAbstractPerception;
import Agent.Percevoir.CreerPerception.ICreerPerception;
import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageInfrastructure implements ILireMessageInfrastructure{

    private ICreerPerception creerPerception;
    private ICommunication communication;

    public LireMessageInfrastructure() {
        this.creerPerception = new FabriqueAbstractPerception();
    }

    @Override
    public AbstractPerception lireInfrastructure(ReferenceAgent referenceAgent) {
        return creerPerception.creerPerception(communication.lireMessage(referenceAgent));
    }

    public ICommunication getCommunication() {
        return communication;
    }

    public void setCommunication(ICommunication communication) {
        this.communication = communication;
    }
}