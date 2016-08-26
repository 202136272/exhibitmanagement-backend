package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Chemistry;
import exhibitmanagement.repository.ChemistryRepository;
import exhibitmanagement.services.ChemistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bonga on 8/13/2016.
 */
@Service
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
    public List<Chemistry> readAll() {
        List<Chemistry> result = new ArrayList<Chemistry>();
        Iterable<Chemistry> chemistries = repository.findAll();
        for (Chemistry chemistry : chemistries) {
            result.add(chemistry);
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
