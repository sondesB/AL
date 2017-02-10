package visualisation.implementation;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.annuaire.AgentListener;
import visualisation.abstractvisualisation.AbstractJournalisation;
import visualisation.interfaces.ITransfert;

import java.util.Iterator;
import java.util.List;

/**
 * Created by alpha on 10/02/2017.
 */
public class Journalisation extends AbstractJournalisation implements AgentListener {

    List<Agent> agentList;

    @Override
    public void agentAjoute(Agent agent) {

    }

    @Override
    public void agentRetire(Agent agent) {

    }

    @Override
    protected AgentListener make_notification() {
        return null;
    }

    private void afficherAgent (Agent agent) {
        String agentsEnString = "";

        Iterator<Agent> it = this.agentList.iterator();

        while (it.hasNext()) {
            agentsEnString += it.next().getEtatInitial() + " n\\  ";
        }

        this.requires().envoyerMsgVersAffichage().lireInformations(agentsEnString);
    }

}
