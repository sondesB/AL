package Agent.Agir.TraitementDecision;

import Agent.Agir.GenererMessage.IGenererMessage;
import Agent.Agir.GestionBinding.IGestionBinding;
import Agent.Agir.GestionSuicide.IGestionSuicide;
import Agent.Decider.ComposantCreationDecision.AbstractDecision;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class TraitementDecision implements ITraitementDecision {
    private IGenererMessage genererMessage;
    private IGestionSuicide gestionSuicide;
    private IGestionBinding gestionBinding;

    public TraitementDecision(IGenererMessage genererMessage, IGestionSuicide gestionSuicide, IGestionBinding gestionBinding) {
        this.genererMessage = genererMessage;
        this.gestionSuicide = gestionSuicide;
        this.gestionBinding = gestionBinding;
    }

    /**
     * Traite une décidion et adopte un comportement
     * @param decision
     * 			decision à traiter
     */
    public void traiter(AbstractDecision decision) {
        if(decision instanceof DecisionGenererMessage){
        	// On génère un message
            this.genererMessage.genererMessage();
        } else if(decision instanceof DecisionSuicide){
        	// On fait se suicider l'agent
            this.gestionSuicide.suicide();
        } else if(decision instanceof DecisionBinding){
        	// On bind 2 services
            this.gestionBinding.bind(service, decision.service);
        } else if(decision instanceof DecisionEmpty){
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
