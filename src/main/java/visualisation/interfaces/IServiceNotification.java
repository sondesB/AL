package visualisation.interfaces;

import com.m2dl.sma.infrastructure.agent.Agent;

public interface IServiceNotification {

	public void journaliserAjout(Agent agent);
	public void journaliserRetirer(Agent agent);
}
