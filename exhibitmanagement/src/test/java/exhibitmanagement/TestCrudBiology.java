package exhibitmanagement;

import exhibitmanagement.domain.Biology;
import exhibitmanagement.factory.BiologyFactory;
import exhibitmanagement.repository.BiologyRepository;
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
public class TestCrudBiology extends AbstractTestNGSpringContextTests {

    private long id;
    @Autowired
    BiologyRepository repository;

    @Test
    public void create() throws Exception {

        Biology admin = BiologyFactory.getBiology("Bonga", "cas 31", "RNA");

        repository.save(admin);
        //id = admin.getId();
        //Assert.assertNotNull(admin.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
    }
}
