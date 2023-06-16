package andrea.GestioneIncendi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import andrea.GestioneIncendi.observerPattern.ControlCenter;
import andrea.GestioneIncendi.observerPattern.Probe;
import andrea.GestioneIncendi.proxyPattern.AlarmSystem;
import andrea.GestioneIncendi.proxyPattern.ControlCenter2;
import andrea.GestioneIncendi.proxyPattern.FireDetector;
import andrea.GestioneIncendi.proxyPattern.Probe2;

@SpringBootApplication
@ComponentScan("andrea.GestioneIncendi")
public class GestioneIncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);
		
		System.out.println("--------------------OBSERVER------------------------");
		
		Probe probe1 = new Probe(1, 23.4324, 65.5644, 7);
		Probe probe2 = new Probe(2, 12.3456, 98.7654, 3);

		ControlCenter controlCenter = new ControlCenter();
		
		probe1.addFireAlarm(controlCenter);
		probe2.addFireAlarm(controlCenter);
		
		probe1.detectFire();//risposta positiva
		probe2.detectFire();//non genera output, livello fumo basso
		
		System.out.println("----------------------PROXY--------------------------");
		
		AlarmSystem controlCenter2 = new ControlCenter2();
		FireDetector probe3 = new Probe2(1, 23.4324, 65.5644, 18, controlCenter2);
		FireDetector probe4 = new Probe2(1, 23.4324, 65.5644, 3, controlCenter2);
		FireDetector probe5 = new Probe2(1, 23.4324, 65.5644, 5, controlCenter2);
		FireDetector probe6 = new Probe2(1, 23.4324, 65.5644, 10, controlCenter2);
		probe3.triggerFireAlarm();
		probe4.triggerFireAlarm();
		probe5.triggerFireAlarm();
		probe6.triggerFireAlarm();
		
		System.out.println("----------------------FACTORY------------------------");
	}

}
