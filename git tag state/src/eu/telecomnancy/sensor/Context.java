package eu.telecomnancy.sensor;

public class Context {

	private ISensor sensor;
	
	public Context() {
		this.sensor = null;
	}
	
	public void setSensor(ISensor sensor) {
		this.sensor = sensor;
	}
	
	public ISensor getSensor() {
		return this.sensor;
	}
}
