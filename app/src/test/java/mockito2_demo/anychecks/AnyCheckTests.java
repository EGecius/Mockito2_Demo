package mockito2_demo.anychecks;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

import mockito2_demo.User;
import mockito2_demo.WebService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyCollectionOf;
import static org.mockito.ArgumentMatchers.anyDouble;
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

	/* anyInt() */

	@Test
	public void whenCalled_sendInteger_then_webServiceCallsSendInteger() {
		//WHEN
		user.sendInteger(EXPECTED_INTEGER);
		//THEN
		verify(webService).sendInteger(anyInt());
	}

	@Test
	public void whenReceivesNull_anyIntFails() {
		//WHEN
		user.sendInteger(null);
		//THEN
		verify(webService).sendInteger(anyInt());
	}

	@Test
	public void whenDoubleReceived_anyIntFails() {
		//WHEN
		user.sendObject(Double.valueOf(34));
		//THEN
		verify(webService).sendObject(anyInt());
	}

	/* anyDouble() */

	@Test
	public void whenIntReceived_anyDoubleFails() {
		//WHEN
		user.sendObject(Integer.valueOf(22));
		//THEN
		verify(webService).sendObject(anyDouble());
	}

	@Test
	public void whenDoubleReceived_anyDoublePasses() {
		//WHEN
		user.sendObject(Double.valueOf(22));
		//THEN
		verify(webService).sendObject(anyDouble());
	}

	/* any() */

	@Test
	public void whenReceivesNull_anyPasses() {
		//WHEN
		user.sendObject(null);
		//THEN
		verify(webService).sendObject(any());
	}

	/* anyCollection() */

	@Test
	public void whenCollectionReceived_anyCollectionPasses() {
		//WHEN
		user.sendCollection(Collections.EMPTY_LIST);
		//THEN
		verify(webService).sendCollection(anyCollection());
	}

	@Test
	public void whenNullReceived_anyCollectionFails() {
		//WHEN
		user.sendCollection(null);
		//THEN
		verify(webService).sendCollection(anyCollection());
	}

	/* anyCollectionOf()*/

	@Test
	public void whenWrongCollectionTypeReceived_thenAnyCollectionOfPasses() {
		//WHEN

		ArrayList<String> stringsList = new ArrayList<>();
		stringsList.add("one");
		user.sendCollectionOfStrings(stringsList);

		//THEN - this is counter-intuitive because anyCollectionOf does not do any type checks - it is only to avoid
		// compiler warnings.
		verify(webService).sendCollection(anyCollectionOf(Integer.class));
	}

}