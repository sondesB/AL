package Agent.Agir.TraitementDecision;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.fabrique.ISuicideService;

import Agent.Agir.GenererMessage.GenererMessage;
import Agent.Agir.GenererMessage.IGenererMessage;
import Agent.Agir.GestionBinding.GestionBinding;
import Agent.Agir.GestionBinding.IGestionBinding;
import Agent.Agir.GestionSuicide.GestionSuicide;
import Agent.Agir.GestionSuicide.IGestionSuicide;
import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Decider.ComposantCreationDecision.DecisionBinding;
import Agent.Decider.ComposantCreationDecision.DecisionGenererMessage;
import Agent.Decider.ComposantCreationDecision.DecisionSuicide;
import Agent.Decider.ComposantCreationDecision.DecisionVide;
import interfaceswcomp.Binding;
import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class TraitementDecision implements ITraitementDecision {
    private IGenererMessage genererMessage;
    private IGestionSuicide gestionSuicide;
    private IGestionBinding gestionBinding;

    public TraitementDecision(OCService service, ICommunication communication, ISuicideService suicideService, ReferenceAgent referenceAgent, Binding binding) {
        this.genererMessage = new GenererMessage(communication, referenceAgent, service);
        this.gestionSuicide = new GestionSuicide(suicideService, referenceAgent);
        this.gestionBinding = new GestionBinding(binding, service);
    }

    /**
     * Traite une décidion et adopte un comportement
     * @param decision
     * 			decision à traiter
     */
    public void traiter(AbstractDecision decision) {
        if(decision instanceof DecisionGenererMessage){
        	// On génère un message
            this.genererMessage.genererMessage(((DecisionGenererMessage) decision).getType(), ((DecisionGenererMessage) decision).getRefTo());
        } else if(decision instanceof DecisionSuicide){
        	// On fait se suicider l'agent
            this.gestionSuicide.suicide();
        } else if(decision instanceof DecisionBinding){
        	// On bind 2 services
        	this.gestionBinding.bind(((DecisionBinding) decision).getService());
        } else if(decision instanceof DecisionVide){
            // On ne fait rien.
        }
    }

    public IGenererMessage getGenererMessage() {
        return genererMessage;
    }

    public IGestionSuicide getGestionSuicide() {
        return gestionSuicide;
    }

    public IGestionBinding getGestionBinding() {
        return gestionBinding;
    }
}
