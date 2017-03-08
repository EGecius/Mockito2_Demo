package mockito2_demo;

public class PlantWaterer {

	public enum Type {
		SIMPLE, CUSTOM
	}


	private final WaterSource waterSource;
	private final WateringScheduler wateringScheduler;

	public PlantWaterer(final WaterSource waterSource, final WateringScheduler wateringScheduler) {
		this.waterSource = waterSource;
		this.wateringScheduler = wateringScheduler;
	}

	public WaterSource getWaterSource() {
		return waterSource;
	}

	public WateringScheduler getWateringScheduler() {
		return wateringScheduler;
	}

	public int getTap(int index) {
		return waterSource.getTap(index);
	}

	public int getTap(int index, Type type) {
		return waterSource.getTap(index, type);
	}
}
