package eu.telecomnancy.sensor;

public class Factory {

	public Factory(){
		
	}
	
	public ISensor createSensor(String type){
		if (type == "TemperatureSensor") {
			System.out.println("Cr�ation TemperatureSensor");
			return new TemperatureSensor();
		}
		if (type == "LegacyTemperatureSensor") {
			System.out.println("Cr�ation LegacyTemperatureSensor");

			return (ISensor) new LegacyTemperatureSensor();
		}
		return null;
	}
}
