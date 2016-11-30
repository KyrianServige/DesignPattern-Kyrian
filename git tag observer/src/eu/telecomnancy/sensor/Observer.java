package eu.telecomnancy.sensor;

public interface Observer {
	
	public void update(Observable o)  throws SensorNotActivatedException;

}
