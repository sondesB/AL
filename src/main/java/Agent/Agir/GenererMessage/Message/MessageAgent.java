package Agent.Agir.GenererMessage.Message;

import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 10/02/2017.
 * Super-classe représentant un message
 */
public abstract class MessageAgent implements IMessageAgent {
    protected OCService service;
    protected ReferenceAgent referenceAgent;

    public OCService getService() {
        return service;
    }

    public ReferenceAgent getReferenceAgent() {
        return referenceAgent;
    }
}
