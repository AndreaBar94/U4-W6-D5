package andrea.GestioneIncendi.proxyPattern;

import andrea.GestioneIncendi.exceptions.FalseAlarm;

public interface FireDetector {
	void triggerFireAlarm() throws FalseAlarm;
	void notifyAlarm();
}
