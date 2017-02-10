package visualisation.implementation;

import com.m2dl.sma.infrastructure.annuaire.AgentListener;
import visualisation.abstractvisualisation.AbstractJournalisation;
import visualisation.interfaces.ITransfert;

/**
 * Created by alpha on 10/02/2017.
 */
public class Journalisation extends AbstractJournalisation {
    @Override
    protected ITransfert make_donneEnvoyer() {
        return new Transfert();
    }

    @Override
    protected AgentListener make_notification() {
        return null;
    }
}
