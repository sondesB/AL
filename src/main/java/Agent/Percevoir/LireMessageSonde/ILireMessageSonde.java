package Agent.Percevoir.LireMessageSonde;

import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

/**
 * Created by Kévin on 10/02/2017.
 */
public interface ILireMessageSonde {
    public AbstractPerception lireSonde(ReferenceAgent referenceAgent);
}
