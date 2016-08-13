package exhibitmanagement.repository;

import exhibitmanagement.domain.Biology;
import exhibitmanagement.domain.Chemistry;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bonga on 8/13/2016.
 */
public interface ChemistryRepository extends CrudRepository<Chemistry,Long> {
}
