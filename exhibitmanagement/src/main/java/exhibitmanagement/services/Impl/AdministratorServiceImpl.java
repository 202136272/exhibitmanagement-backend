package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Administrator;
import exhibitmanagement.repository.AdministratorRepository;
import exhibitmanagement.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonga on 8/6/2016.
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    AdministratorRepository repository;
    @Override
    public Administrator create(Administrator entity) {
        return repository.save(entity);
    }

    @Override
    public Administrator readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Administrator> readAll() {
        Set<Administrator> result = new HashSet<Administrator>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Administrator update(Administrator entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Administrator entity) {
        repository.delete(entity);

    }
}
