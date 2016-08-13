package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Chemistry;
import exhibitmanagement.repository.ChemistryRepository;
import exhibitmanagement.services.ChemistryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonga on 8/13/2016.
 */
public class ChemistryServiceImpl implements ChemistryService {

    @Autowired
    ChemistryRepository repository;
    @Override
    public Chemistry create(Chemistry entity) {
        return repository.save(entity);
    }

    @Override
    public Chemistry readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Chemistry> readAll() {
        Set<Chemistry> result = new HashSet<Chemistry>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Chemistry update(Chemistry entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Chemistry entity) {
        repository.delete(entity);

    }
}
