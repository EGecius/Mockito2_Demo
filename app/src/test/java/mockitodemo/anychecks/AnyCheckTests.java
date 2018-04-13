package mockitodemo.anychecks;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyCollectionOf;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import junit.framework.ComparisonFailure;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.exceptions.verification.junit.ArgumentsAreDifferent;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

import mockitodemo.Child;
import mockitodemo.Parent;
import mockitodemo.StorageService;
import mockitodemo.User;
import mockitodemo.WebService;

/**
 * Tests for {@link User}
 */
@RunWith (MockitoJUnitRunner.class)
public class AnyCheckTests {

	public static final int EXPECTED_INTEGER = 98;

	@Mock WebService webService;
    @Mock StorageService mStorageService;

	User user;

	@Before
	public void setup() {
		user = new User(webService, mStorageService);
	}

	/* anyInt() - any integer but not null */

	@Test
	public void whenCalled_sendInteger_then_webServiceCallsSendInteger() {
		//WHEN
		user.sendInteger(EXPECTED_INTEGER);
		//THEN
		verify(webService).sendInteger(anyInt());
	}

	@Test (expected = ArgumentsAreDifferent.class)
	public void whenReceivesNull_anyIntFails() {
		//WHEN
		user.sendInteger(null);
		//THEN
		verify(webService).sendInteger(anyInt());
	}

	@Test (expected = ArgumentsAreDifferent.class)
	public void whenDoubleReceived_anyIntFails() {
		//WHEN
		user.sendObject(Double.valueOf(34));
		//THEN
		verify(webService).sendObject(anyInt());
	}

	/* anyDouble() */

	@Test (expected = ArgumentsAreDifferent.class)
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

	/* any() - any object or null, the same in a form which allows to avoid casting */

	@Test
	public void whenReceivesNull_anyPasses() {
		//WHEN
		user.sendObject(null);
		//THEN
		verify(webService).sendObject(any());
	}

	/* any() - any object or null even in stubbing */

	@Test
	public void mockingWithWhenAcceptsEvenNullArgs() {
        when(mStorageService.readSaved((String) any())).thenReturn("mocked_saved");

        user.sendSaved(null);

        verify(webService).sendMessage("mocked_saved");
    }

	/* anyCollection() - respectively any collection type */

	@Test
	public void whenCollectionReceived_anyCollectionPasses() {
		//WHEN
		user.sendCollection(Collections.EMPTY_LIST);
		//THEN
		verify(webService).sendCollection(anyCollection());
	}

	@Test (expected = ArgumentsAreDifferent.class)
	public void whenNullReceived_anyCollectionFails() {
		//WHEN
		user.sendCollection(null);
		//THEN
		verify(webService).sendCollection(anyCollection());
	}

	/* anyCollectionOf() - respectively any collection type in a generic friendly way */

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

	/* any(Class) - Matches any object of given type, excluding nulls */
	
	@Test
	public void whenCalled_anyWithChild_then_assertionWithParentPasses() {
		//WHEN
		user.sendObject(new Child(4));
		//THEN
		verify(webService).sendObject(any(Parent.class));
	}

	@Test (expected = ComparisonFailure.class)
	public void whenCalled_anyWithParent_then_assertionWithChildFails() {
		//WHEN
		user.sendObject(new Parent());
		//THEN
		verify(webService).sendObject(any(Child.class));
	}

}