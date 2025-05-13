package appliances;

public class Light implements Appliance {

	private boolean isOn;

	@Override
	public void turnOn() {

		this.isOn = true;

	}

	@Override
	public void turnOff() {

		this.isOn = false;

	}

	public boolean isOn() {

		return this.isOn;

	}

}
