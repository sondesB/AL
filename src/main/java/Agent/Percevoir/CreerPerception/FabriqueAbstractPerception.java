package Agent.Percevoir.CreerPerception;

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
            return new PerceptionSonde(message);
        }

        else if (message instanceof MessageAgent){
            if (message instanceof Annonce){
                return new PerceptionAnnonce(message);
            }
            else if (message instanceof Reponse){
                return new PerceptionReponse(message);
            }
            else{
                return new PerceptionVide(message);
            }
        }
        else{
            return new PerceptionVide(message);
        }
        return null;
    }
}
