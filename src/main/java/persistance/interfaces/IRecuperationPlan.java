package persistance.interfaces;

import interfaceswcomp.OCService;

/**
 *
 */
public interface IRecuperationPlan {

    /**
     * Récupere la base de plan relatif à un service.
     * @param service Le service dont on veut récupérer la base de plan.
     * @return La base de plan de l'agent.
     */
    BaseDePlanAbstraite recupererBasePlan(OCService service);

}