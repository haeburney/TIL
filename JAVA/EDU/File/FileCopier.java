package net.innofactory.lecture.hkim;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier {
    public static void main(String[] args) {
        File file = new File(args[0]);      // 원본 파일명
        File copyFile = new File(args[1]);  // 복사본 파일명
        
        try {
            FileInputStream input = new FileInputStream(file);
            FileOutputStream output = new FileOutputStream(copyFile);
            
            byte[] buf = new byte[1024];
            
            int readData;
            while((readData = input.read(buf)) > 0) {
                output.write(buf,0, readData);
            }
            
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
      
        
    }
}
