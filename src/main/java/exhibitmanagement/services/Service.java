package exhibitmanagement.services;

import java.util.List;
import java.util.Set;

/**
 * Created by Bonga on 8/6/2016.
 */
public interface Service<E, ID> {

    E create(E entity);

    E readById(ID id);

    List<E> readAll();

    E update(E entity);

    void delete(E entity);


}