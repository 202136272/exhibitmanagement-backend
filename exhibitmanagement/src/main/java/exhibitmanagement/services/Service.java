package exhibitmanagement.services;

import java.util.Set;

/**
 * Created by Bonga on 8/6/2016.
 */
public interface Service<E, ID> {

    E create(E entity);

    E readById(ID id);

    Set<E> readAll();

    E update(E entity);

    void delete(E entity);


}