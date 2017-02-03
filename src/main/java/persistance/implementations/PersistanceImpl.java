package persistance.implementations;

import persistance.interfaces.IPersistance;
import persistance.interfaces.IRecuperationPlan;

import java.util.Map;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceImpl implements IPersistance,IRecuperationPlan {

    @Override
    public Map<?, ?> recupererBasePlan() {
        return null;
    }

    @Override
    public void persisterPlan(Map<?, ?> basePlan) {

    }
}
