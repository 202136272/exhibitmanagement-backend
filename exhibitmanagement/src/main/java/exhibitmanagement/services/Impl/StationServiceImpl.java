package exhibitmanagement.services.Impl;

import exhibitmanagement.domain.Station;
import exhibitmanagement.repository.StationRepository;
import exhibitmanagement.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Bonga on 8/14/2016.
 */
@Service
public class StationServiceImpl implements StationService {


    @Autowired
    StationRepository repository;
    @Override
    public Station create(Station entity) {
        return repository.save(entity);
    }

    @Override
    public Station readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Station> readAll() {
        List<Station> result = new ArrayList<Station>();
        Iterable<Station> stations = repository.findAll();
        for (Station station : stations) {
            result.add(station);
        }
        return result;
    }

    @Override
    public Station update(Station entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Station entity) {
        repository.delete(entity);

    }
}
