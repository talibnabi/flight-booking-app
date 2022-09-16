package enumeration.concretes.file;

import entity.Booking;
import enumeration.abstracts.FileWorker;
import file.concretes.WorkingWithFile;

import java.util.function.Supplier;

public enum BookingFileWorker implements FileWorker<Booking> {
    BOOKING_FILE_ACCESS(WorkingWithFile::new);

    private final Supplier<WorkingWithFile<Booking>> constructor;

    BookingFileWorker(Supplier<WorkingWithFile<Booking>> constructor) {
        this.constructor = constructor;
    }

    @Override
    public Supplier<WorkingWithFile<Booking>> constructor() {
        return constructor;
    }
}
