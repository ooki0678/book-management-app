package 前期審査会作品.本管理アプリ.manager;

import java.util.ArrayList;
import java.util.Scanner;

import 前期審査会作品.本管理アプリ.model.Book;
import 前期審査会作品.本管理アプリ.util.BookMessage;
import 前期審査会作品.本管理アプリ.util.InputUtil;

public class BookManager {
	private ArrayList<Book> bookList = new ArrayList<>();

	//BookManagerのコンストラクタ
	public BookManager(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	//追加
	public void addBook(Scanner scan) {
		//＊別の作り方バージョンで作ったやつだからこれは使ってない！＊
		//String title = InputUtil.inputString(scan, "タイトル：");
		//int volume = InputUtil.inputInt(scan, "巻数：");
		//int year = InputUtil.inputInt(scan, "購入年：");
		//int month = InputUtil.inputInt(scan, "購入月：");
		//int day = InputUtil.inputInt(scan, "購入日：");
		//int price = InputUtil.inputInt(scan, "値段：");

		System.out.print("タイトル：");
		String title = scan.nextLine();
		//		scan.nextLine();
		System.out.print("巻数：");
		int volume = scan.nextInt();
		scan.nextLine();
		System.out.print("購入年：");
		int year = scan.nextInt();
		scan.nextLine();
		System.out.print("購入月：");
		int month = scan.nextInt();
		scan.nextLine();
		System.out.print("購入日：");
		int day = scan.nextInt();
		scan.nextLine();
		System.out.print("値段：");
		int price = scan.nextInt();
		scan.nextLine();

		bookList.add(new Book(title, volume, year, month, day, price));

		System.out.println();
		System.out.println(BookMessage.ADD_COMPLETE);
	}

	//一覧
	public void showList(Scanner scan) {
		if (bookList.isEmpty()) {
			System.out.println(BookMessage.NOT_FOUND);
			return;
		}

		System.out.println("========================");
		int number = 1;
		for (Book book : bookList) {
			System.out.println(number + "：" + book.getTitle());
			number++;
		}
		System.out.println("0：戻る");
		System.out.println(BookMessage.DETAILES_TEXT);
		System.out.println("========================");

		//int select = InputUtil.inputInt(scan, "選択：");
		System.out.print("選択：");
		int select = scan.nextInt();
		scan.nextLine();
		if (select == 0) {
			return;
		}
		System.out.println();

		System.out.println("========================\n"
				+ "詳細" + "\n"
				+ "========================");
		Book book = bookList.get(select - 1);
		book.BookInformationList();
	}

	//検索
	public void searchBook(Scanner scan) {
		//String keyword = InputUtil.inputString(scan, "検索：");		
		System.out.print("検索：");
		String keyword = scan.nextLine();

		System.out.println("========================");
		boolean found = false;
		int number = 1;
		ArrayList<Book> searchResult = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getTitle().contains(keyword)) {
				System.out.println(number + "：" + book.getTitle() + " " + book.getVolumeNumber() + "巻");
				searchResult.add(book);
				number++;
				found = true;
			}
		}
		System.out.println("0：戻る");
		System.out.println();
		System.out.println(BookMessage.DETAILES_TEXT);
		System.out.println("========================");

		if (!found) {
			System.out.println(BookMessage.NOT_FOUND1);
		}
		System.out.println();

		System.out.println("========================\n"
				+ "詳細" + "\n"
				+ "========================");

		while (true) {
			//		int select = InputUtil.inputInt(scan, "選択：");
			System.out.print("選択：");
			int select = scan.nextInt();
			scan.nextLine();
			if (select == 0) {
				System.out.println(BookMessage.A);
				System.out.println();
				break;
			}
			System.out.println();

			try {
				Book selectedBook = searchResult.get(select - 1);
				selectedBook.BookInformationList();
				break;
			} catch (IndexOutOfBoundsException e) {
				System.out.println(BookMessage.NOT_FOUND1);
			}
		}
	}

	//編集
	public void updateBook(Scanner scan) {
		if (bookList.isEmpty()) {
			System.out.println(BookMessage.NOT_FOUND);
			return;
		}

		System.out.println("========================");
		int number = 1;
		for (Book book : bookList) {
			System.out.println(number + "：" + book.getTitle());
			number++;
		}
		System.out.println("0：戻る");
		System.out.println();
		System.out.println(BookMessage.EDIT_TEXT);
		System.out.println("========================");

		//		int select = InputUtil.inputInt(scan, "選択：");
		System.out.print("選択：");
		int select = scan.nextInt();
		scan.nextLine();
		if (select == 0) {
			return;
		}
		System.out.println();

		while (true) {
			System.out.println("========================\n"
					+ "詳細" + "\n"
					+ "========================");
			Book book = bookList.get(select - 1);
			if (select == 1) {
				System.out.println("New");
				book.BookInformationList();
			}

			System.out.println("========================");
			System.out.println("１：全部編集");
			System.out.println("２：タイトル");
			System.out.println("３：巻数");
			System.out.println("４：購入日");
			System.out.println("５：値段");
			System.out.println("0：編集を終了する");
			System.out.println("========================");

			int choice = InputUtil.inputInt(scan, "選択：");
			if (select == 0) {
				return;
			}

			switch (choice) {
			case 1:
				//＊別の作り方バージョンで作ったやつだからこれは使ってない！＊
				//System.out.println();
				//book.setTitle(InputUtil.inputString(scan, "Newタイトル："));
				//book.setVolumeNumber(InputUtil.inputInt(scan, "New巻数："));
				//book.setYear(InputUtil.inputInt(scan, "New購入年："));
				//book.setMonth(InputUtil.inputInt(scan, "New購入月："));
				//book.setDay(InputUtil.inputInt(scan, "New購入日："));
				//book.setPrice(InputUtil.inputInt(scan, "New値段："));
				//System.out.println();

				System.out.print("Newタイトル：");
				String newTitle = scan.nextLine();
				book.setTitle(newTitle);

				System.out.print("New巻数：");
				int newVolumeNumber = scan.nextInt();
				book.setVolumeNumber(newVolumeNumber);

				System.out.print("New購入年：");
				int newYear = scan.nextInt();
				book.setYear(newYear);
				System.out.print("New購入月：");
				int newMonth = scan.nextInt();
				book.setMonth(newMonth);
				System.out.print("New購入日：");
				int newDay = scan.nextInt();
				book.setDay(newDay);

				System.out.print("New値段：");
				int newPrice = scan.nextInt();
				book.setPrice(newPrice);
				System.out.println();

				break;
			case 2:
				//book.setTitle(InputUtil.inputString(scan, "Newタイトル："));
				System.out.print("Newタイトル：");
				String newTitle1 = scan.nextLine();
				book.setTitle(newTitle1);
				System.out.println();
				break;
			case 3:
				System.out.println();
				//book.setVolumeNumber(InputUtil.inputInt(scan, "New巻数："));
				System.out.print("New巻数：");
				int newVolumeNumber1 = scan.nextInt();
				book.setVolumeNumber(newVolumeNumber1);
				System.out.println();
				break;
			case 4:
				System.out.println();
				//book.setYear(InputUtil.inputInt(scan, "New購入年："));
				System.out.print("New購入年：");
				int newYear1 = scan.nextInt();
				book.setYear(newYear1);
				//book.setMonth(InputUtil.inputInt(scan, "New購入月："));
				System.out.print("New購入月：");
				int newMonth1 = scan.nextInt();
				book.setMonth(newMonth1);
				//book.setDay(InputUtil.inputInt(scan, "New購入日："));
				System.out.print("New購入日：");
				int newDay1 = scan.nextInt();
				book.setDay(newDay1);
				System.out.println();
				break;
			case 5:
				System.out.println();
				//book.setPrice(InputUtil.inputInt(scan, "New値段："));
				System.out.print("New値段：");
				int newPrice1 = scan.nextInt();
				book.setPrice(newPrice1);
				System.out.println();
				break;
			case 0:
				return;

			default:
				System.out.println(BookMessage.EDITING_COMPLETE);
				return;
			}
		}
	}

	//消去
	public void deleteBook(Scanner scan) {

		if (bookList.isEmpty()) {
			System.out.println(BookMessage.NOT_FOUND);
			return;
		}

		int number = 1;
		for (Book book : bookList) {
			System.out.println(number + "："
					+ book.getTitle()
					+ " " + book.getVolumeNumber() + "巻");
			number++;
		}
		System.out.println("0：戻る");
		System.out.println();

		//int select = InputUtil.inputInt(scan, "選択：");
		System.out.print("選択：");
		int select = scan.nextInt();
		scan.nextLine();
		if (select == 0) {
			return;
		}
		System.out.println();

		Book book = bookList.get(select - 1);
		System.out.println(book.getTitle() + "を削除しました!");
		bookList.remove(select - 1);

	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}
}