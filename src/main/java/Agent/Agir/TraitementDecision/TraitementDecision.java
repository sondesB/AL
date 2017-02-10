package Agent.Agir.TraitementDecision;

import Agent.Agir.GenererMessage.IGenererMessage;
import Agent.Agir.GestionBinding.IGestionBinding;
import Agent.Agir.GestionSuicide.IGestionSuicide;

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

    public void traiter(AbstractDecision decision) {
        if(decision instanceof DecisionGenererMessage){
            this.genererMessage.genererMessage();
        } else if(decision instanceof DecisionSuicide){
            this.gestionSuicide.suicide();
        } else if(decision instanceof DecisionBinding){
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
