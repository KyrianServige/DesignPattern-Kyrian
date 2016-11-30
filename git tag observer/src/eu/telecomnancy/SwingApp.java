package eu.telecomnancy;

import eu.telecomnancy.sensor.Affichage;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;
import eu.telecomnancy.ui.SensorView;

public class SwingApp {

	public static void main(String[] args) {
		ISensor sensor = new TemperatureSensor();
		MainWindow main = new MainWindow(sensor);
		SensorView view = main.getSensorView();
		Affichage aff = new Affichage();
		
		view.addObserver(aff);
	}

}
