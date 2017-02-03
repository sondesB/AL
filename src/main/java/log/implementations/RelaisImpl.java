package log.implementations;

import interfaceswcomp.Binding;
import interfaceswcomp.BindingFailure;
import interfaceswcomp.OCService;
import interfaceswcomp.UnbindingFailure;
import log.interfaces.ILogDecision;
import log.interfaces.IRelais;
import utils.BindingType;

/**
 * Created by seb on 03/02/17.
 */
public class RelaisImpl implements IRelais {

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
    public void relayer(OCService serviceProvider, OCService serviceRequire, BindingType bindingType) {
        switch(bindingType) {
            case BIND:
			try {
				this.binding.bind(serviceProvider, serviceRequire);
			} catch (BindingFailure e) {
				e.printStackTrace();
			}
                break;
            case UNBIND:
                try {
                    this.binding.unbind(serviceProvider, serviceRequire);
                } catch (UnbindingFailure unbindingFailure) {
                    unbindingFailure.printStackTrace();
                }
                break;
        }
        log.logDecisionBinding(serviceProvider, serviceRequire, bindingType);
    }
}
