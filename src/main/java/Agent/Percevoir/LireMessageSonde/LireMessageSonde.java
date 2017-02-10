package Agent.Percevoir.LireMessageSonde;

import Agent.Percevoir.CreatePerception.ICreatePerception;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageSonde {

    ICreatePerception createPerception;

    public LireMessageSonde(ICreatePerception createPerception) {
        this.createPerception = createPerception;
    }
}
