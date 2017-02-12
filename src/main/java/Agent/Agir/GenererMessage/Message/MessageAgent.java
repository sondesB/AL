package Agent.Agir.GenererMessage.Message;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.IMessageAgent;

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

    public ReferenceAgent getExpediteur() {
        return referenceAgent;
    }
}
