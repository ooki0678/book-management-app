package 前期審査会作品.本管理アプリ.menu;

import java.util.Scanner;

public class Menu {
	public static int showMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("========================");
		System.out.println("   本管理アプリ");
		System.out.println("========================");
		System.out.println("1 : 一覧");
		System.out.println("2 : 追加");
		System.out.println("3 : 検索");
		System.out.println("4 : 編集");
		System.out.println("5 : 消去");
		//		System.out.println("6 : 保存");
		//		System.out.println("7 : 読み込み");
		System.out.println("0 : 終了");
		System.out.println("終了前にちゃんと保存をしないと追加/編集したデータ️が消えてしまうので注意してください‼️");
		System.out.println("========================");
		System.out.print("選択：");
		return scan.nextInt();
	}
}