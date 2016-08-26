package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Ballistic;
import exhibitmanagement.repository.BallisticRepository;
import exhibitmanagement.services.BallisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bonga on 8/13/2016.
 */
@Service
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
        public List<Ballistic> readAll() {
            List<Ballistic> result = new ArrayList<Ballistic>();
            Iterable<Ballistic> ballistics = repository.findAll();
            for (Ballistic ballistic : ballistics) {
                result.add(ballistic);
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


