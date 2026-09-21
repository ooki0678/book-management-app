
//＊別の作り方バージョンで作ったやつだからこれは使ってない！＊

package 前期審査会作品.本管理アプリ.util;

import java.util.Scanner;

public class InputUtil {
	public static String inputString(Scanner scan, String message) {
		System.out.print(message);
		return scan.nextLine();
	}

	public static int inputInt(Scanner scan, String message) {
		System.out.print(message);
		int number = scan.nextInt();
		scan.nextLine();
		return number;
	}
}
