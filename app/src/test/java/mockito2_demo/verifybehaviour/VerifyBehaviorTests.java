package mockito2_demo.verifybehaviour;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.runners.MockitoJUnitRunner;

import mockito2_demo.User;
import mockito2_demo.WebService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith (MockitoJUnitRunner.class)
public final class VerifyBehaviorTests {

	public static final String MY_MESSAGE = "my_message";
	public static final String MY_MESSAGE_2 = "my_message_2";

	@Mock WebService webService;

	User user;

	@Before
	public void setup() {
		user = new User(webService);
	}

	@Test
	public void verifyMethods() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		user.sendMessage(MY_MESSAGE_2);

		//THEN
		verify(webService, atLeastOnce()).sendMessage(anyString());
		verify(webService, times(2)).sendMessage(anyString());

		verify(webService, times(1)).sendMessage(MY_MESSAGE);
		verify(webService, times(1)).sendMessage(MY_MESSAGE_2);

		//times(1) is assumed by default, so no need to call it
		verify(webService).sendMessage(MY_MESSAGE);
		verify(webService).sendMessage(MY_MESSAGE_2);

		verify(webService, atMost(2)).sendMessage(anyString());
	}

	/* only - the only method called on a mock */

	@Test
	public void only_passes_whenOnlyThisMethodCalledOnMock() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		//THEN
		verify(webService, only()).sendMessage(MY_MESSAGE);
	}

	@Test (expected = NoInteractionsWanted.class)
	public void only_fails_whenOtherMethodsAlsoCalledOnMock() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		user.sendObject(MY_MESSAGE);
		//THEN
		verify(webService, only()).sendMessage(MY_MESSAGE);
	}

	/* timeout - stops the thread for given time, allowing asynchronous operation to call this method
	 * should be used very rarely - find a better way to test multithreaded system
	 * */

	@Test
	public void timeout_check() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		//THEN
		verify(webService, timeout(100 /*ms*/)).sendMessage(MY_MESSAGE);
	}

	@Test
	public void verifyNoMoreInteractions_check_passesIfNoMoreInteractions() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		//THEN
		verify(webService).sendMessage(MY_MESSAGE);
		verifyNoMoreInteractions(webService);
	}

	/* verifyNoMoreInteractions */

	@Test (expected = NoInteractionsWanted.class)
	public void verifyNoMoreInteractions_check_failsIfMoreInteractions() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		user.sendObject(MY_MESSAGE);
		//THEN
		verify(webService).sendMessage(MY_MESSAGE);
		verifyNoMoreInteractions(webService);
	}

	@Test (expected = NoInteractionsWanted.class)
	public void verifyNoMoreInteractions_check_failsIfCalledBeforeVerify() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		//THEN
		verifyNoMoreInteractions(webService);
	}

	/* verifyZeroInteractions - no interactions happened on given mocks. */

	@Test (expected = NoInteractionsWanted.class)
	public void when_then() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		//THEN
		verifyZeroInteractions(webService);
	}

}
