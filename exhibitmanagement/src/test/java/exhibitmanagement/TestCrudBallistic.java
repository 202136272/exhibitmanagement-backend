package exhibitmanagement;

import exhibitmanagement.domain.Administrator;
import exhibitmanagement.domain.Ballistic;
import exhibitmanagement.factory.AdministratorFactory;
import exhibitmanagement.factory.BallisticFactory;
import exhibitmanagement.repository.AdministratorRepository;
import exhibitmanagement.repository.BallisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Bonga on 8/13/2016.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBallistic extends AbstractTestNGSpringContextTests {

    private long id;
    @Autowired
    BallisticRepository repository;

    @Test
    public void create() throws Exception {

        Ballistic admin = BallisticFactory.getBallistic("Sizwe", "cas 21", "cartridge");

        repository.save(admin);
        //id = admin.getId();
        //Assert.assertNotNull(admin.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
    }

}
