package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Biology;
import exhibitmanagement.repository.BiologyRepository;
import exhibitmanagement.services.BiologyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonga on 8/13/2016.
 */
public class BiologyServiceImpl  implements BiologyService {


    @Autowired
    BiologyRepository repository;
    @Override
    public Biology create(Biology entity) {
        return repository.save(entity);
    }

    @Override
    public Biology readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Biology> readAll() {
        Set<Biology> result = new HashSet<Biology>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Biology update(Biology entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Biology entity) {
        repository.delete(entity);

    }
}
