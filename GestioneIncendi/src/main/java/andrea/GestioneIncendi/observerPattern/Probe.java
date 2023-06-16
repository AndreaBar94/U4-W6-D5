package andrea.GestioneIncendi.observerPattern;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
public class Probe {
	
	private int probeId;
	private List<FireAlarmSystem> fireAlarms = new ArrayList<>();
	private double latitude;
	private double longitude;
	private int smokeLvl;
	
	public Probe(int probeId, double latitude, double longitude, int smokeLvl) {
		super();
		this.probeId = probeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLvl = smokeLvl;
	}
	
	public void addFireAlarm(FireAlarmSystem fas) {
		fireAlarms.add(fas);
	}
	
	public void removeFireAlarm(FireAlarmSystem fas) {
		fireAlarms.remove(fas);
	}
	
	public void detectFire() {
		if(this.smokeLvl > 5) {
			notifyFireAlarmSystem();
		}else {
			System.out.println("Smoke levels under safety limits for the probe number: " + this.probeId);
		}
	}
	
	public void notifyFireAlarmSystem() {
		for(FireAlarmSystem fireAlarm : fireAlarms) {
			fireAlarm.alarm(this);
		}
	}
	
}
