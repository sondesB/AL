package Agent.Agir.GenererMessage;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;

import Agent.Agir.GenererMessage.Message.Annonce;
import Agent.Agir.GenererMessage.Message.MessageAgent;
import Agent.Agir.GenererMessage.Message.Reponse;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class GenererMessage implements IGenererMessage {
    private ICommunication communication;
    private ReferenceAgent referenceAgent;
    private MessageAgent messageAgent;

    public GenererMessage(ICommunication communication, ReferenceAgent referenceAgent, MessageAgent message) {
        this.communication = communication;
        this.referenceAgent = referenceAgent;
        this.messageAgent = message;
    }
    
    /**
     * Génère un message
     */
    public void genererMessage(ReferenceAgent to) {
    	if(this.messageAgent instanceof Annonce) {
    		this.communication.diffuserMessage(this.referenceAgent, this.messageAgent);
    	} else if (this.messageAgent instanceof Reponse) {
    		this.communication.envoyerMessage(this.referenceAgent, to, this.messageAgent);
    	}
    }

    public ICommunication getCommunication() {
        return communication;
    }

    public ReferenceAgent getReferenceAgent() {
        return referenceAgent;
    }
}
