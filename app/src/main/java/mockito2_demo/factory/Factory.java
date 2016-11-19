package mockito2_demo.factory;

public class Factory {

	public Car createCar() {
		return new Car();
	}

	public Tractor createTractor() {
		return new Tractor();
	}

	public static class Car {}
	public static class Tractor {}
}
