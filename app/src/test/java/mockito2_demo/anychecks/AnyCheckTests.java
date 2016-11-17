package mockito2_demo.anychecks;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import mockito2_demo.User;
import mockito2_demo.WebService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

/**
 * Tests for {@link User}
 */
@RunWith (MockitoJUnitRunner.class)
public class AnyCheckTests {

	public static final int EXPECTED_INTEGER = 98;

	@Mock WebService webService;

	User user;

	@Before
	public void setup() {
		user = new User(webService);
	}


	@Test
	public void whenCalled_sendInteger_then_webServiceCallsSendInteger() {
		//WHEN
		user.sendInteger(EXPECTED_INTEGER);
		//THEN
		verify(webService).sendInteger(anyInt());
	}

	@Test
	public void whenCalled_sendObject_then_webServiceCallsSendObject() {
		//WHEN
		user.sendObject(null);
		//THEN
		verify(webService).sendObject(ArgumentMatchers.anyObject());
	}

}