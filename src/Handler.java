import java.io.*;

public class Handler {

    void cpyer () throws IOException {

        String src = "C:/ProgramData/Lockheed Martin/Prepar3D v4/scenery.cfg";
        String dst = "C:/ProgramData/Lockheed Martin/Prepar3D v4/fixx_backup_scenery.cfg";
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
    }

    boolean check(String path){

        File f = new File(path);
        if(f.exists() && !f.isDirectory()) {
            return true;
        }
        else
            return false;

    }


    void dlter(String path){

        File file = new File(path);

        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }

    }

}
