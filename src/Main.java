import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws IOException {

        //В папке Games создайте несколько директорий: src, res, savegames, temp
        //В каталоге src создайте две директории: main, test.
        //В подкаталоге main создайте два файла: Main.java, Utils.java.
        //В каталог res создайте три директории: drawables, vectors, icons.
        //В директории temp создайте файл temp.txt.
        //Файл temp.txt будет использован для записиси в него информации об успешноном или
        //неуспешном создании файлов и директорий.

        StringBuilder logger = new StringBuilder();

        String parentFolder = "/Users/kames/Desktop/games/";

        String src = parentFolder + "src/";
        String main = parentFolder + "src/main/";
        String test = parentFolder + "src/test/";
        String res = parentFolder + "res/";
        String drawables = parentFolder + "res/drawables/";
        String vectors = parentFolder + "res/vectors/";
        String icons = parentFolder + "res/icons/";
        String savegames = parentFolder + "savegames/";
        String temp = parentFolder + "temp/";

        String fileMain = main + "Main.java";
        String fileUtils = main + "Utils.java";
        String fileTemp = temp + "temp.txt";

        makeDir(src, logger);
        makeDir(main, logger);
        makeDir(test, logger);
        makeDir(res, logger);
        makeDir(drawables, logger);
        makeDir(vectors, logger);
        makeDir(icons, logger);
        makeDir(savegames, logger);
        makeDir(temp, logger);

        makeFile(fileMain, logger);
        makeFile(fileUtils, logger);

        try (FileWriter writer = new FileWriter(fileTemp, false)) {
            writer.write(logger.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void makeDir(String dir, StringBuilder logger) {

        File folder = new File(dir);

        if (!folder.exists()) {
            if (folder.mkdir()) {
                logger.append(LocalDateTime.now())
                        .append(" Директория ")
                        .append(dir)
                        .append(" была успешно создана.")
                        .append("\n");
            } else {
                logger.append(LocalDateTime.now())
                        .append(" Директория ")
                        .append(dir)
                        .append(" не была создана.")
                        .append("\n");
            }
        } else {
            logger.append(LocalDateTime.now())
                    .append(" Директория ")
                    .append(dir)
                    .append(" существует.")
                    .append("\n");
        }
    }

    public static void makeFile(String dir, StringBuilder logger) throws IOException {

        File file = new File(dir);

        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    logger.append(LocalDateTime.now())
                            .append(" Файл ")
                            .append(dir)
                            .append(" был успешно создан.")
                            .append("\n");
                } else {
                    logger.append(LocalDateTime.now())
                            .append(" Файл ")
                            .append(dir)
                            .append(" не был создан.")
                            .append("\n");
                }
            } else {
                logger.append(LocalDateTime.now())
                        .append(" Файл ")
                        .append(dir)
                        .append(" сущестует.")
                        .append("\n");
            }
        } catch (IOException e) {
            logger.append(LocalDateTime.now())
                    .append(" Файл ")
                    .append(dir)
                    .append(" не был создан. ")
                    .append(e.getMessage())
                    .append("\n");
        }
    }
}