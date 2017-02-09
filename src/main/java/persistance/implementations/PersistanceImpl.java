package persistance.implementations;

import interfaceswcomp.OCService;
import persistance.interfaces.BaseDePlanAbstraite;
import persistance.interfaces.IPersistance;
import persistance.interfaces.IRecuperationPlan;
import persistance.services.PersistanceService;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceImpl implements IPersistance,IRecuperationPlan {

    PersistanceService persistanceService = new PersistanceService();

    @Override
    public void persisterBaseDePlan(BaseDePlanAbstraite baseDePlan) {
        this.persistanceService.persisterBaseDePlan(baseDePlan);
    }

    @Override
    public BaseDePlanAbstraite recupererBasePlan(OCService service) {
        return this.persistanceService.getBaseDePlan(service);
    }
}
