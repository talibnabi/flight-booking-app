package service.abstracts;


import java.util.List;
import java.util.Optional;

public interface UserService<T> {
    List<T> getAll();
    T getById(int id);
    Boolean create(T object);
    Boolean delete(int id);
    Boolean checkUsername(String username);
    Optional<T> getCheckedUser(String username,String password);
}
