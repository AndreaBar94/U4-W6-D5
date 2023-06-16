package andrea.GestioneIncendi.exceptions;

public class FalseAlarm extends Exception{
	
	public FalseAlarm(int probeId) {
		System.out.println("False alarm detected, smoke levels under safety limits for the probe number: " + probeId);
	}
}
