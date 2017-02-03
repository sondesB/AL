package persistance.interfaces;

import java.util.Map;

/**
 * Created by seb on 03/02/17.
 */
public interface IPersistance {

    /**
     * persiste la base de plan d'un agent
     * @param basePlan La base de plan à conserver.
     */
    void persisterPlan(Map<?,?> basePlan);

}
