package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Exhibit;
import exhibitmanagement.repository.ExhibitRepository;
import exhibitmanagement.services.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bonga on 8/13/2016.
 */
@Service
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
    public List<Exhibit> readAll() {
        List<Exhibit> result = new ArrayList<Exhibit>();
        Iterable<Exhibit> exhibits = repository.findAll();
        for (Exhibit exhibit : exhibits) {
            result.add(exhibit);
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
