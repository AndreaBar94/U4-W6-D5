package andrea.GestioneIncendi.factoryPattern;

import lombok.Data;

@Data
public class Probe3 implements ProbeSensor{
	
	private int probeId;
	private double latitude;
	private double longitude;
	private int smokeLvl;
	private ControlCenter3 controlCenter;
	
	
	public Probe3(int probeId, double latitude, double longitude, int smokeLvl, ControlCenter3 controlCenter) {
		super();
		this.probeId = probeId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLvl = smokeLvl;
		this.controlCenter = controlCenter;
	}

	@Override
	public void triggerFireAlarm() {
		if(this.smokeLvl > 5) {
			notifyAlarm();
		}
		
	}

	@Override
	public void notifyAlarm() {
		controlCenter.triggerAlarm(probeId, latitude, longitude, smokeLvl);
		
	}

}
