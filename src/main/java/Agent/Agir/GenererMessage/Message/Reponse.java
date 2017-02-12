package Agent.Agir.GenererMessage.Message;

import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 10/02/2017.
 */
public class Reponse extends MessageAgent {
	
	/**
	 * Creer une réponse
	 * @param service
	 * 			service de l'agent qui repond
	 * @param ref
	 * 			reference de l'agent qui repond
	 */
    public Reponse(OCService service, ReferenceAgent ref) {
        this.service = service;
        this.referenceAgent = ref;
    }
}
