package competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Salah Zakaria OUAICHOUCHE 
 * Tha main class that is simulating a competition with the journalist and a brooker
 * in order to show the odd of each team after every match
 */
public class BookmakersMain {
	private static Competitor lucas = new Competitor("lucas");
	private static Competitor bilel = new Competitor("bilel");
	private static Competitor alice = new Competitor("alice");
	private static Competitor lina = new Competitor("lina");
	private static Competitor zakaria = new Competitor("zakaria");
	private static Competitor ons = new Competitor("ons");
	private static Competitor julie = new Competitor("julie");
	private static Competitor marc = new Competitor("marc");
	private static Competition compet;
	private static List<Competitor> cmpet = new ArrayList<Competitor>(); 
	
	public static void main (String[] args) throws NotPowerOfTwoException {
		cmpet.add(lucas);cmpet.add(bilel);cmpet.add(alice);cmpet.add(lina);
		cmpet.add(zakaria);cmpet.add(ons);cmpet.add(julie);cmpet.add(marc);

		compet = new Tournament(cmpet);

		CompetitionObserver j1 = new Journalist();
		compet.register(j1);
		Bookmakers bm = new Bookmakers(compet);
		compet.register(bm);
		
		compet.play();
	}
}
