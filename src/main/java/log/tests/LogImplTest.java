package log.tests;

import interfaceswcomp.OCComponent;
import interfaceswcomp.OCService;
import junit.framework.TestCase;
import log.implementations.LogImpl;
import log.interfaces.ILogComposant;
import log.interfaces.ILogDecision;

/**
 * Created by Blue on 16/02/2017.
 */
public class LogImplTest extends TestCase {
    public void testLogApparitionComposant() throws Exception {
        ILogComposant log = new LogImpl();
        OCComponent component=new OCComponentImplExemple();
        log.logApparitionComposant(component);

    }

    public void testLogBinding() throws Exception {
        ILogDecision log = new LogImpl();
        OCService service1= new OCServiceImplExemple1();
        OCService service2= new OCServiceImplExemple2();
        log.logBinding(service1,service2);
    }

    public void testLogUnbinding() throws Exception {
        ILogDecision log = new LogImpl();
        OCService service1= new OCServiceImplExemple1();
        OCService service2= new OCServiceImplExemple2();
        log.logUnbinding(service1,service2);

    }

    public void testLogDisparitionComposant() throws Exception {
        ILogComposant log = new LogImpl();
        OCComponent component=new OCComponentImplExemple();
        log.logDisparitionComposant(component);
    }

}