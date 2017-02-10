package Agent.Percevoir.LireMessageInfrastructure;

import Agent.Percevoir.CreatePerception.ICreatePerception;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageInfrastructure {

    ICreatePerception createPerception;

    public LireMessageInfrastructure(ICreatePerception createPerception) {
        this.createPerception = createPerception;
    }
}
