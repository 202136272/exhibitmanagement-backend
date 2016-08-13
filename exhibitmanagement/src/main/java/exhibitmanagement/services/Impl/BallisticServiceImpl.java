package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Administrator;
import exhibitmanagement.domain.Ballistic;
import exhibitmanagement.repository.AdministratorRepository;
import exhibitmanagement.repository.BallisticRepository;
import exhibitmanagement.services.AdministratorService;
import exhibitmanagement.services.BallisticService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonga on 8/13/2016.
 */
public class BallisticServiceImpl implements BallisticService {


        @Autowired
        BallisticRepository repository;
        @Override
        public Ballistic create(Ballistic entity) {
            return repository.save(entity);
        }

        @Override
        public Ballistic readById(Long id) {
            return repository.findOne(id);
        }

        @Override
        public Set<Ballistic> readAll() {
            Set<Ballistic> result = new HashSet<Ballistic>();
            while (repository.findAll().iterator().hasNext()) {
                result.add(repository.findAll().iterator().next());
            }
            return result;
        }

        @Override
        public Ballistic update(Ballistic entity) {
            return repository.save(entity);
        }

        @Override
        public void delete(Ballistic entity) {
            repository.delete(entity);

        }
    }


