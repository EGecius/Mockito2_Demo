package mockito2_demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith (MockitoJUnitRunner.class)
public final class SpyingTests {

	private static final int ORIGINAL_NUMBER_OF_LEAFS = 3;
	private static final int NEW_NUMBER_OF_LEAFS = 5;

	/*spy - I do not understand the purpose of this yet */

	@Test
	void shouldStubMethodAndCallRealNotStubbedMethod() {
		Flower realFlower = new Flower();
		realFlower.setNumberOfLeafs(ORIGINAL_NUMBER_OF_LEAFS);

		Flower flowerSpy = spy(realFlower);
		willDoNothing().given(flowerSpy).setNumberOfLeafs(anyInt());

		flowerSpy.setNumberOfLeafs(NEW_NUMBER_OF_LEAFS);//stubbed‚ should do nothing
		verify(flowerSpy).setNumberOfLeafs(NEW_NUMBER_OF_LEAFS);
		assertEquals(flowerSpy.getNumberOfLeafs(), ORIGINAL_NUMBER_OF_LEAFS);//value was not changed
	}
}
