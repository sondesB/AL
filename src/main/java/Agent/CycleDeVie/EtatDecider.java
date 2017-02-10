package Agent.CycleDeVie;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Decider.ComposantDecider;
import interfaceswcomp.OCService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatDecider extends Etat{

    private ComposantDecider composantDecider;

    private OCService serviceAgent;


    public Optional<IEtat> executer() {
        List<AbstractDecision> listeDecisions  = composantDecider.decider();
        ComposantAgir composantAgir = new ComposantAgir(serviceAgent, communication, suicideService, referenceAgent);
        composantAgir.setListeDecisions(listeDecisions);
        EtatAgir etatAgir = new EtatAgir();
        etatAgir.setComposantAgir(composantAgir);
        return Optional.ofNullable(etatAgir);
    }

    public ComposantDecider getComposantDecider() {
        return composantDecider;
    }

    public void setComposantDecider(ComposantDecider composantDecider) {
        this.composantDecider = composantDecider;
    }

    public OCService getServiceAgent() {
        return serviceAgent;
    }

    public void setServiceAgent(OCService serviceAgent) {
        this.serviceAgent = serviceAgent;
    }
}
