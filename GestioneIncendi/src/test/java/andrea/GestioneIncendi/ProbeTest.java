package andrea.GestioneIncendi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import andrea.GestioneIncendi.exceptions.FalseAlarm;
import andrea.GestioneIncendi.observerPattern.Probe;

@SpringBootTest
public class ProbeTest {
	
	 	@Test
	    void testDetectFire() {
	        
	        Probe probe = new Probe(1, 23.4324, 65.5644, 7);
	       
	        try {
	            probe.detectFire();
	          
	            
	        } catch (FalseAlarm e) {
	           
	        	fail("Test fallito");
	        }
	    }
	 	
	 	@Test
	 	void testFalseDetectFire() {
	 		
	 		Probe probe = new Probe(1, 23.4324, 65.5644, 5);
	 		
	 		try {
	 			probe.detectFire();
	 			fail("Test failed");
	 			
	 		} catch (FalseAlarm e) {
	 			
	 			
	 		}
	 	}

}
