package andrea.GestioneIncendi.factoryPattern;

public class ControlCenter3 implements ControlCenterInterface {

	@Override
	public void triggerAlarm(int probeId, double latitude, double longitude, int smokeLvl) {
		
		 String URL = "http://host/alarm?idSonda=" + probeId + "&lat=" + latitude + "&lon=" + longitude + "&smokelevel=" + smokeLvl;
	        System.out.println("Rescue team incoming for call details: " + URL);
		
	}

}
