package Agent.Agir.GestionBinding;

import interfaceswcomp.Binding;
import interfaceswcomp.BindingFailure;
import interfaceswcomp.OCService;

/**
 * Created by Utilisateur on 09/02/2017.
 */
public class GestionBinding implements IGestionBinding {
    private Binding binding;

    public GestionBinding(Binding binding) {
        this.binding = binding;
    }

    /**
     * Appelle le service binding pour bind 2 services
     * @param s1 
     * 			service 1 to bind
     * @param s2
     * 			service 2 to bind
     */
    @Override
    public void bind(OCService s1, OCService s2) {
        try {
            this.binding.bind(s1, s2);
        } catch (BindingFailure e) {

        }
    }

    public Binding getBinding() {
        return binding;
    }
}
