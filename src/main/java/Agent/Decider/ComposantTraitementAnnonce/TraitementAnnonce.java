package Agent.Decider.ComposantTraitementAnnonce;

import java.util.List;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Decider.ComposantCreationDecision.DecisionGenererMessage;
import Agent.Percevoir.CreerPerception.Perceptions.PerceptionAnnonce;

/**
 * Created by qsaieb on 10/02/2017.
 */
public class TraitementAnnonce implements ITraitementAnnonce {

	@Override
	public AbstractDecision traiter(List<PerceptionAnnonce> listePerceptionAnnonce) {
		return new DecisionGenererMessage("ANNONCE");
	}
}
