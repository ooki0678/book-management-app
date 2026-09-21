package 前期審査会作品.本管理アプリ.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import 前期審査会作品.本管理アプリ.model.Book;

public class LoadFile {

	public static void load(ArrayList<Book> bookList) {

		try {
			BufferedReader br = new BufferedReader(
					new FileReader("books.txt"));

			String line;

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				String title = data[0];
				int volumeNumber = Integer.parseInt(data[1]);
				int year = Integer.parseInt(data[2]);
				int month = Integer.parseInt(data[3]);
				int day = Integer.parseInt(data[4]);
				int price = Integer.parseInt(data[5]);

				Book book = new Book(
						title,
						volumeNumber,
						year,
						month,
						day,
						price);

				bookList.add(book);
			}

			br.close();

			System.out.println();
			System.out.println("読み込みました！");

		} catch (IOException e) {
			System.out.println("読み込みに失敗しました。");
		}
	}
}