package Agent.Agir.GestionSuicide;

/**
 * Created by Utilisateur on 10/02/2017.
 */
public class GestionSuicide implements IGestionSuicide {
	private ISuicideService suicideService;
	private ReferenceAgent referenceAgent;
	
	public GestionSuicide(ISuicideService suicideService, ReferenceAgent ref) {
		this.suicideService = suicideService;
		this.referenceAgent = ref;
	}

	/**
	 * Appelle le service de suicide pour tuer l'agent
	 */
	@Override
	public void suicide() {
		this.suicideService.seSuicider(this.referenceAgent);
	}

	public ISuicideService getSuicideService() {
		return suicideService;
	}

	public ReferenceAgent getReferenceAgent() {
		return referenceAgent;
	}

}
