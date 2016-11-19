package mockito2_demo.stubbing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import mockito2_demo.WaterSource;

import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@RunWith (MockitoJUnitRunner.class)
public final class StubbingVoidCallsTest {

	@Mock WaterSource waterSource;

	/* throw exception if methods is called */

	@Test (expected = RuntimeException.class)
	public void doThrows_stubbing_throwsException() {
		//WHEN
		doThrow(RuntimeException.class).when(waterSource).doSelfCheck();
		//THEN
		waterSource.doSelfCheck();
	}

	/* same as above but with BDD style */

	@Test (expected = RuntimeException.class)
	public void willThrow_doThrows_stubbing_throwsException() {
		//WHEN
		willThrow(RuntimeException.class).given(waterSource).doSelfCheck();
		//THEN
		waterSource.doSelfCheck();
	}


	/* working with spies you want some methods to do nothing */

	@Test
	public void doNothing_removesExecutionOfMethodBlock() {
		//WHEN
		doNothing().when(waterSource).throwException();
		//THEN

		waterSource.throwException();
	}

}


