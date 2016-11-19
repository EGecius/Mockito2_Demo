package mockito2_demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

@RunWith (MockitoJUnitRunner.class)
public final class EqualityCheckTests {


	@Mock WebService webService;

	User user;

	@Before
	public void setup() {
		user = new User(webService);
	}

	/* isA - Any object that implements the given class */

	@Test
	public void when_passesSameClassObject_thenIsAVerificationPasses() {
		//WHEN
		user.sendMyParent(new MyParent());
		//THEN
		verify(webService).sendMyParent(isA(MyParent.class));
	}

	@Test
	public void when_passesChildClassObject_thenIsAVerificationPasses() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(isA(MyParent.class));
	}

	/* refEq - Any object that is equal to the given using reflection; some fields can be excluded */

	@Test
	public void refEq_check_passesForDifferentObjectWithSameFields() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(refEq(new Child(3)));
	}

	@Test
	public void refEq_check_failsForDifferentObjectWithSameFields() {
		//WHEN
		user.sendMyParent(new Child(2));
		//THEN
		verify(webService).sendMyParent(refEq(new Child(3)));
	}

	/* eq - Any object that is equal to the given using equals() method */

	@Test
	public void eq_check_failsForDifferentObjectWithSameFields() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(eq(new Child(3)));
	}
}
