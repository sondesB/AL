package Agent.Agir.GenererMessage;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class GenererMessage implements IGenererMessage {
    private ICommunication communication;
    private ReferenceAgent referenceAgent;

    public GenererMessage(ICommunication communication, ReferenceAgent referenceAgent) {
        this.communication = communication;
        this.referenceAgent = referenceAgent;
    }

    
    /**
     * Génère un message
     */
    public void genererMessage() {
    	// TODO
    }

    public ICommunication getCommunication() {
        return communication;
    }

    public ReferenceAgent getReferenceAgent() {
        return referenceAgent;
    }
}
