package exhibitmanagement;

import exhibitmanagement.domain.Exhibit;
import exhibitmanagement.factory.ExhibitFactory;
import exhibitmanagement.repository.ExhibitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by Bonga on 8/13/2016.
 */
public class TestCrudExhibit extends AbstractTestNGSpringContextTests {

        private long id;
        @Autowired
        ExhibitRepository repository;

        @Test
        public void create ()throws Exception {

            Exhibit admin = ExhibitFactory.getExhibit("41", "Belhar", "plant material", "clan lab");

            repository.save(admin);
            //id = admin.getId();
            //Assert.assertNotNull(admin.getId());
        }

        @Test(dependsOnMethods = "create")
        public void read ()throws Exception {
        }
    }
