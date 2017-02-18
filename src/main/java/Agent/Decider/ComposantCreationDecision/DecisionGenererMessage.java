package Agent.Decider.ComposantCreationDecision;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

/**
 * Created by qsaieb on 10/02/2017.
 */
public class DecisionGenererMessage extends AbstractDecision {
	private String type;
	private ReferenceAgent refTo;
	
	public DecisionGenererMessage(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public ReferenceAgent getRefTo() {
		return refTo;
	}
}
