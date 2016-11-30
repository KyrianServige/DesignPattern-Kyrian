package eu.telecomnancy.sensor;

public class DecorateurFarenheit extends Decorator {
	
	TemperatureSensor sensor;

	public DecorateurFarenheit(TemperatureSensor sensor) {
		super(sensor);
		this.sensor = sensor;
	}
	
	public String getStringValue() {
		return "A "+Double.toString((sensor.value)*1.8+32)+" °F";
	}
	
	public String getStringEmpty() {
		return "N/A Â°F";
	}

}
