package mockitodemo;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.exceptions.verification.junit.ArgumentsAreDifferent;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith (MockitoJUnitRunner.class)
public final class StringTests {

	@Mock WebService webService;

	User user;
	@Before
	public void setup() {
		user = new User(webService);
	}

	/* matches - String that matches the given regular expression */

	@Test
	public void matches_check_passesWithMatchingRegex() {
		user.sendMessage("a");
		//THEN
		verify(webService).sendMessage(matches("[abc]"));
	}

	@Test (expected = ArgumentsAreDifferent.class)
	public void matches_check_failsWithMismatchingRegex() {
		user.sendMessage("d");
		//THEN
		verify(webService).sendMessage(matches("[abc]"));
	}

	/* startsWith - string that starts with the given string */


	@Test
	public void startsWith_check_passesWithMatchingString() {
		user.sendMessage("egidijus");
		//THEN
		verify(webService).sendMessage(startsWith("egi"));
	}

	@Test (expected = ArgumentsAreDifferent.class)
	public void startsWith_check_passesWithMismatchingString() {
		user.sendMessage("egidijus");
		//THEN
		verify(webService).sendMessage(startsWith("gi"));
	}

	/* endsWith - string that starts with the given string */

	@Test
	public void endsWith_check_passesWithMatchingString() {
		user.sendMessage("egidijus");
		//THEN
		verify(webService).sendMessage(endsWith("jus"));
	}

	@Test (expected = ArgumentsAreDifferent.class)
	public void endsWith_check_failsWithMismatchingString() {
		user.sendMessage("egidijus");
		//THEN
		verify(webService).sendMessage(endsWith("egi"));
	}



	/* contains - string that contains the given string */

	@Test
	public void contains_check_passesWithMatchingString() {
		user.sendMessage("egidijus");
		//THEN
		verify(webService).sendMessage(contains("gi"));
	}

	@Test (expected = ArgumentsAreDifferent.class)
	public void contains_check_failsWithMismatchingString() {
		user.sendMessage("egidijus");
		//THEN
		verify(webService).sendMessage(contains("gij"));
	}


}
