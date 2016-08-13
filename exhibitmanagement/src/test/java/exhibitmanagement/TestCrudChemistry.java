package exhibitmanagement;

import exhibitmanagement.domain.Biology;
import exhibitmanagement.domain.Chemistry;
import exhibitmanagement.factory.BiologyFactory;
import exhibitmanagement.factory.ChemistryFactory;
import exhibitmanagement.repository.BiologyRepository;
import exhibitmanagement.repository.ChemistryRepository;
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
public class TestCrudChemistry extends AbstractTestNGSpringContextTests {

    private long id;
    @Autowired
    ChemistryRepository repository;

    @Test
    public void create() throws Exception {

        Chemistry admin = ChemistryFactory.CreateChemistry("10g", "10", "tablets","depressant");

        repository.save(admin);
        //id = admin.getId();
        //Assert.assertNotNull(admin.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
    }
}
