package competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Salah Zakaria OUAICHOUCHE
 * simulation of a randomLeague
 */
public class MainRandomLeague {
	private static Competitor lucas = new Competitor("lucas");
	private static Competitor bilel = new Competitor("bilel");
	private static Competitor alice = new Competitor("alice");
	private static Competitor lina = new Competitor("lina");
	private static Competitor zakaria = new Competitor("zakaria");
	private static Competitor ons = new Competitor("ons");
	private static Competitor julie = new Competitor("julie");
	private static Competitor marc = new Competitor("marc");
	private static List<Competitor> League1 = new ArrayList<Competitor>();
	private static Competition l;
	public static void main (String[] args) throws NotPowerOfTwoException {
		League1.add(lucas);
		League1.add(bilel);
		League1.add(alice);
		League1.add(lina);
		League1.add(zakaria);
		League1.add(ons);
		League1.add(julie);
		League1.add(marc);
		l = new League(League1);
		l.play();
	}
}
