package Agent.Decider.ComposantTraitementPerceptionVide;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Percevoir.CreerPerception.Perceptions.PerceptionVide;

import java.util.List;

/**
 * Created by qsaieb on 10/02/2017.
 */
public interface ITraitementPerceptionVide {

  public AbstractDecision traiter(List<PerceptionVide> listePerceptionVide);
}
