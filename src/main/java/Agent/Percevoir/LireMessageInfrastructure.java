package Agent.Percevoir;

/**
 * Created by Kévin on 09/02/2017.
 */
public class LireMessageInfrastructure {

    ICreatePerception createPerception;

    public LireMessageInfrastructure(ICreatePerception createPerception) {
        this.createPerception = createPerception;
    }
}
