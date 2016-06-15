package slagalicaSkockoIMojBroj.Kodovi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Skocko {

	static int a[] = new int[4];
	static int noviNiz[] = new int[4];
	static int bodovi;
	static int bodoviUkupno;
	static int counter2;

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static int randInt() {
		Random rand = new Random();
		int randomNum = rand.nextInt(6) + 1;
		return randomNum;
	}

	public static int[] zadataKoombinacija() {

		a[0] = randInt();
		a[1] = randInt();
		a[2] = randInt();
		a[3] = randInt();

		System.out.println(
				"Zadata kombinacija je: " + ANSI_RED + a[0] + " " + a[1] + " " + a[2] + " " + a[3] + ANSI_RESET);
		// ovo gore raskomentarisi ako hoces da vidis zadatu kombinaciju unapred :)
		return a;

	}

	public static void kombinacije() throws IOException {
		System.out.println(ANSI_BLUE + "Unesite 4 cifre od 1 do 6:" + ANSI_RESET);
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader keyboard = new BufferedReader(isr);
		String b = keyboard.readLine();

		if (b.matches("[1-6]+") && (b.length() == 4)) {

			for (int i = 0; i < 4; i++) {
				noviNiz[i] = b.charAt(i) - '0';
			}

		} else {
			System.err.println("Pogresan unos!");

		}
	}

	public static void proveraKombinacije() throws IOException {

		int counter = 0; // broj znakova na pravom mestu
		for (int i = 0; i < 4; i++) {
			if (a[i] == noviNiz[i]) {
				counter++;
			}
		}
		if (counter == 4) {
			System.out.println(ANSI_GREEN + "Svi znakovi na pravom mestu." + ANSI_RESET);
		} else if (counter < 4) {
			System.out.println(ANSI_RED + counter + ANSI_RESET + " pogodjenih znakova na pravom mestu.");

		}

		int counter1 = 0; // broj znakova na pogresnom mestu

		if ((a[0] != noviNiz[0]) && (a[0] != noviNiz[1]) && (a[0] != noviNiz[2]) && (a[0] != noviNiz[3])) {
			counter1++;
		}
		if ((a[1] != noviNiz[0]) && (a[1] != noviNiz[1]) && (a[1] != noviNiz[2]) && (a[1] != noviNiz[3])) {
			counter1++;
		}
		if ((a[2] != noviNiz[0]) && (a[2] != noviNiz[1]) && (a[2] != noviNiz[2]) && (a[2] != noviNiz[3])) {
			counter1++;
		}
		if ((a[3] != noviNiz[0]) && (a[3] != noviNiz[1]) && (a[3] != noviNiz[2]) && (a[3] != noviNiz[3])) {
			counter1++;
		}

		if (counter != 4) {
			System.out.println(
					ANSI_RED + (4 - (counter + counter1)) + ANSI_RESET + " pogodjenih znakova na pogresnom mestu.");

		}

	}

	public static void bodovi() {

		if (counter2 <= 6) {
			bodovi = 30;
		} else if (counter2 == 7) {
			bodovi = 20;
		} else {
			bodovi = 0;
		}
		System.out.println("U igri SKOCKO ste osvojili: " + ANSI_GREEN + bodovi + " bodova." + ANSI_RESET);
		bodoviUkupno = bodoviUkupno + bodovi;
	}

	public static void kreni() throws IOException {

		System.out.println(ANSI_RED + "--- Pocinje igra SKOCKO ---" + ANSI_RESET);
		zadataKoombinacija();
		for (int i = 1; (((i < 8) && (i > 0))); i++) {
			if (!Arrays.equals(a, noviNiz)) {
				kombinacije();
				proveraKombinacije();

				System.out.println("Imate jos " + ANSI_RED + (7 - i) + ANSI_RESET + " pokusaja.");

				counter2++;
			}
		}
		bodovi();

	}

}
