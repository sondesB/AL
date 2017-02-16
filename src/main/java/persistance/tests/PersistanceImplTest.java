package persistance.tests;

import junit.framework.TestCase;
import persistance.implementations.PersistanceImpl;
import persistance.interfaces.BaseDePlanAbstraite;
import persistance.interfaces.IPersistance;
import persistance.interfaces.IRecuperationPlan;

/**
 * Created by Blue on 16/02/2017.
 */
public class PersistanceImplTest extends TestCase {
    public void testPersisterBaseDePlan() throws Exception {
        IPersistance persistance=new PersistanceImpl();
        BaseDePlanAbstraite base = new BaseDePlanAbstraiteImplExemple();
    }

    public void testRecupererBasePlan() throws Exception {
        IRecuperationPlan persistance = new PersistanceImpl();
        BaseDePlanAbstraite base = new BaseDePlanAbstraiteImplExemple();
    }

}