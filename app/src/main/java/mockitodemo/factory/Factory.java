package mockitodemo.factory;

public class Factory {

	public Car createCar() {
		return new Car();
	}

    public static class Car {}
}
