package eu.telecomnancy.sensor;

import com.sun.corba.se.spi.orbutil.fsm.State;

public class Adaptateur implements ISensor {
	
	public LegacyTemperatureSensor adapte = new LegacyTemperatureSensor();
	
	public Adaptateur(LegacyTemperatureSensor adapte) {
		this.adapte = adapte;
	}
	
	public void on(){
		if (!adapte.getStatus()) {
			adapte.onOff();
		}
	}
	
	public void off() {
		if (adapte.getStatus()) {
			adapte.onOff();
		}
	}
	
    public boolean getStatus() {
    	return adapte.getStatus();
    }
    
    public void update() throws SensorNotActivatedException {
    	if (adapte.getStatus()) {
    		adapte.onOff();
    		adapte.onOff();
    	} else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }
    
    public double getValue() throws SensorNotActivatedException {
        if (getStatus())
            return adapte.getTemperature();
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }
}
