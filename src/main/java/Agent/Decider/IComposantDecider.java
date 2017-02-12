package Agent.Decider;

import Agent.Decider.ComposantCreationDecision.AbstractDecision;

import java.util.List;

/**
 * Created by qsaieb on 10/02/2017.
 */
public interface IComposantDecider {
  List<AbstractDecision> decider();
}
