package Agent;

import java.util.ArrayList;

/**
 * Created by Nicolas on 09/02/2017.
 */
public abstract class Agent {
    private List<AbstractPerception> perceptions = new ArrayList<AbstractPerception>(); // Liste des objets perception
    private List<AbstractDecision> decisions = new ArrayList<AbstractDecision>(); // Liste des objets decision
    private CycleDeVie cycle;

    public abstract void run();

    public abstract List<AbstractPerception> getPerceptions();

    public abstract List<AbstractDecision> getDecisions();

    public abstract void setPerceptions(List<AbstractPerception> perceptions);

    public abstract void setDecisions(List<AbstractDecision> decisions);

    public abstract void setCycleDeVie(CycleDeVie cycle);
}
