package Agent.Decider.ComposantTraitementDisparition;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Percevoir.CreatePerception.PerceptionSonde;

import java.util.List;

/**
 * Created by qsaieb on 10/02/2017.
 */
public interface ITraitementDisparitionComposant {

  public AbstractDecision traiter(List<PerceptionSonde> listePerceptionSonde);
}
