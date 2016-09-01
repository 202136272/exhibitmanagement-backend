package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Biology;
import exhibitmanagement.repository.BiologyRepository;
import exhibitmanagement.services.BiologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Bonga on 8/13/2016.
 */
@Service
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
    public List<Biology> readAll() {
        List<Biology> result = new ArrayList<Biology>();
        Iterable<Biology> biologies = repository.findAll();
        for (Biology biology : biologies) {
            result.add(biology);
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
