package Agent.CycleDeVie;

import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatPercevoir extends Etat {

    private ComposantPercevoir composantPercevoir;

    public EtatPercevoir() {}

    public Optional<IEtat> executer() {
        List<AstractPerception> listePerceptions  = composantPercevoir.percevoir();
        ComposantDecider composantDecider = new ComposantDecider();
        composantDecider.setListePerceptions(listePerceptions);
        EtatDecider etatDecider = new EtatDecider();
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
