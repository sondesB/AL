package persistance.services;

import interfaceswcomp.OCService;
import persistance.interfaces.BaseDePlanAbstraite;

/**
 * Created by seb on 03/02/17.
 */
public class PersistanceService {

    /**
     * Permet de récuperer la base de plan d'un service donnée.
     * @param ocService Le service.
     * @return La base de plan.
     */
    public BaseDePlanAbstraite getBaseDePlan(OCService ocService) {
        return null;
    }

    /**
     * Permet de sauvegarder une base de plan dans une base de données.
     * @param baseDePlan La base de plan.
     */
    public void persisterBaseDePlan(BaseDePlanAbstraite baseDePlan) {

    }
}
