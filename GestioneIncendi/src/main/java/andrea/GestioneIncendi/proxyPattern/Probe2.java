package andrea.GestioneIncendi.proxyPattern;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
public class Probe2 implements FireDetector{
	
	private int probeId;
    private double latitude;
    private double longitude;
    private int smokeLvl;
    private AlarmSystem alarmSystem;
    
    
    
	public Probe2(int probeId, double latitude, double longitude, int smokeLevel, AlarmSystem alarmSystem) {
		super();
		this.probeId = probeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLvl = smokeLevel;
		this.alarmSystem = alarmSystem;
	}

	@Override
	public void triggerFireAlarm() {
		
        if (smokeLvl > 5) {
            notifyAlarm();
        }
		
	}

	@Override
	public void notifyAlarm() {
		alarmSystem.triggerAlarm(probeId, latitude, longitude, smokeLvl);
		
	}

}
