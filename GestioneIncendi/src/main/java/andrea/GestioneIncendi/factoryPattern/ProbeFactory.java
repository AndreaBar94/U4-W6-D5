package andrea.GestioneIncendi.factoryPattern;

public class ProbeFactory {
	
	public Probe3 createProbe(int probeId, double latitude, double longitude, int smokeLvl, ControlCenter3 controlCenter) {
		return new Probe3(probeId, latitude, longitude, smokeLvl, controlCenter);
	}
}
