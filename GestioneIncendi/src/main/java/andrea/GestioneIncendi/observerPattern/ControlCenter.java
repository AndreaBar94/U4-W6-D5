package andrea.GestioneIncendi.observerPattern;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ControlCenter implements FireAlarmSystem{
	
	private int probeId;
	private double latitude;
	private double longitude;
	private int smokeLvl;
	@Autowired
	private List<Probe> probes;
    
    @Override
    public void alarm(Probe probe) {
   
            int idSonda = probe.getProbeId();
            double latitude = probe.getLatitude();
            double longitude = probe.getLongitude();
            int smokeLvl = probe.getSmokeLvl();
            
            sendRescueTeam(idSonda, latitude, longitude, smokeLvl);
            
    }
    
    public void sendRescueTeam(int probeId, double latitude, double longitude, int smokeLvl) {
        String URL = "http://host/alarm?idSonda=" + probeId + "&lat=" + latitude + "&lon=" + longitude + "&smokelevel=" + smokeLvl;
        System.out.println("Rescue team incoming for call details: " + URL);
    }

}
