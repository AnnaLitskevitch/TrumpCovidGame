package pangame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static String loadfileasstring(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line + "\n");
            }
            br.close();
            return builder.toString();

        } catch (IOException e){
            e.printStackTrace();

        }
        return null;
    }

    public static int parseint(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException n) {
            n.printStackTrace();
            return 0;
        }
    }
}
