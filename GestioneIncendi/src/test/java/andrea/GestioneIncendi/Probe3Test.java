package andrea.GestioneIncendi;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import andrea.GestioneIncendi.factoryPattern.ControlCenter3;
import andrea.GestioneIncendi.factoryPattern.Probe3;
import andrea.GestioneIncendi.factoryPattern.ProbeFactory;
import andrea.GestioneIncendi.proxyPattern.AlarmSystem;
import andrea.GestioneIncendi.proxyPattern.ControlCenter2;
import andrea.GestioneIncendi.proxyPattern.FireDetector;
import andrea.GestioneIncendi.proxyPattern.Probe2;

@SpringBootTest
public class Probe3Test {
	
	ControlCenter3 controlCenter3 = new ControlCenter3();
	
	ProbeFactory factory = new ProbeFactory();

	Probe3 probe = factory.createProbe(7, 43.5342, 10.4325, 4, controlCenter3);
	Probe3 probe2 = factory.createProbe(7, 43.5342, 10.4325, 6, controlCenter3);
	
	@Test
	void testFalseTriggerFireAlarm() {

		
		try {
			probe.triggerFireAlarm();
			fail("Test failed");
		} catch (Exception e) {
			
		}
	}
	
	@Test
	void testTriggerFireAlarm() {
		
		try {
			probe2.triggerFireAlarm();
			
		} catch (Exception e) {
			fail("Test failed");
		}
	}
}
