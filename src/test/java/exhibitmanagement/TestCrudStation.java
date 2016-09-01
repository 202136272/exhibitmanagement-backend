package exhibitmanagement;

import exhibitmanagement.domain.Station;
import exhibitmanagement.factory.StationFactory;
import exhibitmanagement.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Bonga on 8/14/2016.
 */


/*@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration

public class TestCrudStation extends AbstractTestNGSpringContextTests {


    private long id;
    @Autowired
    StationRepository repository;

    @Test
    public void create ()throws Exception {

        Station admin = StationFactory.getStation("Khayelitsha","1234" );

        repository.save(admin);
        //id = admin.getId();
        //Assert.assertNotNull(admin.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read ()throws Exception {
    }
}*/
