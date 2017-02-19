package visualisation.implementation;


import com.m2dl.sma.infrastructure.agent.Agent;
import visualisation.abstractvisualisation.AbstractAffichage;
import visualisation.abstractvisualisation.AbstractJournalisation;
import visualisation.abstractvisualisation.AbstractVisualisation;

/**
 * Created by MarS on 19/02/2017.
 */
public class Visualisation extends AbstractVisualisation  {
    @Override
    protected AbstractAffichage make_affichage() {
        return new Affichage();
    }

    @Override
    protected AbstractJournalisation make_journalisation() {
        return new Journalisation();
    }

}
