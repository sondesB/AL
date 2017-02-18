package Agent.Agir.GenererMessage;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;

import Agent.Agir.GenererMessage.Message.Annonce;
import Agent.Agir.GenererMessage.Message.Reponse;
import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class GenererMessage implements IGenererMessage {
    private ICommunication communication;
    private ReferenceAgent referenceAgent;
    private OCService service;

    public GenererMessage(ICommunication communication, ReferenceAgent referenceAgent, OCService service) {
        this.communication = communication;
        this.referenceAgent = referenceAgent;
        this.service = service;
    }
    
    /**
     * Génère un message
     */
    public void genererMessage(String type, ReferenceAgent to) {
    	if(type == "ANNONCE") {
    		this.communication.diffuserMessage(this.referenceAgent, new Annonce(service, this.referenceAgent));
    	} else if (type == "REPONSE") {
    		this.communication.envoyerMessage(this.referenceAgent, to, new Reponse(service, to));
    	}
    }

    public ICommunication getCommunication() {
        return communication;
    }

    public ReferenceAgent getReferenceAgent() {
        return referenceAgent;
    }
}
