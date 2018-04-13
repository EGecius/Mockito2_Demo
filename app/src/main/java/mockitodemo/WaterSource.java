package mockitodemo;

public class WaterSource {


	public int getWaterPressure() {
		return 0;
	}

	public void doSelfCheck() {
	}

    public void callVoid(int i) {
    }

	public void throwException() {
		throw new RuntimeException();
	}

	public int getTap(int index) {
		return index;
	}

	public int getTap(final int index, final PlantWaterer.Type type) {
		return index;
	}
}
