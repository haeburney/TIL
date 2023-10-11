package net.innofactory.lecture.hkim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void main(String[] args) {
        File file = new File(args[0]);  // 생성할 파일명
        
        try {
            if(!file.exists()) {
                file.createNewFile();
                System.out.println("파일 생성이 되었습니다.");
            } else {
                System.out.println("이미 존재하는 파일명입니다.");
            }
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            
            writer.write(args[1]);  // 내용 작성
            writer.newLine();
            
            writer.flush();
            writer.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
