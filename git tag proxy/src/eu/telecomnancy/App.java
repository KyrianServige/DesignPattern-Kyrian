package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.sensor.log;
import eu.telecomnancy.ui.ConsoleUI;

public class App {

    public static void main(String[] args) {
    	TemperatureSensor tempsensor = new TemperatureSensor();
        ISensor sensor = new log(tempsensor);
        new ConsoleUI(sensor);
    }

}