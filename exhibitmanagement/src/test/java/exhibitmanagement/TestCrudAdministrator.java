package exhibitmanagement;
import exhibitmanagement.domain.Administrator;
import exhibitmanagement.factory.AdministratorFactory;
import exhibitmanagement.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Bonga on 8/6/2016.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudAdministrator extends AbstractTestNGSpringContextTests {

    private long id;
    @Autowired
    AdministratorRepository repository;

    @Test
    public void create() throws Exception {

        Administrator admin = AdministratorFactory.getAdministrator("123", "bonga", "mabulu");

        repository.save(admin);
        //id = admin.getId();
        //Assert.assertNotNull(admin.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
    }
}