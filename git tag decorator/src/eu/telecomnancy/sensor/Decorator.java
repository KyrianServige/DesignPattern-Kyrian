package eu.telecomnancy.sensor;

public class Decorator implements ISensor {
	
	private TemperatureSensor sensor;
	
	public Decorator(TemperatureSensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public void on() {
		sensor.on();
		
	}

	@Override
	public void off() {
		sensor.off();
		
	}

	@Override
	public boolean getStatus() {
		return sensor.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		sensor.update();
		
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		return sensor.getValue();
	}

	@Override
	public String getStringValue() {
		return sensor.getStringValue();
	}

	@Override
	public String getStringEmpty() {
		return sensor.getStringEmpty();
	}

}
