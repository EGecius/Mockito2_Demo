package mockitodemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InjectMocksDemo {

    @InjectMocks
    User user;
    @Mock
    WebService webService;
    @Mock
    StorageService mStorageService;

    @Test
    public void injectMocksAnnotationWorks() {
        assertThat(user).isNotNull();
        assertThat(webService).isNotNull();
        assertThat(mStorageService).isNotNull();
    }

}
