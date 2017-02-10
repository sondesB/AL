package Agent.CycleDeVie;

import interfaceswcomp.OCService;

import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatDecider extends Etat{

    private ComposantDecider composantDecider;

    private OCService serviceAgent;

    public EtatDecider(OCService serviceAgent) {
        this.serviceAgent = serviceAgent;
    }

    public Optional<IEtat> executer() {
        List<AstractDecision> listeDecisions  = composantDecider.decider();
        ComposantAgir composantAgir = new ComposantAgir(serviceAgent, communication);
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
}
