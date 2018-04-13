package mockitodemo.stubbing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mockitodemo.WaterSource;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith (MockitoJUnitRunner.class)
public final class StubMultipleCallsTest {

	@Mock WaterSource waterSource;

	/* stubbing multiple calls */

	@Test
	public void willReturn_stubbing_returnsMultipleArgumentsWithLastOneReturnedIndefinitely() {
		given(waterSource.getWaterPressure()).willReturn(3, 5, 4);

		assertEquals(waterSource.getWaterPressure(), 3);
		assertEquals(waterSource.getWaterPressure(), 5);
		assertEquals(waterSource.getWaterPressure(), 4);
		assertEquals(waterSource.getWaterPressure(), 4);
		assertEquals(waterSource.getWaterPressure(), 4);
	}

}


