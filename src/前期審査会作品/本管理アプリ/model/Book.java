package 前期審査会作品.本管理アプリ.model;

public class Book {
	private String title;
	private int VolumeNumber;
	private int year;
	private int month;
	private int day;
	private int Price;

	public Book(String title, int volumeNumber, int year, int month, int day, int price) {
		super();
		this.title = title;
		VolumeNumber = volumeNumber;
		this.year = year;
		this.month = month;
		this.day = day;
		Price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVolumeNumber() {
		return VolumeNumber;
	}

	public void setVolumeNumber(int volumeNumber) {
		VolumeNumber = volumeNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void BookInformationList() {
		System.out.println("========================\n" +
				"タイトル：" + getTitle() + "\n" +
				"巻数：" + getVolumeNumber() + "巻" + "\n" +
				"購入日：" + getYear() + "/" + getMonth() + "/" + getDay() + "\n" +
				"値段：" + getPrice() + "円" + "\n" +
				"========================");
	}
}
