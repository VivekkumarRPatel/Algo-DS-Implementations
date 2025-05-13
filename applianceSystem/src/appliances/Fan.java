package appliances;

public class Fan implements Appliance {
	private int speed;// 0=off

	public void setSpeed(int speed) {

		if (speed >= 0 && speed <= 2) {
			this.speed = speed;
		}

	}

	public void turnOn() {

		if (this.speed == 0) {
			this.speed = 1;
		}
	}

	public int getSpeed() {

		return this.speed;

	}

	@Override
	public void turnOff() {

		this.speed = 0;

	}

}
