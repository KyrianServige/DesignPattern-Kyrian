package eu.telecomnancy;

import eu.telecomnancy.sensor.Adaptateur;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
        LegacyTemperatureSensor sensor = new LegacyTemperatureSensor();
        ISensor adaptateur = new Adaptateur(sensor);
        
        new MainWindow(adaptateur);
    }

}
