package mockito2_demo.defaultreturntypes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import mockito2_demo.factory.Factory;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Tests for {@link Factory}
 */
@RunWith (MockitoJUnitRunner.class)
public class FactoryTest {

	@Mock (answer = Answers.RETURNS_MOCKS) Factory factoryReturningMocks;

	@Mock Factory factoryReturningDefaults;

	@Test
	public void mockConfiguredToReturnMocksByDefault() {
		assertNotNull(factoryReturningMocks.createCar());
		assertNotNull(factoryReturningMocks.createCar());
	}

	@Test
	public void byDefaultMockReturnsNulls() {
		assertNull(factoryReturningDefaults.createCar());
		assertNull(factoryReturningDefaults.createCar());
	}

}