package work.practice.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 파일 복사하기
 * 
 *
 */
public class FileCopier {
	public void copy(String sourceFileName, String targetFileName) {
		File file = new File(sourceFileName); // 원본 파일명
		File copyFile = new File(targetFileName); // 복사본 파일명

		try {
			FileInputStream input = new FileInputStream(file);
			FileOutputStream output = new FileOutputStream(copyFile);

			byte[] buf = new byte[1024];

			int readData;
			while ((readData = input.read(buf)) > 0) {
				output.write(buf, 0, readData);
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

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java FileCopier sourceFileName targetFileName");
			return;
		}

		String sourceFileName = args[0];
		String targetFileName = args[1];

		FileCopier fileCopier = new FileCopier();
		fileCopier.copy(sourceFileName, targetFileName);
	}
}
