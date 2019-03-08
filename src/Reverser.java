import java.io.*;

public class Reverser {

    void rev (String src, String dst) throws IOException {

        File source = new File(src);
        File dest = new File(dst);

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }

        Handler h = new Handler();

        h.dlter(src);

    }

}
