package Agent.Agir.GenererMessage;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class GenererMessage implements IGenererMessage {
    private ICommunication communication;
    private ReferenceAgent referenceAgent;

    public GenererMessage(ICommunication communication, ReferenceAgent referenceAgent, M) {
        this.communication = communication;
        this.referenceAgent = referenceAgent;
    }

    public void genererMessage() {

    }

    public ICommunication getCommunication() {
        return communication;
    }

    public ReferenceAgent getReferenceAgent() {
        return referenceAgent;
    }
}
