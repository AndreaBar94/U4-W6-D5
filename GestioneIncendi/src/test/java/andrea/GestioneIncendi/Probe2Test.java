package andrea.GestioneIncendi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import andrea.GestioneIncendi.proxyPattern.AlarmSystem;
import andrea.GestioneIncendi.proxyPattern.ControlCenter2;
import andrea.GestioneIncendi.proxyPattern.FireDetector;
import andrea.GestioneIncendi.proxyPattern.Probe2;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Probe2Test {
	
	@Test
	void testFalseTriggerFireAlarm() {
		
		AlarmSystem controlCenter2 = new ControlCenter2();
		FireDetector probe = new Probe2(5, 23.4324, 65.5644, 5, controlCenter2);
		
		try {
			probe.triggerFireAlarm();
			fail("Test failed");
		} catch (Exception e) {
			
		}
	}
	
	@Test
	void testTriggerFireAlarm() {
		
		AlarmSystem controlCenter2 = new ControlCenter2();
		FireDetector probe = new Probe2(5, 23.4324, 65.5644, 6, controlCenter2);
		
		try {
			probe.triggerFireAlarm();
			
		} catch (Exception e) {
			fail("Test failed");
		}
	}
}
