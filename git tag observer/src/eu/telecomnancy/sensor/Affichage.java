package eu.telecomnancy.sensor;

import eu.telecomnancy.ui.SensorView;

public class Affichage implements Observer {

	@Override
	public void update(Observable o) throws SensorNotActivatedException {

		SensorView sensor = (SensorView) o;
		sensor.setValue(sensor.getSensor().getValue())
;	}

}
