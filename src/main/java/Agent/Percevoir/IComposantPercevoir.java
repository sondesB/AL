package Agent.Percevoir;

import Agent.Percevoir.CreerPerception.Perceptions.AbstractPerception;

import java.util.List;

/**
 * Created by Kévin on 10/02/2017.
 */
public interface IComposantPercevoir {
    public List<AbstractPerception> percevoir();
}
