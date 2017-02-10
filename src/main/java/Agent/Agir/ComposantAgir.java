package Agent.Agir;

import Agent.Agir.GenererMessage.GenererMessage;
import Agent.Agir.GenererMessage.IGenererMessage;
import Agent.Agir.GestionBinding.GestionBinding;
import Agent.Agir.GestionBinding.IGestionBinding;
import Agent.Agir.GestionSuicide.GestionSuicide;
import Agent.Agir.GestionSuicide.IGestionSuicide;
import Agent.Agir.IComposantAgir;
import Agent.Agir.TraitementDecision.ITraitementDecision;
import Agent.Agir.TraitementDecision.TraitementDecision;
import interfaceswcomp.Binding;
import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 10/02/2017.
 */
public class ComposantAgir implements IComposantAgir {
    private List<AbstractDecision> listeDecisions;
    private OCService service;

    // Composants internes
    private ITraitementDecision traitementDecision;

    public ComposantAgir(OCService service, ICommunication communication, ISuicideService suicideService, ReferenceAgent referenceAgent, Binding binding) {
        this.traitementDecision = new TraitementDecision(new GenererMessage(communication, referenceAgent),
                new GestionSuicide(suicideService), new GestionBinding(binding));

        this.service = service;
    }

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
