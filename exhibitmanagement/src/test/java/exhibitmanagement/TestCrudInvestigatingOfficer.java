package exhibitmanagement;

import exhibitmanagement.domain.InvestigatingOfficer;
import exhibitmanagement.factory.InvestigatingOfficerFactory;
import exhibitmanagement.repository.InvestigatingOfficerRepository;
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
public class TestCrudInvestigatingOfficer extends AbstractTestNGSpringContextTests {


    private long id;
    @Autowired
    InvestigatingOfficerRepository repository;

    @Test
    public void create ()throws Exception {

        InvestigatingOfficer admin = InvestigatingOfficerFactory.getInvestigatingOfficer("Bizos", "Constable","Langa" ,"12");

        repository.save(admin);
        //id = admin.getId();
        //Assert.assertNotNull(admin.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read ()throws Exception {
    }
}*/
