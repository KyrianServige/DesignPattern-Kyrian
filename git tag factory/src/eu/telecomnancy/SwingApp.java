package eu.telecomnancy;

import eu.telecomnancy.sensor.Factory;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
    	Factory usine = new Factory();
    	ISensor sensor = usine.createSensor("TemperatureSensor");
        new MainWindow(sensor);
    }

}
