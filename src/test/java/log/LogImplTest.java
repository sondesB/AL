package log;

import interfaceswcomp.OCComponent;
import interfaceswcomp.OCService;
import junit.framework.TestCase;
import log.exemple.OCComponentImplExemple;
import log.exemple.OCServiceImplExemple1;
import log.exemple.OCServiceImplExemple2;
import log.implementations.LogImpl;
import log.interfaces.ILogComposant;
import log.interfaces.ILogDecision;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.in;

/**
 * Created by Blue on 16/02/2017.
 */
public class LogImplTest extends TestCase {
    private OCComponent component;
    private OCService service1;
    private OCService service2;

    @Before
    public void setUp(){
        component=new OCComponentImplExemple();
        service1= new OCServiceImplExemple1();
        service2= new OCServiceImplExemple2();

    }

    @Test
    public void testLogApparitionComposant() throws Exception {
        ILogComposant log = new LogImpl();
        log.logApparitionComposant(component);

        // display the path if correct
        Path logPath = Paths.get("src"+File.separator+"main"+File.separator+"java"+File.separator+"log"+File.separator+"fichier");
        System.out.format("%s%n", logPath.toUri());

        // create the file
        File file = new File(logPath +File.separator+"file.txt");

        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        file.delete();

    }

    @Test
    public void testLogDisparitionComposant() throws Exception {
        ILogComposant log = new LogImpl();
        log.logDisparitionComposant(component);

        // display the path if correct
        Path logPath = Paths.get("src"+File.separator+"main"+File.separator+"java"+File.separator+"log"+File.separator+"fichier");
        System.out.format("%s%n", logPath.toUri());

        // create the file
        File file = new File(logPath +File.separator+"file.txt");
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        file.delete();
    }

    @Test
    public void testLogBinding() throws Exception {
        ILogDecision log = new LogImpl();
        log.logBinding(service1,service2);

        // display the path if correct
        Path logPath = Paths.get("src"+File.separator+"main"+File.separator+"java"+File.separator+"log"+File.separator+"fichier");
        System.out.format("%s%n", logPath.toUri());

        // create the file
        File file = new File(logPath +File.separator+"file.txt");
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        file.delete();
    }

    @Test
    public void testLogUnbinding() throws Exception {
        ILogDecision log = new LogImpl();
        log.logUnbinding(service1,service2);


        // display the path if correct
        Path logPath = Paths.get("src"+File.separator+"main"+File.separator+"java"+File.separator+"log"+File.separator+"fichier");
        System.out.format("%s%n", logPath.toUri());

        // create the file
        File file = new File(logPath +File.separator+"file.txt");
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        file.delete();
    }

}