package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Exhibit;
import exhibitmanagement.repository.ExhibitRepository;
import exhibitmanagement.services.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonga on 8/13/2016.
 */
public class ExhibitServiceImpl implements ExhibitService {

    @Autowired
    ExhibitRepository repository;
    @Override
    public Exhibit create(Exhibit entity) {
        return repository.save(entity);
    }

    @Override
    public Exhibit readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Exhibit> readAll() {
        Set<Exhibit> result = new HashSet<Exhibit>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Exhibit update(Exhibit entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Exhibit entity) {
        repository.delete(entity);

    }
}
