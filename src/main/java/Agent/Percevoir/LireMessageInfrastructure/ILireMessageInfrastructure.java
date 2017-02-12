package Agent.Percevoir.LireMessageInfrastructure;

import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;

/**
 * Created by Kévin on 10/02/2017.
 */
public interface ILireMessageInfrastructure {
    AbstractPerception lireInfrastructure(ReferenceAgent referenceAgent);
    void setCommunication(ICommunication communication);
}
