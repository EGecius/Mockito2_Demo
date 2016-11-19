package mockito2_demo;

public class PlantWaterer {

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
}
