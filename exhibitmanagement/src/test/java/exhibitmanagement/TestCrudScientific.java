package exhibitmanagement;

import exhibitmanagement.domain.Scientific;
import exhibitmanagement.factory.ScientificFactory;
import exhibitmanagement.repository.ScientificRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Bonga on 8/15/2016.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudScientific extends AbstractTestNGSpringContextTests {

    private long id;
    @Autowired
    ScientificRepository repository;

    @Test
    public void create ()throws Exception {

        Scientific admin = ScientificFactory.getScientific("Khayelitsha","1234" );

        repository.save(admin);
        //id = admin.getId();
        //Assert.assertNotNull(admin.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read ()throws Exception {
    }
}
