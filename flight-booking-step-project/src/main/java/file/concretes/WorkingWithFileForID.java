package file.concretes;

import file.abstracts.FileWorkingID;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class WorkingWithFileForID implements FileWorkingID {
    private static final List<Integer> idList = new ArrayList<>();


    @Override
    public Boolean writeIndexToFile(String filePath, int index) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(String.valueOf(index));
            bufferedWriter.write("\n");
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }


    @Override
    public List<Integer> readAllIndexFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String text = null;
            while ((text = reader.readLine()) != null) {
                idList.add(Integer.parseInt(text));
            }
        } catch (Exception ignored) {
            System.out.println("ignored");
        }
        return idList;
    }

    @Override
    public int readIndexFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String text = null;
            while ((text = reader.readLine()) != null) {
                idList.add(Integer.parseInt(text));
            }
        } catch (Exception ignored) {
            System.out.println("ignored");
        }
        return idList.get(idList.size()-1);
    }

}
