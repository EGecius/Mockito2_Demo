package mockitodemo.custommatchers;

import android.support.annotation.Nullable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import mockitodemo.User;
import mockitodemo.WebService;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@RunWith (MockitoJUnitRunner.class)
public final class CustomMatcherTest {


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
		verify(webService).sendMessages(listContains(EXPECTED_MESSAGE));
	}

	@Nullable
	private List<String> listContains(final String expectedMessage) {
		return argThat(new ListContains<String>(expectedMessage));
	}

}
