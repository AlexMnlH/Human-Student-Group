package net.ukr.ahavrykin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GroupFileStorage {
    //добавить проверку студента на null! в массиве
    //

   /*     page 33 Tsk2
          Реализуйте отдельный класс GroupFileStorage в котором будут следующие методы:
            ● void saveGroupToCSV(Group gr) — запись группы в CSV файл
            ● Group loadGroupFromCSV(File file) — вычитка и возврат группы из файла
            ● File findFileByGroupName(String groupName, File workFolder) — поиск файла в рабочем каталоге
            (workFolder). Название файла определяется названием группы в нем сохраненной.*/

    private File fileStorage;

    public GroupFileStorage(File fileStorage) {
        this.fileStorage = fileStorage;
    }

    public GroupFileStorage() {
    }

    public File getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(File fileStorage) {
        this.fileStorage = fileStorage;
    }

    /*
    Доработать метод!
    public static void saveGroupToCSVFile(Group gr) {
        if (!gr.equals(null)) {
            try (PrintWriter pw = new PrintWriter(FilefileStorage)) {
                pw.print(.toCSVString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }*/

}
