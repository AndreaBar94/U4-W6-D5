package andrea.GestioneIncendi.factoryPattern;

public interface ControlCenterInterface {
	public void triggerAlarm(int probeId, double latitude, double longitude, int smokeLvl);
}
