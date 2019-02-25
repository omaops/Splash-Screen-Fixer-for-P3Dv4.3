import java.io.*;

public class Reverser {

    void rev () throws IOException {

        String dst = "C:/ProgramData/Lockheed Martin/Prepar3D v4/scenery.cfg";
        String src = "C:/ProgramData/Lockheed Martin/Prepar3D v4/fixx_backup_scenery.cfg";
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
