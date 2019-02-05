import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pack {

	private static Random ran = new Random();

	private static File LegendaryFile = new File("Legendary.csv");
	private static String[] Legendary;
	private static File EpicFile = new File("Epic.csv");
	private static String[] Epic;
	private static File RareFile = new File("Rare.csv");
	private static String[] Rare;
	private static File CommonFile = new File("Common.csv");
	private static String[] Common;

	public static void main(String[] args) {

		try{
			Scanner inputStream = new Scanner(LegendaryFile);
			String line = inputStream.nextLine();
			inputStream.close();
			Legendary = line.split(",  ");

			inputStream = new Scanner(EpicFile);
			line = inputStream.nextLine();
			inputStream.close();
			Epic = line.split(",  ");

			inputStream = new Scanner(RareFile);
			line = inputStream.nextLine();
			inputStream.close();
			Rare = line.split(",  ");

			inputStream = new Scanner(CommonFile);
			line = inputStream.nextLine();
			inputStream.close();
			Common = line.split(",  ");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many packs would you like to open?");
		int count = keyboard.nextInt();
		keyboard.close();

		for (int i = 0; i < count; i++) {
			for (String card : open()) {
				System.out.println(card);
			}
			System.out.println("");
		}

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

	}

	private static List<String> open() {
		List<String> contents = new ArrayList<String>();
		String card;
		int rarity;
		int golden;
		int choice;
		int commons = 0;
		for (int i = 0; i < 5; i++) {
			rarity = ran.nextInt(10000);
			golden = ran.nextInt(10000);

			if (rarity < 111) {
				choice = ran.nextInt(Legendary.length);
				card = Legendary[choice];
				if (golden < 8) { card = "Golden " + card; }
				card = "[L] " + card;
			}
			else if (rarity < 443) {
				choice = ran.nextInt(Epic.length);
				card = Epic[choice];
				
				card = "[E] " + card;
			}
			else if (rarity < 2285) {
				choice = ran.nextInt(Rare.length);
				card = Rare[choice];
				if (golden < 128) { card = "Golden " + card; }
				card = "[R] " + card;
			}
			else {
				if (commons < 4) {
					choice = ran.nextInt(Common.length);
					card = Common[choice];
					if (golden < 149) { card = "Golden " + card; }
					card = "[C] " + card;
					commons++;
				}
				else {
					choice = ran.nextInt(Rare.length);
					card = Rare[choice];
					if (golden < 20) { card = "Golden " + card; }
					card = "[R] " + card;
				}
				
			}
			contents.add(card);
		}
		return contents;
	}

}
