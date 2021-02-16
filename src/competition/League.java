package competition;

import java.util.List;
/**
 * @author Salah Zakaria OUAICHOUCHE
 *
 */

public class League extends Competition {

	final Match match;
	final List<Competitor> competitors;
	protected List<Competitor> other;
	protected Competitor winner ;
	/**
	 * constructor takes a list of competitors
	 * @param l
	 */
	 
	public League(List<Competitor> l) {
		super(l);
		this.competitors=l;
		this.match=super.match;
		
	}

	/**
	 * @param takes a list of competitors, verifies, number competitors is a power of two
	 *  true, takes every competitor and starts a match  betweenn them 
	 *  else the program stops ryunning
	 */
	@Override
	protected void play(List<Competitor> l) {
		for (int i = 0 ; i<this.competitors.size();i++) {
			Competitor fst = this.competitors.get(i);
			for ( int j =0 ;j <this.competitors.size();j++) {
				Competitor snd =  this.competitors.get(j);
				if (i!=j) {
					this.playMatch(fst, snd);
					System.out.println(fst.getName() + " VS " + snd.getName() +" --> " + this.winner.getName()+" wins !");
				}
			}
		}
	}

	/**
	 * simulates match between two competitors, adds a point to the winner
	 * works with the random number that was generated (1 or 2)
	 * @param 2 competiteurs  type <Competitor>
	 */
	@Override
	protected void playMatch(Competitor c1, Competitor c2) {
		if (this.match.getRandom()==1) {
			c1.addPoints();
			this.winner=c1;
			this.looser = c2;
		}
		else {
			c2.addPoints();
			this.winner=c2;
			this.looser= c1;
		}
		for (CompetitionObserver sportObserver : this.getcompObservers()) {
			sportObserver.react2match(winner, looser);
		}
		
	}
}


