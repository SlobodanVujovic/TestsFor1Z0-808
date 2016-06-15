package slagalicaSkockoIMojBroj.Kodovi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MojBroj {

	static int a[] = new int[4];
	static Object calculation;
	static List<Integer> dozvoljeniBrojevi = new ArrayList<>();
	static List<Integer> uneseniBrojevi = new ArrayList<>();
	static int randIntDvocif1;
	static int randInt2;
	static int zadataKombinacija;
	static String userInput;
	static Random rand = new Random();
	static int rezultat;
	static int bodovi;
	static int bodoviUkupno;

	public static void zadataKombinacija() {
		zadataKombinacija = rand.nextInt(1000);
	}

	public static int[] randNizJednocif() {

		a[0] = rand.nextInt(9) + 1;
		a[1] = rand.nextInt(9) + 1;
		a[2] = rand.nextInt(9) + 1;
		a[3] = rand.nextInt(9) + 1;
		return a;
	}

	public static void randIntDvocif1() {
		int b[] = { 10, 15, 20 };
		int rnd = new Random().nextInt(b.length);
		randIntDvocif1 = b[rnd];

	}

	public static void randInt2() {
		int c[] = { 25, 50, 75, 100 };
		int rnd = new Random().nextInt(c.length);
		randInt2 = c[rnd];
	}

	public static void unos() throws IOException, ScriptException {

		zadataKombinacija();
		randNizJednocif();
		randIntDvocif1();
		randInt2();
		long startTime = System.currentTimeMillis();
		System.out.println("Zadata kombinacija je: " + zadataKombinacija);

		System.out.println("Izracunajte kombinaciju koristeci brojeve: |" + a[0] + "|" + a[1] + "|" + a[2] + "|" + a[3]
				+ "|  |" + randIntDvocif1 + "|  |" + randInt2 + "|");

		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		Scanner in = new Scanner(System.in);
		userInput = in.next();
		long endTime = System.currentTimeMillis();
		formiranjeLista();

		if ((endTime - startTime) <= 100000) {
			if (uneseniBrojevi.size() < 7 && uneseniBrojevi.size() > 0
					&& (dozvoljeniBrojevi.containsAll(uneseniBrojevi))) {
				for (int i = uneseniBrojevi.size() - 1; i > -1; i--) {
					for (int k = 5; k > -1; k--) {
						if (uneseniBrojevi.get(i).equals(dozvoljeniBrojevi.get(k))) {
							uneseniBrojevi.remove(i);
							break;
						}
					}
				}
			} else {
				System.err.println("Pogresan unos!");
			}

			try {
				if (uneseniBrojevi.isEmpty()) {

					calculation = engine.eval(userInput);

					if (calculation instanceof Number) {
						rezultat = (Integer) calculation;
						System.out.println("Vas rezultat je: " + rezultat);
						if (rezultat == zadataKombinacija) {
							System.out.println("Tacan broj!");

						} else {
							System.out.println("Netacan broj.");

						}
					} else {
						System.err.println("Pogresan unos!");
					}

				} else {
					System.err.println("Pogresan unos.");
				}
			} catch (javax.script.ScriptException e) {
				System.out.println("Pogresan unos!");
			}

		} else {
			System.out.println("Vreme je isteklo!");
		}
	}

	public static void formiranjeLista() {
		try {
			String[] s = userInput.split("\\D+");
			int[] intarray = new int[s.length];
			for (int i = 0; i < s.length; i++) {
				intarray[i] = Integer.parseInt(s[i]);
			}

			for (int i = 0; i < intarray.length; i++) {
				uneseniBrojevi.add(intarray[i]);
			}

		} catch (NumberFormatException e) {

		}

		dozvoljeniBrojevi.add(a[0]);
		dozvoljeniBrojevi.add(a[1]);
		dozvoljeniBrojevi.add(a[2]);
		dozvoljeniBrojevi.add(a[3]);
		dozvoljeniBrojevi.add(randIntDvocif1);
		dozvoljeniBrojevi.add(randInt2);

	}

	public static void pressAnyKeyToContinue() {
		System.out.println("Nakon sto unesete bilo koji karakter, imate 100 sekundi da izracunate zadati broj.");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public static void bodovi() {
		if (rezultat == zadataKombinacija) {
			bodovi = 30;
		} else if ((rezultat == zadataKombinacija - 1) || (rezultat == zadataKombinacija + 1)) {
			bodovi = 20;
		} else if ((rezultat >= zadataKombinacija - 5) && (rezultat <= zadataKombinacija + 5)) {
			bodovi = 10;
		} else if ((rezultat >= zadataKombinacija - 10) && (rezultat <= zadataKombinacija + 10)) {
			bodovi = 5;
		} else {
			bodovi = 0;
		}
		System.out.println("U igri MOJ BROJ ste osvojili: " + bodovi + " bodova.");
		bodoviUkupno = bodoviUkupno + bodovi;
	}

	public static void kreni() throws IOException, ScriptException {
		System.out.println("--- Pocinje igra MOJ BROJ ---");
		pressAnyKeyToContinue();
		unos();
		bodovi();
	}

}
