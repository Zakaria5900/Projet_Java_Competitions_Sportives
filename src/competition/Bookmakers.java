package competition;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")

/**
 * @author Salah Zakaria OUAICHOUCHE 
 * A class that implements CompetitionObserver , a Bookmaker is an Object that 
 * controls the odd of each competitor according to the result that was showed by 
 * the journalists 
 */


public class Bookmakers implements CompetitionObserver{
	protected  Map<Competitor, Integer> odds = new HashMap<>();
	
	public Bookmakers(Competition cmp) {
		for (Competitor competitor : cmp.competitors) {
			odds.put(competitor, 3);
		}
	}
	/**
	 * This method i crucial for a bookmaker it takes the result from the Journalist 
	 * and changes the odd of the winner and the looser
	 * For the winner : the odd is increased by 1
	 * And for the looser : the odd is decreased by 1
	 */
	
	@Override
	public void react2match(Competitor w, Competitor l) {
		this.printOdds(w, l);

		if (this.odds.get(w) > 1) {
			this.odds.put(w, this.odds.get(w)-1);
		}
		if (this.odds.get(w)==1) {}
		else {
			this.odds.put(l, this.odds.get(l)+1);
		}
		
	}
	
	/**
	 * @param winner a Competitor that has won the match 
	 * @param looser a Competitor that has lost the match 
	 * This method show's the odds of each Competitor
	 */
	public void printOdds(Competitor winner, Competitor looser) {
		System.out.println("The odd of "+winner.getName()+ " is : " + this.odds.get(winner) + " and The odd of " + looser.getName() + " is : " + this.odds.get(looser));
	}
}
