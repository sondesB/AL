package Agent.CycleDeVie;

import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatAgir extends Etat {

    private ComposantAgir composantAgir;


    public Optional<IEtat> executer() {
        composantAgir.agir();
        Optional.ofNullable(null);
    }

    public ComposantAgir getComposantAgir() {
        return composantAgir;
    }

    public void setComposantAgir(ComposantAgir composantAgir) {
        this.composantAgir = composantAgir;
    }
}
