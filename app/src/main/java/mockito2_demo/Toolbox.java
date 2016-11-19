package mockito2_demo;

public class Toolbox {

	private final PlantWaterer plantWaterer;

	public Toolbox(final PlantWaterer plantWaterer) {
		this.plantWaterer = plantWaterer;
	}

	public int getWaterPressure() {
		return plantWaterer.getWaterSource().getWaterPressure();
	}
}
