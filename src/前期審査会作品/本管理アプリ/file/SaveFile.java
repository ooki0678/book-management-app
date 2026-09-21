package 前期審査会作品.本管理アプリ.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import 前期審査会作品.本管理アプリ.model.Book;

public class SaveFile {

	public static void save(ArrayList<Book> bookList) {

		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("books.txt"));

			for (Book book : bookList) {

				bw.write(
						book.getTitle() + ","
								+ book.getVolumeNumber() + ","
								+ book.getYear() + ","
								+ book.getMonth() + ","
								+ book.getDay() + ","
								+ book.getPrice());

				bw.newLine();
			}

			bw.close();

			System.out.println("保存しました！");

		} catch (IOException e) {
			System.out.println("保存に失敗しました。");
		}
	}
}