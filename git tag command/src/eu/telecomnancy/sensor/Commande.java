package eu.telecomnancy.sensor;

public interface Commande {
	
	ISensor sensor = new TemperatureSensor();
	
	public void setSensor(ISensor sensor);

	public void execute() throws SensorNotActivatedException;

}
