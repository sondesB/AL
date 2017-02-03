package log.implementations;

import interfaceswcomp.OCService;
import log.interfaces.ILogComposant;
import log.interfaces.IRelais;
import utils.BindingType;

/**
 * Created by seb on 03/02/17.
 */
public class RelaisImpl implements IRelais {

    private ILogComposant log = new LogImpl();

    @Override
    public void relayer(OCService serviceProvider, OCService serviceRequire, BindingType bindingType) {

    }
}
