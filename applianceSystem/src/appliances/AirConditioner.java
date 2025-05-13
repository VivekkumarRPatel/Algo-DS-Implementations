package appliances;

public class AirConditioner implements Appliance {

	private String mode = "off";

	public void turnOn() {
		mode = "on";
	}

	public void turnOff() {
		mode = "off";
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {

		if (mode.equalsIgnoreCase("on") || mode.equalsIgnoreCase("off")) {
			this.mode = mode.toLowerCase();
		}

	}

}