package visualisation.implementation;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.annuaire.AgentListener;
import visualisation.abstractvisualisation.AbstractJournalisation;
import visualisation.interfaces.ITransfert;

import java.util.List;

/**
 * Created by alpha on 10/02/2017.
 */
public class Journalisation extends AbstractJournalisation implements AgentListener {

    List<Agent> agentList;

    @Override
    protected ITransfert make_donneEnvoyer() {
        return new Transfert();
    }

    @Override
    protected AgentListener make_notification() {
        return this;
    }


    @Override
    public void agentAjoute(Agent agent) {

    }

    @Override
    public void agentRetire(Agent agent) {

    }
}
