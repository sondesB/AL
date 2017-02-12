package Agent.Percevoir.CreerPerception;

import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;

/**
 * Created by Kévin on 09/02/2017.
 */
public interface ICreerPerception {

    public AbstractPerception creerPerception(Object message);
}
