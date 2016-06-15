package slagalicaSkocko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Skocko {
	private int nizKojiTrebaPogoditi[] = new int[4];
	private int moguceResenje[] = new int[4];
	private int brojPobeda;
	private int brojPoraza;
	private Random slucajniBroj = new Random();

	private int[] zadatiKombinaciju() {
		for (int i = 0; i < nizKojiTrebaPogoditi.length; i++) {
			nizKojiTrebaPogoditi[i] = generisiSlucajniBroj();
		}
		// Raskomentarisi ako hoces da vidis zadatu kombinaciju unapred. :)
		// System.out.println("Zadata kombinacija je: " + nizKojiTrebaPogoditi[0] + nizKojiTrebaPogoditi[1]
		// + nizKojiTrebaPogoditi[2] + nizKojiTrebaPogoditi[3]);
		return nizKojiTrebaPogoditi;
	}

	private int generisiSlucajniBroj() {
		return slucajniBroj.nextInt(6) + 1;
	}

	private void podesiVrednostMogucegNiza() throws IOException {
		System.out.println("Unesi 4 cifre od 1 do 6:");
		String unosIgraca = procitajUnos();
		if (daLiJeUnosValidan(unosIgraca)) {
			popuniNizMoguceResenje(unosIgraca);
		} else {
			System.err.println("Pogresan unos!");
		}
	}

	private String procitajUnos() throws IOException {
		InputStream is = System.in;
		InputStreamReader isRdr = new InputStreamReader(is);
		BufferedReader buffRdr = new BufferedReader(isRdr);
		return buffRdr.readLine();
	}

	private boolean daLiJeUnosValidan(String unos) {
		return unos.matches("[1-6]+") && (unos.length() == 4);
	}

	private void popuniNizMoguceResenje(String unos) {
		for (int i = 0; i < 4; i++) {
			moguceResenje[i] = unos.charAt(i) - '0';
		}
	}

	private void proveraPoklapanjaNizova() throws IOException {
		int brojZnakovaNaPravomMestu = kolikoJeZnakovaNaPravomMestu();
		if ((brojZnakovaNaPravomMestu) == 4) {
			System.out.println("Svi znakovi na pravom mestu.");
		} else {
			int brojPogresnihZnakova = kolikoJePogresnihZnakova();
			System.out.println(brojZnakovaNaPravomMestu + " pogodjenih znakova na pravom mestu.");
			System.out.println(brojPogresnihZnakova + " pogresnih znakova.");
			System.out.println((4 - (brojZnakovaNaPravomMestu + brojPogresnihZnakova))
					+ " pogodjenih znakova na pogresnom mestu.");
		}
	}

	private int kolikoJeZnakovaNaPravomMestu() {
		int brojZnakovaNaPravomMestu = 0;
		for (int i = 0; i < 4; i++) {
			if (nizKojiTrebaPogoditi[i] == moguceResenje[i]) {
				brojZnakovaNaPravomMestu++;
			}
		}
		return brojZnakovaNaPravomMestu;
	}

	private int kolikoJePogresnihZnakova() {
		int brojPogresnihZnakova = 0;
		for (int i = 0; i < nizKojiTrebaPogoditi.length; i++) {
			if ((moguceResenje[i] != nizKojiTrebaPogoditi[0]) && (moguceResenje[i] != nizKojiTrebaPogoditi[1])
					&& (moguceResenje[i] != nizKojiTrebaPogoditi[2]) && (moguceResenje[i] != nizKojiTrebaPogoditi[3])) {
				brojPogresnihZnakova++;
			}
		}
		return brojPogresnihZnakova;
	}

	public void pocniIgru() throws IOException {
		zadatiKombinaciju();
		pocniPogadjanjeNiza();
		izbrojPobedeIPoraze();
		zeliteLiNovuIgru();
	}

	private void pocniPogadjanjeNiza() throws IOException {
		for (int i = 1; i < 8; i++) {
			podesiVrednostMogucegNiza();
			proveraPoklapanjaNizova();
			if (!Arrays.equals(nizKojiTrebaPogoditi, moguceResenje)) {
				System.out.println("Imate jos " + (7 - i) + " pokusaja.");
			} else {
				break;
			}
		}
	}

	private void izbrojPobedeIPoraze() {
		if (Arrays.equals(nizKojiTrebaPogoditi, moguceResenje)) {
			brojPobeda++;
		} else {
			brojPoraza++;
			prikaziTacanNiz();
		}
		System.out.println("Do sada imate " + brojPobeda + " pobeda" + " i " + brojPoraza + " poraza");
	}

	private void prikaziTacanNiz() {
		System.out.println("Tacan niz je: " + Arrays.toString(nizKojiTrebaPogoditi));
	}

	private void zeliteLiNovuIgru() throws IOException {
		System.out.println("Da li zelite novu igru? da/ne");
		String novaIgra = procitajUnos();
		if (novaIgra.equals("da")) {
			pocniIgru();
		} else if (novaIgra.equals("ne")) {
			System.out.println("Dovidjenja!");
		} else {
			System.err.println("Greska.");
		}
	}

}
