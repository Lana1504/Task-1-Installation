import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        StringBuilder myFile = new StringBuilder ();
        final String Dir = "Создана директория ";
        final String File = "Создан файл ";
        final String N = "\n";

        // В папке Games создайте несколько директорий: src, res, savegames, temp
        File src = new File ("D://Games/", "src");
        File res = new File ("D://Games/", "res");
        File savegames = new File ("D://Games/", "savegames");
        File temp = new File ("D://Games/", "temp");

        // В каталоге src создайте две директории: main, test
        File main = new File ("D://Games/src/", "main");
        File test = new File ("D://Games/src/", "test");

        //В каталог res создайте три директории: drawables, vectors, icons
        File drawables = new File (res, "drawables");
        File vectors = new File (res, "vectors");
        File icons = new File (res, "icons");

        src.mkdir ();
        myFile.append (Dir + src + N);
        res.mkdir ();
        myFile.append (Dir + res + N);
        savegames.mkdir ();
        myFile.append (Dir + savegames + N);
        temp.mkdir ();
        myFile.append (Dir + temp + N);
        main.mkdir ();
        myFile.append (Dir + main + N);
        test.mkdir ();
        myFile.append (Dir + test + N);
        drawables.mkdir ();
        myFile.append (Dir + drawables + N);
        vectors.mkdir ();
        myFile.append (Dir + vectors + N);
        icons.mkdir ();
        myFile.append (Dir + icons + N);

        //В подкаталоге main создайте два файла: Main.java, Utils.java
        File fileM = new File (main, "Main.java");
        File fileU = new File (main, "Utils.java");
        try {
            fileM.createNewFile ();
            myFile.append (File + fileM + N);
            fileU.createNewFile ();
            myFile.append (File + fileU + N);
        } catch (IOException e) {
            e.printStackTrace ();
        }

        //В директории temp создайте файл temp.txt
        File tempFile = new File (temp, "temp.txt");
        try {
            tempFile.createNewFile ();
            myFile.append (File + tempFile + N);
        } catch (IOException e) {
            e.printStackTrace ();
        }

        //Файл temp.txt будет использован для записи в него информации об успешном или неуспешном создании файлов и директорий
        try (FileWriter inFile = new FileWriter (tempFile, false)) {
            inFile.write (String.valueOf (myFile));
            inFile.flush ();
        } catch (IOException ex) {
            System.out.println (ex.getMessage ());
        }

        //Вывод в консоль
        System.out.println (myFile);
    }
}