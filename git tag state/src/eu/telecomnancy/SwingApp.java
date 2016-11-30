package eu.telecomnancy;

import eu.telecomnancy.sensor.Context;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.NewTemperatureSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

	public static void main(String[] args) throws SensorNotActivatedException {
		Context context = new Context();
		ISensor sensor = new NewTemperatureSensor();
		sensor.Launch(context);
		new MainWindow(context);
	}

}
