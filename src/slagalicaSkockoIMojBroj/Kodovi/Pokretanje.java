package slagalicaSkockoIMojBroj.Kodovi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.script.ScriptException;

public class Pokretanje {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void kreni() throws IOException, ScriptException {
		System.out.println(ANSI_BLUE + "DOBRODOSLI U SLAGALICU" + ANSI_RESET);
		Skocko.kreni();
		MojBroj.kreni();
		System.out.println(ANSI_BLUE + "Da li zelite novu igru? da/ne" + ANSI_RESET);
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader keyboard = new BufferedReader(isr);
		String b = keyboard.readLine();
		if ("da".equals(b)) {
			kreni();
		} else if ("ne".equals(b)) {
			statistika();
		} else {
			System.err.println("Pogresan unos!");
			statistika();
		}

	}

	public static void statistika() {
		System.out.println("___________________________________________________");
		System.out.println(ANSI_BLUE + "Hvala sto ste igrali Slagalicu!");
		System.out.println(ANSI_YELLOW + "************");
		System.out.println(ANSI_YELLOW + "*" + ANSI_BLUE + "STATISTIKA" + ANSI_YELLOW + "*");
		System.out.println("************" + ANSI_RESET);
		System.out.println(
				"U igri MOJ BROJ ste osvojili ukupno: " + ANSI_GREEN + MojBroj.bodoviUkupno + " bodova" + ANSI_RESET);
		System.out.println("U igri SKOCKO ste osvojili ukupno: " + ANSI_GREEN + Skocko.bodoviUkupno + " bodova");
	}

}
