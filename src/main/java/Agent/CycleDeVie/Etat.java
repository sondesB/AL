package Agent.CycleDeVie;

/**
 * Created by Benjamin on 10/02/2017.
 */
public abstract Etat extends IEtat {

    public abstract Optional<IEtat> executer();
}
