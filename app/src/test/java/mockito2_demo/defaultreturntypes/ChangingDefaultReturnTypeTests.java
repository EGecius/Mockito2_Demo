package mockito2_demo.defaultreturntypes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import mockito2_demo.PlantWaterer;
import mockito2_demo.Toolbox;
import mockito2_demo.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith (MockitoJUnitRunner.class)
public final class ChangingDefaultReturnTypeTests {

	public static final int WATER_PRESSURE = 5;

	@Mock (answer = Answers.RETURNS_MOCKS) User user;

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
