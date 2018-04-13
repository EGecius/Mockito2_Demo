package mockitodemo.stubbing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import mockitodemo.WaterSource;

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

    // TODO: 21/10/2017 something missing here 
    @Test @Ignore
	public void doNothing_removesExecutionOfMethodBlock() {
		//WHEN
		doNothing().when(waterSource).throwException();
		//THEN

		waterSource.throwException();
	}

	@Test
	public void doAnswer_allowsAddingBehaviourOnCallsOfVoidMethods() {

        final int[] localVariableToChange = {0};

        Answer answer = new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                int argument = invocation.getArgument(0);

                localVariableToChange[0] = argument;
                return null;
            }
        };

        doAnswer(answer).when(waterSource).callVoid(anyInt());

        waterSource.callVoid(5);

        assertThat(localVariableToChange[0]).isEqualTo(5);
    }

}


