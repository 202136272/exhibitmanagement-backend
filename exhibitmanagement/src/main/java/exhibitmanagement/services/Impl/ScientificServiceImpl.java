package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Scientific;
import exhibitmanagement.repository.ScientificRepository;
import exhibitmanagement.services.ScientificService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonga on 8/15/2016.
 */
public class ScientificServiceImpl  implements ScientificService {

    @Autowired
    ScientificRepository repository;
    @Override
    public Scientific create(Scientific entity) {
        return repository.save(entity);
    }

    @Override
    public Scientific readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Scientific> readAll() {
        Set<Scientific> result = new HashSet<Scientific>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Scientific update(Scientific entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Scientific entity) {
        repository.delete(entity);

    }
}
