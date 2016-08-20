package scrforanket;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TemplateLoader {
    public static String loadTemplate(String templateAdress) throws IOException {
        File file = new File(templateAdress);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (String line = ""; (line = reader.readLine()) != null; ) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
