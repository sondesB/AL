package Agent.CycleDeVie;

import interfaceswcomp.OCService;

import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatPercevoir extends Etat {

    private ComposantPercevoir composantPercevoir;

    private OCService serviceAgent;

    public EtatPercevoir(OCService serviceAgent) {
        this.serviceAgent = serviceAgent;
    }

    public Optional<IEtat> executer() {
        List<AstractPerception> listePerceptions  = composantPercevoir.percevoir();
        ComposantDecider composantDecider = new ComposantDecider(serviceAgent);
        composantDecider.setListePerceptions(listePerceptions);
        EtatDecider etatDecider = new EtatDecider(serviceAgent);
        etatDecider.setComposantDecider(composantDecider);
        return Optional.ofNullable(etatDecider);
    }

    public ComposantPercevoir getComposantPercevoir() {
        return composantPercevoir;
    }

    public void setComposantPercevoir(ComposantPercevoir composantPercevoir) {
        this.composantPercevoir = composantPercevoir;
    }
}
