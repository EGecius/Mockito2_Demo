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

    /* Main problem with @InjectMocks is that it only fails at runtime, when constructor
     * arguments are missing */
    @InjectMocks private PlantWaterer plantWaterer;

	@Mock
    private WaterSource waterSourceMock;
	@Spy private WateringScheduler wateringSchedulerSpy;

	@Test
	public void injectsMocksAndSpiesFoundInThisClass() {
		assertNotNull(plantWaterer.getWaterSource());
		assertNotNull(plantWaterer.getWateringScheduler());
	}
}
