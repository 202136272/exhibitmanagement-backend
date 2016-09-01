package exhibitmanagement.repository;
import exhibitmanagement.domain.Exhibit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bonga on 8/13/2016.
 */
public interface ExhibitRepository extends CrudRepository<Exhibit,Long> {
}
