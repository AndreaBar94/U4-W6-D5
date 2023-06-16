package andrea.GestioneIncendi.proxyPattern;

public interface AlarmSystem {
	void triggerAlarm(int probeId, double latitude, double longitude, int smokeLvl);
}
