package competition;

/**
 * @author Salah Zakaria OUAICHOUCHE
 * Journalist is class that implements the interface CompetitionObserver
 * The journalist assits to the matchs and shows the results
 */
public class Journalist implements CompetitionObserver { 
	/**
	 * This method reacts to a match and shows the result on the STDOUT
	 */
	public void react2match(Competitor w, Competitor l) {
		System.out.println(w.getName() + " is the winner against " + l.getName());
	}
}
