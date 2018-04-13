package mockitodemo.defaultreturntypes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import mockitodemo.PlantWaterer;
import mockitodemo.Toolbox;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith (MockitoJUnitRunner.class)
public final class ChangingDefaultReturnTypeTests {

	public static final int WATER_PRESSURE = 5;

	/* deep stubbing is usually a code smell */

	@Test
	public void deepStubbing() {
		//WHEN
		PlantWaterer plantWatererMock = mock(PlantWaterer.class, Mockito.RETURNS_DEEP_STUBS);
		given(plantWatererMock.getWaterSource().getWaterPressure()).willReturn(WATER_PRESSURE);
		Toolbox toolbox = new Toolbox(plantWatererMock);
		//THEN
		assertEquals(toolbox.getWaterPressure(), WATER_PRESSURE);
	}

}
