package persistance;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import persistance.implementations.PersistanceImpl;
import persistance.interfaces.BaseDePlanAbstraite;
import persistance.interfaces.IPersistance;
import persistance.interfaces.IRecuperationPlan;
import persistance.exemple.BaseDePlanAbstraiteImplExemple;

/**
 * Created by Blue on 16/02/2017.
 */
public class PersistanceImplTest extends TestCase {

    private IPersistance persistancePer;
    private IRecuperationPlan persistanceRec;
    BaseDePlanAbstraite base;

    @Before
    public void setUp() throws Exception{
        base = new BaseDePlanAbstraiteImplExemple();
        persistancePer=new PersistanceImpl();
        persistanceRec=new PersistanceImpl();
    }

    @Test
    public void testRecupererBasePlan() throws Exception {
        persistancePer.persisterBaseDePlan(base);

        persistanceRec = new PersistanceImpl();
        BaseDePlanAbstraite base = persistanceRec.recupererBasePlan(1);

        assertTrue(base!=null);
        assertTrue(base instanceof BaseDePlanAbstraiteImplExemple);
    }

}