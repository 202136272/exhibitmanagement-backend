package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.InvestigatingOfficer;
import exhibitmanagement.repository.InvestigatingOfficerRepository;
import exhibitmanagement.services.InvestigatingOfficerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonga on 8/14/2016.
 */
public class InvestigatingOfficerServiceImpl implements InvestigatingOfficerService {

    @Autowired
    InvestigatingOfficerRepository repository;
    @Override
    public InvestigatingOfficer create(InvestigatingOfficer entity) {
        return repository.save(entity);
    }

    @Override
    public InvestigatingOfficer readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<InvestigatingOfficer> readAll() {
        Set<InvestigatingOfficer> result = new HashSet<InvestigatingOfficer>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public InvestigatingOfficer update(InvestigatingOfficer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(InvestigatingOfficer entity) {
        repository.delete(entity);

    }
}
