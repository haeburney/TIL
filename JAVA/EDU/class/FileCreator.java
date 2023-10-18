package work.practice.stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 파일 생성
 * 
 *
 */
public class FileCreator {
	public void create(String createFileName, String createFileContent) {
		File file = new File(createFileName); // 생성할 파일명

		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("파일 생성이 되었습니다.");
			} else {
				System.out.println("이미 존재하는 파일명입니다.");
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			writer.write(createFileContent); // 내용 작성
			writer.newLine();

			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java FileCreator FileName FileContent");
			return;
		}

		String createFileName = args[0];
		String createFileContent = args[1];

		FileCreator fileCreator = new FileCreator();
		fileCreator.create(createFileName, createFileContent);

	}
}
