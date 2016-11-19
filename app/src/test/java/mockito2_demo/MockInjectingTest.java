package mockito2_demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith (MockitoJUnitRunner.class)
public class MockInjectingTest {

	@Mock private WaterSource waterSourceMock;
	@Spy private WateringScheduler wateringSchedulerSpy;
	@InjectMocks private PlantWaterer plantWaterer;

	@Test
	public void injectsMocksAndSpysFoundInThisClass() {
		assertNotNull(plantWaterer.getWaterSource());
		assertNotNull(plantWaterer.getWateringScheduler());
	}
}
