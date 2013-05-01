package fast.tools;

import java.io.*;
import java.net.URISyntaxException;

/**
 * User: k33g_org
 * Date: 5/1/13
 * Time: 5:55 PM
 */
public class Resources {

    public static String read(String url) throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream(url);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        try {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
        } finally {
            br.close();

        }
        return sb.toString();
    }
    public static void mkdir(String pathName) {
        new File(pathName).mkdirs();
    }

    public static void copy(String resourceName, String targetName) throws IOException, URISyntaxException {

        InputStream is = ClassLoader.getSystemResourceAsStream(resourceName);
        OutputStream os = new FileOutputStream(targetName);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        os.close();
        is.close();

    }
}
