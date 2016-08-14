package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Station;
import exhibitmanagement.repository.StationRepository;
import exhibitmanagement.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonga on 8/14/2016.
 */
public class StationServiceImpl implements StationService {


    @Autowired
    StationRepository repository;
    @Override
    public Station create(Station entity) {
        return repository.save(entity);
    }

    @Override
    public Station readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Station> readAll() {
        Set<Station> result = new HashSet<Station>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Station update(Station entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Station entity) {
        repository.delete(entity);

    }
}
