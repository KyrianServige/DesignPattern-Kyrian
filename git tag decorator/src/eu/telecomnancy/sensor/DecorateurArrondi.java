package eu.telecomnancy.sensor;

public class DecorateurArrondi extends Decorator {

	TemperatureSensor sensor;

	public DecorateurArrondi(TemperatureSensor sensor) {
		super(sensor);
		this.sensor = sensor;
	}
	
	public String getStringValue() {
		return "A "+Double.toString(Math.floor(sensor.value))+" °C";
	}
	
	public String getStringEmpty() {
		return "N/A Â°C";
	}

}
