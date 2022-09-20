package util;

import file.abstracts.FileWorkingID;
import file.concretes.WorkingWithFileForID;

public class EntityUtil {
    public static final FileWorkingID fileWorkingID = new WorkingWithFileForID();
    private static int counter = 0;

    public static int counterID(String filePath) {
        if (fileWorkingID.readAllIndexFromFile(filePath).size() != 0) {
            counter = fileWorkingID.readIndexFromFile(filePath) + 1;
            fileWorkingID.writeIndexToFile(filePath, counter);
        }
        if (fileWorkingID.readAllIndexFromFile(filePath).size() == 0) {
            fileWorkingID.writeIndexToFile(filePath, 0);
        }
        return counter;
    }
}
