package appliances;

public class ApplianceDashBoard {

	public static void main(String[] args) {

		HomeControlSystem home = new HomeControlSystem();

		Light light = new Light();
		Fan fan = new Fan();
		AirConditioner airConditioner = new AirConditioner();

		home.addAppliances(light);
		home.addAppliances(fan);
		home.addAppliances(airConditioner);

		// set the appliances on motion
		light.turnOn();
		fan.setSpeed(2);
		airConditioner.setMode("on");

		System.out.println("##########Appliances state before manual turnoff##########");
		System.out.println("Is Light on ? -->" + light.isOn());
		System.out.println("Is Fan on ? -->" + fan.getSpeed());
		System.out.println("Is conditioner on ? -->" + airConditioner.getMode());

		// For the manul turnOff
		home.turnOffAll();
		//
		System.out.println("##########Appliances state after manual turnoff##########");
		System.out.println("Is Light on ? -->" + light.isOn());
		System.out.println("Is Fan on ? -->" + fan.getSpeed());
		System.out.println("Is conditioner on ? -->" + airConditioner.getMode());

		home.shutDown();

	}

}
