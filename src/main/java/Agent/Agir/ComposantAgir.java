package Agent.Agir;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Agir.IComposantAgir;
import Agent.Agir.TraitementDecision.ITraitementDecision;
import Agent.Agir.TraitementDecision.TraitementDecision;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.fabrique.ISuicideService;
import interfaceswcomp.Binding;
import interfaceswcomp.OCService;

import java.util.List;

/**
 * Created by Utilisateur on 10/02/2017.
 */
public class ComposantAgir implements IComposantAgir {
    private List<AbstractDecision> listeDecisions;
    private OCService service;

    private ITraitementDecision traitementDecision;

    public ComposantAgir(OCService service, ICommunication communication, ISuicideService suicideService, ReferenceAgent referenceAgent, Binding binding) {
        this.service = service;
        this.traitementDecision = new TraitementDecision(this.service, communication, suicideService, referenceAgent, binding);
    }

    /**
     * Appelle le composant pour effectuer un traitement
     */
    @Override
    public void agir() {
        for(AbstractDecision decision : this.listeDecisions){
            this.traitementDecision.traiter(decision);
        }
    }

    public List<AbstractDecision> getListeDecisions() {
        return listeDecisions;
    }

    public void setListeDecisions(List<AbstractDecision> listeDecisions) {
        this.listeDecisions = listeDecisions;
    }
}
