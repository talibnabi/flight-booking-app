package util;

import entity.Booking;
import entity.Flight;
import entity.Passenger;
import entity.User;
import file.abstracts.FileWorkingID;
import file.concretes.WorkingWithFile;
import file.concretes.WorkingWithFileForID;

public class FileDAOUtil {
    public static final FileWorkingID workingWithFileForID = new WorkingWithFileForID();
    
}
