package 前期審査会作品.本管理アプリ.main;

import java.util.ArrayList;
import java.util.Scanner;

import 前期審査会作品.本管理アプリ.file.LoadFile;
import 前期審査会作品.本管理アプリ.file.SaveFile;
import 前期審査会作品.本管理アプリ.manager.BookManager;
import 前期審査会作品.本管理アプリ.menu.Menu;
import 前期審査会作品.本管理アプリ.model.Book;
import 前期審査会作品.本管理アプリ.util.BookMessage;

public class Main {
	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<>();
		LoadFile.load(bookList);
		Scanner scan = new Scanner(System.in);
		BookManager manager = new BookManager(bookList);
		while (true) {
			int menu = Menu.showMenu();
			switch (menu) {
			case 1:
				System.out.println("========================\n"
						+ "一覧" + "\n"
						+ "========================");
				manager.showList(scan);
				break;
			case 2:
				System.out.println("========================\n"
						+ "追加" + "\n"
						+ "========================");
				manager.addBook(scan);
				break;
			case 3:
				System.out.println("========================\n"
						+ "検索" + "\n"
						+ "========================");
				manager.searchBook(scan);
				break;
			case 4:
				System.out.println("========================\n"
						+ "編集" + "\n"
						+ "========================");
				manager.updateBook(scan);
				break;
			case 5:
				System.out.println("========================\n"
						+ "消去" + "\n"
						+ "========================");
				manager.deleteBook(scan);
				break;
			//			case 6:
			//				System.out.println("========================\n"
			//						+ "保存" + "\n"
			//						+ "========================");
			//				SaveFile.save(manager.getBookList());
			//				break;
			//			case 7:
			//				System.out.println("========================\n"
			//						+ "読み込み" + "\n"
			//						+ "========================");
			//				LoadFile.load(manager.getBookList());
			//				break;
			case 0:
				SaveFile.save(manager.getBookList());
				System.out.println("終了しました。");
				return;
			default:
				System.out.println();
				System.out.println(BookMessage.ERROE_MESSAGE);
			}
			System.out.println();
		}

	}
}