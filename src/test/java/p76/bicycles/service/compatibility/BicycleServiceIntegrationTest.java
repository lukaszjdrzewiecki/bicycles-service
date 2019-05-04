package p76.bicycles.service.compatibility;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import p76.bicycles.service.BicycleService;

@RunWith(SpringRunner.class)
public class BicycleServiceIntegrationTest {

    @TestConfiguration
    static class BicycleServiceIntegrationTestContextConfiguration {


    }
}
