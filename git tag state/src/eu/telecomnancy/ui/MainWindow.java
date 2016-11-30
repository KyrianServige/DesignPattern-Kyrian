package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.Context;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private ISensor sensor;
    private SensorView sensorView;

    public MainWindow(Context context) throws SensorNotActivatedException {
        this.sensor = context.getSensor();
        this.sensorView = new SensorView(context);

        this.setLayout(new BorderLayout());
        this.add(this.sensorView, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
