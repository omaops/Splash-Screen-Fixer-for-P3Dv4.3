import java.io.*;
/*
//This is for deleting the Dir
* File index = new File("/home/Work/Indexer1");
if (!index.exists()) {
    index.mkdir();
} else {
    index.delete();
    if (!index.exists()) {
        index.mkdir();
    }
}

//This is for emptying the directory
String[]entries = index.list();
for(String s: entries){
    File currentFile = new File(index.getPath(),s);
    currentFile.delete();
}

//You can try to delete the directory using this as well
import org.apache.commons.io.FileUtils;

FileUtils.deleteDirectory(new File(destination));



//Dir info
Where they come from (1)? ﻿
C:\ProgramData\Lockheed Martin\Prepar3D v4
Files and Folders: [add-ons.cfg ./. weather.cfg]
Where they come from (2)?
C:\Users\yourname\AppData\Local Roaming\Lockheed Martin\Prepar3D v4
Files and Folders:
/Controls + /Effects + /Shaders + Prepar3D_Default.fxml and Prepa3D_Default.wx
* */

public class Handler {

    void cpyer (String src, String dst) throws IOException {




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
