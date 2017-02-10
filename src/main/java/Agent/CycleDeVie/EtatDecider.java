package Agent.CycleDeVie;

import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatDecider extends Etat{

    private ComposantDecider composantDecider;

    public EtatDecider() {}

    public Optional<IEtat> executer() {
        List<AstractDecision> listeDecisions  = composantDecider.decider();
        ComposantAgir composantAgir = new ComposantAgir();
        composantAgir.setListeDecisions(listeDecisions);
        EtatAgir etatAgir = new EtatAgir();
        etatAgir.setComposantAgit(composantAgir);
        return Optional.ofNullable(etatAgir);
    }

    public ComposantDecider getComposantDecider() {
        return composantDecider;
    }

    public void setComposantDecider(ComposantDecider composantDecider) {
        this.composantDecider = composantDecider;
    }
}
