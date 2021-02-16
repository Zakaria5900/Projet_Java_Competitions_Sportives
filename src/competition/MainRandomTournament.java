package competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Salah Zakaria OUAICHOUCHE
 *  simulation of a randomTournament
 */
public class MainRandomTournament {
	private static Competitor lucas = new Competitor("lucas");
	private static Competitor bilel = new Competitor("bilel");
	private static Competitor alice = new Competitor("alice");
	private static Competitor lina = new Competitor("lina");
	private static Competitor zakaria = new Competitor("zakaria");
	private static Competitor ons = new Competitor("ons");
	private static Competitor julie = new Competitor("julie");
	private static Competitor marc = new Competitor("marc");
	private static List<Competitor> tour1 = new ArrayList<Competitor>();
	private static Competition l;
	public static void main (String[] args) throws NotPowerOfTwoException {
		tour1.add(lucas);
		tour1.add(bilel);
		tour1.add(alice);
		tour1.add(lina);
		tour1.add(zakaria);
		tour1.add(ons);
		tour1.add(julie);
		tour1.add(marc);
		l = new Tournament(tour1);
		l.play();
	}
}
