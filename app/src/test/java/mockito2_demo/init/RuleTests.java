package mockito2_demo.init;

import static org.assertj.core.api.Assertions.assertThat;

import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@SuppressWarnings("WeakerAccess")
public class RuleTests {

    @Mock
    View view;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void passesWithInit() {
        MockitoAnnotations.initMocks(this);

        assertThat(view).isNotNull();
    }
}
