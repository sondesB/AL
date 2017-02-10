package log.implementations;

import interfaceswcomp.Binding;
import interfaceswcomp.BindingFailure;
import interfaceswcomp.OCService;
import interfaceswcomp.UnbindingFailure;
import log.interfaces.ILogDecision;

/**
 * Created by seb on 03/02/17.
 */
public class RelaisImpl implements Binding {

    private ILogDecision log;
    private Binding binding;

    /**
     * Constructeur
     * @param binding L'interface Binding.
     * @param log L'interface ILogDecision
     */
    public RelaisImpl(Binding binding, ILogDecision log) {
        this.binding = binding;
        this.log = log;
    }

    @Override
    public void bind(OCService service1, OCService service2) throws BindingFailure {
        try {
            this.binding.bind(service1, service2);
        } catch (BindingFailure e) {
            e.printStackTrace();
        }
        this.log.logBinding(service1, service2);
    }

    @Override
    public void unbind(OCService service1, OCService service2) throws UnbindingFailure {
        try {
            this.binding.unbind(service1, service2);
        } catch (UnbindingFailure unbindingFailure) {
            unbindingFailure.printStackTrace();
        }
        this.log.logUnbinding(service1, service2);
    }
}
