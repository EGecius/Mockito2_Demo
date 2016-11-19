package mockito2_demo.custommatchers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import mockito2_demo.User;
import mockito2_demo.WebService;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@RunWith (MockitoJUnitRunner.class)
final class CustomMatcherTest {


	public static final String EXPECTED_MESSAGE = "expected_message";
	public static final String UNEXPECTED_MESSAGE = "unexpected message";
	public static final int EXPECTED_INTEGER = 98;

	@Mock WebService webService;

	User user;

	@Before
	public void setup() {
		user = new User(webService);
	}

	@Test
	public void whenCalled_sendMessage_then_webServiceCallsSendMessages() {
		//WHEN
		user.sendMessageInList(EXPECTED_MESSAGE);
		//THEN
		verify(webService).sendMessages(argThat(new ListContains<>(EXPECTED_MESSAGE)));
	}

}
