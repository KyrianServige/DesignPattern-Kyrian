package eu.telecomnancy.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import eu.telecomnancy.sensor.ISensor;

public class MainWindow extends JFrame {

	private ISensor sensor;
	private SensorView sensorView;

	public MainWindow(ISensor sensor) {
		this.sensor = sensor;
		this.sensorView = new SensorView(this.sensor);

		this.setLayout(new BorderLayout());
		this.add(this.sensorView, BorderLayout.CENTER);

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public ISensor getSensor() {
		return sensor;
	}

	public void setSensor(ISensor sensor) {
		this.sensor = sensor;
	}

	public SensorView getSensorView() {
		return sensorView;
	}

	public void setSensorView(SensorView sensorView) {
		this.sensorView = sensorView;
	}
	
	

}
