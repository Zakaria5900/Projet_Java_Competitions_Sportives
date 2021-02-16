package competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Salah Zakaria OUAICHOUCHE 
 * 
 * */
public class MasterTroisMain {
	private static List<Competitor> cmp = new ArrayList<Competitor>();
	private static Competition l;
	public static void main (String[] args) throws NotPowerOfTwoException {
		for (int i=0 ; i<24;i++) {
			Competitor tmpc = new Competitor("Jouer "+i);
			cmp.add(tmpc);
		}
		l = new MasterTrois(cmp);
		l.play();
	}
}
