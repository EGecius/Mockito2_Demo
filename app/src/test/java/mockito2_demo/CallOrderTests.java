package mockitodemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.exceptions.verification.VerificationInOrderFailure;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;

@RunWith (MockitoJUnitRunner.class)
public final class CallOrderTests {


	public static final String MY_MESSAGE = "my_message";
	@Mock WebService webService;
	@Mock StorageService storageService;

	User user;

	@Before
	public void setup() {
		user = new User(webService, storageService);
	}

	@Test (expected = VerificationInOrderFailure.class)
	public void inOrder_checks_failWhenOrderNotAsExpected() {
		//WHEN
		user.sendAndSaveMessage(MY_MESSAGE);
		//THEN
		InOrder myOrder = inOrder(webService, storageService);
		myOrder.verify(storageService).save(MY_MESSAGE);
		myOrder.verify(webService).sendMessage(MY_MESSAGE);
	}

	@Test
	public void inOrder_checks_passesWhenOrderAsExpected() {
		//WHEN
		user.sendAndSaveMessage(MY_MESSAGE);
		//THEN
		InOrder myOrder = inOrder(webService, storageService);
		myOrder.verify(webService).sendMessage(MY_MESSAGE);
		myOrder.verify(storageService).save(MY_MESSAGE);
	}

}
