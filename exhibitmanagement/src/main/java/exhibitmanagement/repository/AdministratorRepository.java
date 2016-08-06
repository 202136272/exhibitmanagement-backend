package exhibitmanagement.repository;

import exhibitmanagement.domain.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bonga on 8/6/2016.
 */
@Repository
public interface AdministratorRepository extends CrudRepository<Administrator,Long> {
}
