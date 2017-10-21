package mockito2_demo;

import static junit.framework.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith (MockitoJUnitRunner.class)
public class MockInjectingTest {

	@Mock private WaterSource waterSourceMock;
	@Spy private WateringScheduler wateringSchedulerSpy;
	@InjectMocks private PlantWaterer plantWaterer;

	@Test
	public void injectsMocksAndSpiesFoundInThisClass() {
		assertNotNull(plantWaterer.getWaterSource());
		assertNotNull(plantWaterer.getWateringScheduler());
	}
}
