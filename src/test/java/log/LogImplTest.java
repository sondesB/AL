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
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Blue on 16/02/2017.
 */
public class LogImplTest extends TestCase {
    private OCComponent component;
    private OCService service1;
    private OCService service2;

    @Before
    public void SetUp(){
        component=new OCComponentImplExemple();
        service1= new OCServiceImplExemple1();
        service2= new OCServiceImplExemple2();

    }

    @Test
    public void testLogApparitionComposant() throws Exception {
        ILogComposant log = new LogImpl();
        log.logApparitionComposant(component);
        
        fileInput("File.txt"); 

      /*
       *   File file = new File("File.txt"); // LE path est mauvais, il faudrait un vrai dossier de stockage de log
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        file.delete();*/

    }

    @Test
    public void testLogDisparitionComposant() throws Exception {
        ILogComposant log = new LogImpl();
        log.logDisparitionComposant(component);

        File file = new File("File.txt"); // LE path est mauvais, il faudrait un vrai dossier de stockage de log
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        file.delete();
    }

    @Test
    public void testLogBinding() throws Exception {
        ILogDecision log = new LogImpl();

        log.logBinding(service1,service2);

        File file = new File("File.txt"); // LE path est mauvais, il faudrait un vrai dossier de stockage de log
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        file.delete();
    }

    @Test
    public void testLogUnbinding() throws Exception {
        ILogDecision log = new LogImpl();
        log.logUnbinding(service1,service2);


        File file = new File("File.txt"); // LE path est mauvais, il faudrait un vrai dossier de stockage de log
        assertTrue(file.exists());
        assertTrue(file.length() > 0);

        file.delete();
    }
    
    @Test
    public boolean fileInput(String nameFile)  {
    	
    	// display the path if correct
        Path logPath = Paths.get("/main/java/log/file"); 
    	System.out.format("%s%n", logPath.toUri());
    	
    	// create the file
    	File file = new File(logPath + "/"+ nameFile);
    	
    	// exist or not, the file is created
    	 if (file.createNewFile()){
 	        System.out.println("File is created!");
 	      }else{
 	        System.out.println("File already exists.");
 	      }

    	// so read the file
 		FileInputStream in = null;

 		try {
 			in = new FileInputStream(file);
           // diplay le the size
 			System.out.println(" size of bytes : "	+ in.available() );


 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally {
 			try {
 				if (in != null)
 					in.close();
 			} catch (IOException ex) {
 				ex.printStackTrace();
 			}
 		}
 	}
    	
    }



}