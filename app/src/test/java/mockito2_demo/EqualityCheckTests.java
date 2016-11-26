package mockito2_demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.AdditionalMatchers.aryEq;
import static org.mockito.AdditionalMatchers.cmpEq;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.AdditionalMatchers.leq;
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
		user.sendMyParent(new Parent());
		//THEN
		verify(webService).sendMyParent(isA(Parent.class));
	}

	@Test
	public void when_passesChildClassObject_thenIsAVerificationPasses() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(isA(Parent.class));
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

	/* aryEq - an array that is equal to the given array (has the same length and each element is equal) */

	@Test
	public void aryEq_check_passes_whenArrayIsEqual() {
		//WHEN
		String[] arrayPassed = {"one", "two", "three"};
		String[] arrayExpected = {"one", "two", "three"};
		user.sendArray(arrayPassed);
		//THEN
		verify(webService).sendArray(aryEq(arrayExpected));
	}

	@Test
	public void aryEq_check_fails_whenArraysAreUnequal() {
		//WHEN
		String[] arrayPassed = {"one", "two", "three"};
		String[] arrayExpected = {"one", "two"};
		user.sendArray(arrayPassed);
		//THEN
		verify(webService).sendArray(aryEq(arrayExpected));
	}

	/* COMPARABLE */

	/* cmpEq - any object that is equal to the given using compareTo() method */

	@Test
	public void cmpEq_check_fails_objectsAreUnequalWithComparable() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(cmpEq(new Child(4)));
	}


	@Test
	public void cmpEq_check_fails_objectsAreEqualWithComparable() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(cmpEq(new Child(3)));
	}


	/* gt - any argument greater, greater than the given value */

	@Test
	public void gt_check_fails_objectsAreEqualWithComparable() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(gt(new Child(3)));
	}

	@Test
	public void gt_check_passes_argumentIsGreaterThanComparable() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(gt(new Child(2)));
	}

	/* leq - any argument greater less or equal than the given value */

	@Test
	public void leq_check_passes_argumentEqualtWithComparable() {
		//WHEN
		user.sendMyParent(new Child(3));
		//THEN
		verify(webService).sendMyParent(leq(new Child(3)));
	}

}
