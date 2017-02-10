package Agent.Decider.ComposantTraitementDisparition;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Decider.ComposantCreationDecision.DecisionSuicide;
import Agent.Decider.ComposantCreationDecision.ICreationDecision;
import Agent.Percevoir.CreatePerception.PerceptionSonde;

import java.util.List;

/**
 * Created by qsaieb on 10/02/2017.
 */
public class TraitementDisparitionComposant implements ICreationDecision , ITraitementDisparitionComposant{








  @Override
  public AbstractDecision creerDecision() {
    return new DecisionSuicide();
  }

  @Override
  public AbstractDecision traitementMessageSonde(List<PerceptionSonde> listePerceptionSonde) {
    boolean composantEtDeconnecte = false;
    for(PerceptionSonde perceptionSonde : listePerceptionSonde) {
      if(perceptionSonde.deconnecte) {
        return creerDecision();
      }
    }
  }
}
