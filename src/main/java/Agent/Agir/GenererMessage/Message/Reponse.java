package Agent.Agir.GenererMessage.Message;

import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 10/02/2017.
 */
public class Reponse extends MessageAgent {
    public Reponse(OCService service, ReferenceAgent ref) {
        this.service = service;
        this.referenceAgent = ref;
    }
}
