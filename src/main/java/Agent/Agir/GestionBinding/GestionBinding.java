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
