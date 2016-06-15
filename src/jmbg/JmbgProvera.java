package jmbg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JmbgProvera {

	private String prvih12Cifara;
	private String jmbg;

	public void setJmbg(String jmbg) throws java.lang.StringIndexOutOfBoundsException {
		this.jmbg = jmbg;
		try {
			prvih12Cifara = jmbg.substring(0, 12); // StringIndexOutOfBoundsException se javlja ako je jmbg prekratak, pa ne moze da se kreira
													// substring.
			String ddmmgggrrbbb = "((((0[1-9]|1[0-9]|2[0-8])(0[1-9]|1[012]))|((29|30|31)(0[13578]|1[02]))|((29|30)(0[4,6,9]|11)))(9|0)\\d\\d\\d\\d\\d\\d\\d)|(29()02(9|0)(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)\\d\\d\\d\\d\\d)";
			// provera prvih 12 cifara jmbg-a

			Pattern D = Pattern.compile(ddmmgggrrbbb);
			Matcher r = D.matcher(prvih12Cifara);
			if ((jmbg.length() == 13 && r.find()) && proveraKontrolneCifre() == true) {
				System.out.println("JMBG je validan.");
			} else {
				System.out.println("JMBG nije validan.");
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.err.println("Pogresan JMBG.");
		}
	}

	private boolean proveraKontrolneCifre() { // provera 13. cifre jmbg-a
		int[] niz = new int[13];
		for (int i = 0; i < 13; i++) {
			niz[i] = Integer.parseInt(jmbg.substring(i, i + 1));
		}
		/*
		 * int Aaa = Integer.parseInt(jmbg.substring(0, 1)); int Bbb = Integer.parseInt(jmbg.substring(1, 2)); int Ccc =
		 * Integer.parseInt(jmbg.substring(2, 3)); int Ddd = Integer.parseInt(jmbg.substring(3, 4)); int Eee = Integer.parseInt(jmbg.substring(4, 5));
		 * int Fff = Integer.parseInt(jmbg.substring(5, 6)); int Ggg = Integer.parseInt(jmbg.substring(6, 7)); int Hhh =
		 * Integer.parseInt(jmbg.substring(7, 8)); int Iii = Integer.parseInt(jmbg.substring(8, 9)); int Jjj = Integer.parseInt(jmbg.substring(9,
		 * 10)); int Kkk = Integer.parseInt(jmbg.substring(10, 11)); int Lll = Integer.parseInt(jmbg.substring(11, 12)); int Mmm =
		 * Integer.parseInt(jmbg.substring(12));
		 */
		int kontr = 11 - ((7 * (niz[0] + niz[6]) + 6 * (niz[1] + niz[7]) + 5 * (niz[2] + niz[8]) + 4 * (niz[3] + niz[9])
				+ 3 * (niz[4] + niz[10]) + 2 * (niz[5] + niz[11])) % 11);
		if (kontr > 9) {
			kontr = 0;
		}
		return kontr == niz[12] ? true : false; // Ne znam da li ste pominjali ovaj ternarni operator (? :).
		/*
		 * if (kontr == niz[12]) { return true; } else { return false; }
		 */
	}
}