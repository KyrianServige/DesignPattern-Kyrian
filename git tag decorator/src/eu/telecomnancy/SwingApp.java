package eu.telecomnancy;

import eu.telecomnancy.sensor.DecorateurArrondi;
import eu.telecomnancy.sensor.DecorateurFarenheit;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
        ISensor sensor = new TemperatureSensor();
        ISensor sensorF = new DecorateurFarenheit(new TemperatureSensor());
        ISensor sensorA = new DecorateurArrondi(new TemperatureSensor());
        new MainWindow(sensor);
        new MainWindow(sensorF);
        new MainWindow(sensorA);
    }

}
