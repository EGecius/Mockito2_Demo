package mockitodemo;

import static junit.framework.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith (MockitoJUnitRunner.class)
public final class ArgumentCaptorTests {

	public static final String MY_MESSAGE = "my_message";
	public static final String MY_MESSAGE_2 = "my_message";

	@Mock WebService webService;
	@Mock StorageService storageService;

	@Captor ArgumentCaptor<String> captorString;

	User user;

	@Before
	public void setup() {
		user = new User(webService, storageService);
	}

	@Test
	public void getAllValues_returnsAllPassedArguments() {
		//WHEN
		user.sendMessage(MY_MESSAGE);
		//THEN
		user.sendMessage(MY_MESSAGE_2);

		verify(webService, times(2)).sendMessage(captorString.capture());
		List<String> allValues = captorString.getAllValues();

		assertEquals(allValues.size(), 2);
		assertEquals(allValues.get(0), MY_MESSAGE);
		assertEquals(allValues.get(0), MY_MESSAGE_2);
	}
}
