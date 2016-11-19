package mockito2_demo;

public class WaterSource {


	public int getWaterPressure() {
		return 0;
	}

	public void doSelfCheck() {
	}

	public void throwException() {
		throw new RuntimeException();
	}
}
