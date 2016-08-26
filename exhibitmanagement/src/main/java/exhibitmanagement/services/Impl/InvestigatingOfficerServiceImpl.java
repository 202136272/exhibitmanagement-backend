package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.InvestigatingOfficer;
import exhibitmanagement.repository.InvestigatingOfficerRepository;
import exhibitmanagement.services.InvestigatingOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Bonga on 8/14/2016.
 */
@Service
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
    public List<InvestigatingOfficer> readAll() {
        List<InvestigatingOfficer> result = new ArrayList<InvestigatingOfficer>();
        Iterable<InvestigatingOfficer> officers = repository.findAll();
        for (InvestigatingOfficer officer : officers) {
            result.add(officer);
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
