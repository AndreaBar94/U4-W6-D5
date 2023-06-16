package andrea.GestioneIncendi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import andrea.GestioneIncendi.exceptions.FalseAlarm;
import andrea.GestioneIncendi.factoryPattern.ControlCenter3;
import andrea.GestioneIncendi.factoryPattern.Probe3;
import andrea.GestioneIncendi.factoryPattern.ProbeFactory;
import andrea.GestioneIncendi.observerPattern.ControlCenter;
import andrea.GestioneIncendi.observerPattern.Probe;
import andrea.GestioneIncendi.proxyPattern.AlarmSystem;
import andrea.GestioneIncendi.proxyPattern.ControlCenter2;
import andrea.GestioneIncendi.proxyPattern.FireDetector;
import andrea.GestioneIncendi.proxyPattern.Probe2;

@SpringBootApplication
@ComponentScan("andrea.GestioneIncendi")
public class GestioneIncendiApplication {

	public static void main(String[] args) throws FalseAlarm {
		SpringApplication.run(GestioneIncendiApplication.class, args);
		
		System.out.println("------------------------OBSERVER---------------------------");
		
		//istanzio sonde
		Probe probe1 = new Probe(1, 23.4324, 65.5644, 7);
		Probe probe2 = new Probe(2, 12.3456, 98.7654, 3);
		
		//istanzio control center
		ControlCenter controlCenter = new ControlCenter();
		
		//assegno la sonda all'observer
		probe1.addFireAlarm(controlCenter);
		probe2.addFireAlarm(controlCenter);
		
		//creo una lista di sonde per permettere con un for l'iterazione su tutte
		List<Probe> probes = new ArrayList<>();
		probes.add(probe1);
		probes.add(probe2);
		
		//il metodo lancia l'avviso all'observer tramite interfaccia
		for(Probe probe : probes) {
			try {
				probe.detectFire();
				
			} catch (Exception e) {
				System.out.println("Nothing to report here! " + e);
			}
		}
		
		
		
		System.out.println("-------------------------PROXY-----------------------------");
		
		//uso interfacce per interagire con gli oggetti
		
		//creo control center
		AlarmSystem controlCenter2 = new ControlCenter2();
		
		//tramite interfacce richiamo istanze dell'oggetto
		FireDetector probe3 = new Probe2(3, 23.4324, 65.5644, 18, controlCenter2);
		FireDetector probe4 = new Probe2(4, 23.4324, 65.5644, 3, controlCenter2);
		FireDetector probe5 = new Probe2(5, 23.4324, 65.5644, 5, controlCenter2);
		FireDetector probe6 = new Probe2(6, 23.4324, 65.5644, 10, controlCenter2);
		
		List<FireDetector> probes2 = new ArrayList<>();
		probes2.add(probe3);
		probes2.add(probe4);
		probes2.add(probe5);
		probes2.add(probe6);
		
		//utilizzo il metodo definito nell'interfaccia della probe, anziché interagire direttamente con la classe concreta
		for(FireDetector probe : probes2) {
			try {
				probe.triggerFireAlarm();
	
			} catch (Exception e) {
				System.out.println("Nothing to report here! " + e);
			}
		}
		
		
		
		System.out.println("-------------------------FACTORY---------------------------");
		
		ControlCenter3 controlCenter3 = new ControlCenter3();
		
		//istanzio nuova fabbrica
		ProbeFactory factory = new ProbeFactory();
		
		//uso metodo della fabbrica per creare oggetto
		Probe3 probe7 = factory.createProbe(7, 43.5342, 10.4325, 4, controlCenter3);
		Probe3 probe8 = factory.createProbe(8, 43.5342, 10.4325, 10, controlCenter3);
		Probe3 probe9 = factory.createProbe(9, 43.5342, 10.4325, 20, controlCenter3);
		
		List<Probe3> probes3 = new ArrayList<>();
		probes3.add(probe7);
		probes3.add(probe8);
		probes3.add(probe9);
		
		//lancio controllo fumo con il metodo dell'interfaccia
		for(Probe3 probe : probes3) {
			try {
				probe.triggerFireAlarm();
			
			} catch (Exception e) {
				System.out.println("Nothing to report here! " + e);
			}
		}
		
		
	}

}
