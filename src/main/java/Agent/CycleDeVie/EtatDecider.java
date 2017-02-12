package Agent.CycleDeVie;

import Agent.Agir.ComposantAgir;
import Agent.Decider.ComposantCreationDecision.AbstractDecision;
import Agent.Decider.ComposantDecider;
import com.m2dl.sma.infrastructure.etat.IEtat;
import interfaceswcomp.Binding;
import interfaceswcomp.BindingFailure;
import interfaceswcomp.OCService;
import interfaceswcomp.UnbindingFailure;

import java.util.List;
import java.util.Optional;

/**
 * Created by Benjamin on 10/02/2017.
 */
public class EtatDecider extends Etat{

    private ComposantDecider composantDecider;

    private OCService serviceAgent;


    public Optional<IEtat> executer() {
        List<AbstractDecision> listeDecisions  = composantDecider.decider();
        ComposantAgir composantAgir = new ComposantAgir(serviceAgent, super.getCommunication(), super.getSuicideService(), super.getReferenceAgent(), new Binding() {
            @Override
            public void bind(OCService service1, OCService service2) throws BindingFailure {
                // normalement on ne doit pas l'implementer, on doit nous donner l'instance
                // C'est juste pour compiler
            }

            @Override
            public void unbind(OCService service1, OCService service2) throws UnbindingFailure {
                // pareil
            }
        });
        composantAgir.setListeDecisions(listeDecisions);
        EtatAgir etatAgir = new EtatAgir();
        etatAgir.setComposantAgir(composantAgir);
        return Optional.ofNullable(etatAgir);
    }

    public ComposantDecider getComposantDecider() {
        return composantDecider;
    }

    public void setComposantDecider(ComposantDecider composantDecider) {
        this.composantDecider = composantDecider;
    }

    public OCService getServiceAgent() {
        return serviceAgent;
    }

    public void setServiceAgent(OCService serviceAgent) {
        this.serviceAgent = serviceAgent;
    }
}
