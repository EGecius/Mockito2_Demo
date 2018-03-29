package mockito2_demo.init;

import static org.assertj.core.api.Assertions.assertThat;

import android.view.View;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class InitTests {

    @Mock
    View view;

    @Test
    public void failsWithoutInit() {

        assertThat(view).isNull();
    }

    @Test
    public void passesWithInit() {
        MockitoAnnotations.initMocks(this);

        assertThat(view).isNotNull();
    }

}
