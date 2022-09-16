package enumeration.concretes.file;

import entity.Booking;
import entity.User;
import enumeration.abstracts.FileWorker;
import file.concretes.WorkingWithFile;

import java.util.function.Supplier;


public enum UserFileWorker implements FileWorker<User> {
    USER_FILE_WORKER(WorkingWithFile::new);
    private final Supplier<WorkingWithFile<User>> constructor;

    UserFileWorker(Supplier<WorkingWithFile<User>> constructor) {
        this.constructor = constructor;
    }

    public Supplier<WorkingWithFile<User>> getConstructor() {
        return constructor;
    }

    @Override
    public Supplier<WorkingWithFile<User>> constructor() {
        return constructor;
    }
}
