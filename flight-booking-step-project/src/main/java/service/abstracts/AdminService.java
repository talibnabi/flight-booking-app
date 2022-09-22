package service.abstracts;

import java.util.List;
import java.util.Optional;

public interface AdminService<T> {
    List<T> getAll();

    T getById(int id);

    Boolean create(T object);

    Boolean delete(int id);

    Boolean checkUsername(String adminName);

    Optional<T> getCheckedUser(String adminName, String adminPassword);
}
