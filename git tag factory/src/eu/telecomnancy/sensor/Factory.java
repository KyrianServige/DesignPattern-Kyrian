package eu.telecomnancy.sensor;

public class Factory {

	public Factory(){
		
	}
	
	public ISensor createSensor(String type){
		if (type == "TemperatureSensor") {
			System.out.println("Création TemperatureSensor");
			return new TemperatureSensor();
		}
		if (type == "LegacyTemperatureSensor") {
			System.out.println("Création LegacyTemperatureSensor");

			return (ISensor) new LegacyTemperatureSensor();
		}
		return null;
	}
}
