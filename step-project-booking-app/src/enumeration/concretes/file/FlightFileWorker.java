package enumeration.concretes.file;

import entity.Flight;
import enumeration.abstracts.FileWorker;
import file.concretes.WorkingWithFile;

import java.util.function.Supplier;

public enum FlightFileWorker implements FileWorker<Flight> {
    FLIGHT_FILE_ACCESS(WorkingWithFile::new);

    private final Supplier<WorkingWithFile<Flight>> constructor;

    FlightFileWorker(Supplier<WorkingWithFile<Flight>> constructor) {
        this.constructor = constructor;
    }

    @Override
    public Supplier<WorkingWithFile<Flight>> constructor() {
        return constructor;
    }
}
