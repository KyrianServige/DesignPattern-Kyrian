package eu.telecomnancy.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.Observable;
import eu.telecomnancy.sensor.Observer;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import javafx.util.converter.IntegerStringConverter;

public class SensorView extends JPanel implements Observable {
	private ISensor sensor;

	private JLabel value;;
	private JButton on = new JButton("On");
	private JButton off = new JButton("Off");
	private JButton update = new JButton("Acquire");
	private ArrayList<Observer> listObservers;

	public SensorView(ISensor c) {
		this.value = new JLabel("N/A Â°C");
		this.listObservers = new ArrayList<Observer>();
		this.sensor = c;
		this.setLayout(new BorderLayout());

		value.setHorizontalAlignment(SwingConstants.CENTER);
		Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
		value.setFont(sensorValueFont);

		this.add(value, BorderLayout.CENTER);

		on.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensor.on();
			}
		});

		off.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensor.off();
			}
		});

		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sensor.update();
					notifyObservers();
				} catch (SensorNotActivatedException sensorNotActivatedException) {
					sensorNotActivatedException.printStackTrace();
				}
			}
		});

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 3));
		buttonsPanel.add(update);
		buttonsPanel.add(on);
		buttonsPanel.add(off);

		this.add(buttonsPanel, BorderLayout.SOUTH);
	}

	@Override
	public void addObserver(Observer observer) {
		this.listObservers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		this.listObservers.remove(observer);

	}

	@Override
	public void notifyObservers() throws SensorNotActivatedException {
		for (int i = 0; i < this.listObservers.size(); i++) {
			Observer o = this.listObservers.get(i);
			o.update(this);
		}

	}
	
	public void setValue(double value) {
		this.value.setText("A "+Double.toString(value)+"°C");
		this.value.validate();
	}
	
	public ISensor getSensor() {
		return this.sensor;
	}
}
