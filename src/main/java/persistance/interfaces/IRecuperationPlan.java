package persistance.interfaces;

import interfaceswcomp.OCService;

import java.util.List;

/**
 *
 */
public interface IRecuperationPlan {

    /**
     * Récupere la base de plan relatif à un service.
     * @param service Le service dont on veut récupérer la base de plan.
     * @return La base de plan (sous forme de liste) de l'agent.
     */
    List<OCService> recupererBasePlan(OCService service);

}