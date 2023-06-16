package andrea.GestioneIncendi.proxyPattern;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ControlCenter2 implements AlarmSystem{
	

	@Override
	public void triggerAlarm(int probeId, double latitude, double longitude, int smokeLvl) {
		String URL = "http://host/alarm?idSonda=" + probeId + "&lat=" + latitude + "&lon=" + longitude + "&smokelevel=" + smokeLvl;
        System.out.println("Rescue team incoming for call details: " + URL);
	}

}
