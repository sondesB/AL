package persistance.implementations;

import interfaceswcomp.OCService;
import persistance.interfaces.IPersistance;
import persistance.interfaces.IRecuperationPlan;

import java.util.List;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceImpl implements IPersistance,IRecuperationPlan {

    @Override
    public void persisterDecisionBind(OCService service1, OCService service2) {

    }

    @Override
    public void persisterDecisionUnbind(OCService service1, OCService service2) {

    }

    @Override
    public List<OCService> recupererBasePlan(OCService service) {
        return null;
    }
}
