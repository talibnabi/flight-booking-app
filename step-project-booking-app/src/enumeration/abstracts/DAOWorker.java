package enumeration.abstracts;

import dao.abstracts.DAO;
import java.util.function.Supplier;

public interface DAOWorker<T> {
    Supplier<DAO<T>> constructor();
}
