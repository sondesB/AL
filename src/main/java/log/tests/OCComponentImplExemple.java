package log.tests;

import interfaceswcomp.OCComponent;
import interfaceswcomp.OCService;

import java.util.ArrayList;

/**
 * Created by Blue on 16/02/2017.
 */
public class OCComponentImplExemple extends OCComponent {
    @Override
    public ArrayList<OCService> getRequiredServices() {
        return null;
    }

    @Override
    public ArrayList<OCService> getProvidedServices() {
        return null;
    }

    @Override
    public String getComponentProperties() {
        return "properties Component";
    }
}
