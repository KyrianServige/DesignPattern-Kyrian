package eu.telecomnancy.sensor;

public class CommandeGetValue implements Commande {
	
	ISensor sensor;
	
	public void setSensor(ISensor sensor) {
		this.sensor = sensor;
	}
	
	public void execute() throws SensorNotActivatedException {
		sensor.getValue();
	}

}
