package eu.telecomnancy.sensor;

import java.util.Calendar;
import java.util.Random;

public class log implements ISensor {

	private TemperatureSensor sensor;
	
	public log(TemperatureSensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public void on() {
		sensor.state = true;
		System.out.println("Date : " + new java.util.GregorianCalendar().getTime() + ", Méthode : on()");
	}

	@Override
	public void off() {
		sensor.state = false;
		System.out.println("Date : " + new java.util.GregorianCalendar().getTime() + ", Méthode : off()");
	}

	@Override
	public boolean getStatus() {
		System.out.println("Date : " + new java.util.GregorianCalendar().getTime() + ", Méthode : on(), " + "Retour : "
				+ sensor.state);
		return sensor.state;
	}

	@Override
	public void update() throws SensorNotActivatedException {
		if (sensor.state)
			sensor.value = (new Random()).nextDouble() * 100;
		else
			throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
		System.out.println("Date : " + new java.util.GregorianCalendar().getTime() + ", Méthode : update()");
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		System.out.println("Date : " + new java.util.GregorianCalendar().getTime() + ", Méthode : update()" + "Retour : "+Double.toString(sensor.value));
		if (sensor.state)
			return sensor.value;
		else
			throw new SensorNotActivatedException("Sensor must be activated to get its value.");
	}

}
