package mockito2_demo.customanswer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import mockito2_demo.FlowerFilter;

import static junit.framework.Assert.assertEquals;
import static mockito2_demo.customanswer.StubbingWithCustomAnswerTests.ReturnFirstArgument.returnFirstArgumentTimes2;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@RunWith (MockitoJUnitRunner.class)
public class StubbingWithCustomAnswerTests {

	private static final int TEST_NUMBER_OF_FLOWERS = 17;

	@Mock FlowerFilter filterMock;

	@Test
	public void shouldReturnTheSameValueTimes2() {
		given(filterMock.filterNoOfFlowers(anyInt())).will(returnFirstArgumentTimes2());
		int filteredNoOfFlowers = filterMock.filterNoOfFlowers(TEST_NUMBER_OF_FLOWERS);
		assertEquals(filteredNoOfFlowers, TEST_NUMBER_OF_FLOWERS * 2);
	}

	//reusable answer class
	public static class ReturnFirstArgument implements Answer<Object> {
		@Override
		public Object answer(InvocationOnMock invocation) throws Throwable {
			Object[] arguments = invocation.getArguments();

			if (arguments.length == 0) {
				throw new MockitoException("...");
			}
			return (int) arguments[0] * 2;
		}

		static ReturnFirstArgument returnFirstArgumentTimes2() {
			return new ReturnFirstArgument();
		}
	}

	@Test
	public void shouldReturnCalledMethodName() {
		given(filterMock.tellMeFlowerName()).will(returnInvokedMethodName());
		String flowerName = filterMock.tellMeFlowerName();
		assertEquals(flowerName, "tellMeFlowerName");
	}

	private ReturnMethodName returnInvokedMethodName() {
		return new ReturnMethodName();
	}

	private class ReturnMethodName implements Answer<String> {
		@Override
		public String answer(final InvocationOnMock invocation) throws Throwable {
			return invocation.getMethod().getName();
		}
	}
}
