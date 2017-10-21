package mockito2_demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.verify;

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
	public void matches_check_passesWithMathingRegex() {
		user.sendMessage("a");
		//THEN
		verify(webService).sendMessage(matches("[abc]"));
	}

	@Test
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

	@Test
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

	@Test
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

	@Test
	public void contains_check_failsWithMismatchingString() {
		user.sendMessage("egidijus");
		//THEN
		verify(webService).sendMessage(contains("gij"));
	}


}
