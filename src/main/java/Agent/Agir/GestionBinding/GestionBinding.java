package Agent.Agir.GestionBinding;

import interfaceswcomp.Binding;
import interfaceswcomp.BindingFailure;
import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class GestionBinding implements IGestionBinding {
    private Binding binding;
    private OCService serviceFromAgent;

    public GestionBinding(Binding binding, OCService service) {
        this.binding = binding;
    	this.serviceFromAgent = service;
    }

    /**
     * Appelle le service binding pour bind 2 services
     * @param s1 
     * 			service 1 to bind
     * @param s2
     * 			service 2 to bind
     */
    @Override
    public void bind(OCService service) {
        try {
            this.binding.bind(this.serviceFromAgent, service);
        } catch (BindingFailure e) {

        }
    }

    public Binding getBinding() {
        return binding;
    }
    
    public OCService getServiceFromAgent() {
        return serviceFromAgent;
    }
}
