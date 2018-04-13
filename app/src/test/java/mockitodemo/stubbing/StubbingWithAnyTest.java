package mockitodemo.stubbing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mockitodemo.PlantWaterer;
import mockitodemo.WaterSource;
import mockitodemo.WateringScheduler;

@RunWith(MockitoJUnitRunner.class)
public class StubbingWithAnyTest {

	public static final int ANY_INT_STUBBED = 1;
	public static final int ANY_TYPE_STUBBED = 99;
	@Mock WaterSource waterSource;
	@Mock WateringScheduler wateringScheduler;
	private PlantWaterer plantWaterer;

	@Before
	public void setup() {
		given(waterSource.getTap(anyInt())).willReturn(ANY_INT_STUBBED);
		given(waterSource.getTap(anyInt(), (PlantWaterer.Type) any())).willReturn(ANY_TYPE_STUBBED);
		plantWaterer = new PlantWaterer(waterSource, wateringScheduler);
	}

	@Test
	public void anyInt_stubbingWorks() {
		assertThat(plantWaterer.getTap(1)).isEqualTo(ANY_INT_STUBBED);
		assertThat(plantWaterer.getTap(2)).isEqualTo(ANY_INT_STUBBED);
		assertThat(plantWaterer.getTap(3)).isEqualTo(ANY_INT_STUBBED);
		assertThat(plantWaterer.getTap(4)).isEqualTo(ANY_INT_STUBBED);
	}

	@Test
	public void anyInt_and_any_stubbingWorks() {
		assertThat(plantWaterer.getTap(1, PlantWaterer.Type.SIMPLE)).isEqualTo(ANY_TYPE_STUBBED);
		assertThat(plantWaterer.getTap(2, PlantWaterer.Type.CUSTOM)).isEqualTo(ANY_TYPE_STUBBED);
		assertThat(plantWaterer.getTap(3, PlantWaterer.Type.CUSTOM)).isEqualTo(ANY_TYPE_STUBBED);
		assertThat(plantWaterer.getTap(4, PlantWaterer.Type.CUSTOM)).isEqualTo(ANY_TYPE_STUBBED);
	}

}
