package enumeration.concretes.file;

import entity.Passenger;
import enumeration.abstracts.FileWorker;
import file.concretes.WorkingWithFile;

import java.util.function.Supplier;

public enum PassengerFileWorker implements FileWorker<Passenger> {
    PASSENGER_FILE_WORKER(WorkingWithFile::new);

    private final Supplier<WorkingWithFile<Passenger>> constructor;

    PassengerFileWorker(Supplier<WorkingWithFile<Passenger>> constructor) {
        this.constructor = constructor;
    }

    public Supplier<WorkingWithFile<Passenger>> getConstructor() {
        return constructor;
    }

    @Override
    public Supplier<WorkingWithFile<Passenger>> constructor() {
        return constructor;
    }
}
