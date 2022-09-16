package enumeration.abstracts;

import file.concretes.WorkingWithFile;

import java.util.function.Supplier;

public interface FileWorker<T> {
    Supplier<WorkingWithFile<T>> constructor();
}
