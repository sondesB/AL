package Agent.Agir.GenererMessage.Message;

import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 10/02/2017.
 */
public class Annonce extends MessageAgent {
    public Annonce(OCService service, ReferenceAgent ref) {
        this.service = service;
        this.referenceAgent = ref;
    }
}
