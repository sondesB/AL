package Agent.Decider.ComposantTraitementAnnonce;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Percevoir.CreatePerception.PerceptionAnnonce;

import java.util.List;

/**
 * Created by qsaieb on 10/02/2017.
 */
public interface ITraitementAnnonce {

  public AbstractDecision traiter(List<PerceptionAnnonce> listePerceptionAnnonce);
}
