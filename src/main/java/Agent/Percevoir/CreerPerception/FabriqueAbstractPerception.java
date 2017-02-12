package Agent.Percevoir.CreerPerception;

import Agent.Agir.GenererMessage.Message.Annonce;
import Agent.Agir.GenererMessage.Message.MessageAgent;
import Agent.Agir.GenererMessage.Message.Reponse;
import Agent.Percevoir.CreerPerception.Perceptions.*;

/**
 * Created by Kévin on 10/02/2017.
 */
public class FabriqueAbstractPerception implements ICreerPerception{

    public FabriqueAbstractPerception(){

    }
    @Override
    public AbstractPerception creerPerception(Object message) {
        if (message instanceof Boolean){
            return new PerceptionSonde((Boolean) message);
        }

        else if (message instanceof MessageAgent){
            if (message instanceof Annonce){
                return new PerceptionAnnonce((Annonce)message);
            }
            else if (message instanceof Reponse){
                return new PerceptionReponse((Reponse)message);
            }
            else{
                return new PerceptionVide(message);
            }
        }
        else{
            return new PerceptionVide(message);
        }
    }
}
