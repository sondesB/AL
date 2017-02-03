package log.implementations;

import log.interfaces.ILog;
import log.interfaces.IRelais;

/**
 * Created by seb on 03/02/17.
 */
public class RelaisImpl implements IRelais {

    ILog log = new LogImpl();

    @Override
    public void envoyerDecision(Object serviceProvider, Object serviceRequire) {

    }
}
