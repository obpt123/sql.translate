package sql.translate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import org.jooq.ParserCLI;

public class NewParseCLI {

    public static final void main(String... args) throws Exception {
        int index = findSqlFileIndex(args);
        if (index >= 0) {
            replaceSqlFromFile(args, index);
        }
        ParserCLI.main(args);
    }

    private static int findSqlFileIndex(String[] args) {
        var argList = Arrays.asList(args);
        int index = argList.indexOf("-s");
        if (index < 0) {
            index = argList.indexOf("--sql");
        }
        if (index >= 0 && index < args.length - 1 && isFile(args[index + 1])) {
            return index + 1;
        }
        return -1;
    }

    private static void replaceSqlFromFile(String[] args, int index) throws IOException {
        args[index] = readFileContent(args[index]);
    }

    private static String readFileContent(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String str;
        while ((str = in.readLine()) != null) {
            stringBuilder.append(str);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static boolean isFile(String text) {
        try {
            return new File(text).isFile();
        } catch (Exception ex) {
            return false;
        }
    }
}
