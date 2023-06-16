package andrea.GestioneIncendi.factoryPattern;

import andrea.GestioneIncendi.exceptions.FalseAlarm;

public interface ProbeSensor {
	void triggerFireAlarm() throws FalseAlarm;
    void notifyAlarm();
}
