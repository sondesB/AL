package Agent.CycleDeVie;

import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public abstract class Etat extends IEtat {

    public abstract Optional<IEtat> executer();
}
