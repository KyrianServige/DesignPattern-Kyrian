package eu.telecomnancy.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import eu.telecomnancy.sensor.Commande;
import eu.telecomnancy.sensor.CommandeGetValue;
import eu.telecomnancy.sensor.CommandeOff;
import eu.telecomnancy.sensor.CommandeOn;
import eu.telecomnancy.sensor.CommandeUpdate;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class SensorView extends JPanel {
	private ISensor sensor;

	private Commande commandeOn = new CommandeOn();
	private Commande commandeOff = new CommandeOff();
	private Commande commandeUpdate = new CommandeUpdate();
	private Commande commandeGetValue = new CommandeGetValue();

	private JLabel value = new JLabel("N/A °C");
	private JButton on = new JButton("On");
	private JButton off = new JButton("Off");
	private JButton update = new JButton("Acquire");

	public SensorView(ISensor c) {
		this.sensor = c;
		this.setLayout(new BorderLayout());

		value.setHorizontalAlignment(SwingConstants.CENTER);
		Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
		value.setFont(sensorValueFont);

		this.add(value, BorderLayout.CENTER);

		on.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					commandeOn.setSensor(c);
					commandeOn.execute();
					System.out.println("Utilisation commande on");
				} catch (SensorNotActivatedException sensorNotActivatedException) {
					sensorNotActivatedException.printStackTrace();
				}
			}
		});

		off.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					commandeOff.setSensor(c);
					commandeOff.execute();
					System.out.println("Utilisation commande off");
				} catch (SensorNotActivatedException sensorNotActivatedException) {
					sensorNotActivatedException.printStackTrace();
				}
			}
		});

		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					commandeUpdate.setSensor(c);
					commandeUpdate.execute();
					System.out.println("Utilisation commande update");
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
}
