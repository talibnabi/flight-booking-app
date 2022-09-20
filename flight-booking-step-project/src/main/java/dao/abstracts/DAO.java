package dao.abstracts;


import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<List<T>> getAll();
    Optional<T> getById(int id);
    Boolean create(T object);
    Boolean delete(int id);
}
