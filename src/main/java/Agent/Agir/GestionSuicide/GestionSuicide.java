package Agent.Agir.GestionSuicide;

/**
 * Created by Utilisateur on 10/02/2017.
 */
public class GestionSuicide implements IGestionSuicide {
	private ISuicideService suicideService;

	/**
	 * Appelle le service de suicide pour tuer l'agent
	 */
	@Override
	public void suicide() {
		this.suicideService.suicide();
	}

}
