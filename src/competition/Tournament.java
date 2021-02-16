package competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Salah Zakaria OUAICHOUCHE
 *
 */
public class Tournament extends Competition {
	final Match match;
	final List<Competitor> competitors;
	protected List<Competitor> other;
	protected Competitor winner ;
	protected Competitor loser;
	public static Competitor TourWinner;
	/**
	 * constructor takes a list of competitors
	 */
	public Tournament(List<Competitor> l) {
		super(l);
		this.competitors=l;
		this.match=super.match;
		
	}

	/**
	 * @param takes list of competitors, verifies, number of competitors is a power of two
	 * true, takes every competitor and starts a match  betweenn them 
	 *  else the program stops running
	 */
	@Override
	protected void play(List<Competitor> l) throws NotPowerOfTwoException{
		if(this.isPowerOfTwo(l.size())) {
			boolean isFinished = false;
			this.other= new ArrayList<Competitor>();
			while (isFinished != true) {
				System.out.println("--------- NEXT ROUND ---------");
				for(int i=0;i+1<l.size();i+=2){
					Competitor fst = l.get(i);
					Competitor snd =  l.get(i+1);
					this.playMatch(fst, snd);
					if(this.winner==fst) {
						this.other.add(fst);
					}else {
						this.other.add(snd);
					}
					System.out.println(fst.getName() + " X " + snd.getName() +" => " + this.winner.getName());
					if (i+2==l.size()) {
						l = this.other;
						this.other=new ArrayList<Competitor>();
					}
				if(l.size()==1) {
					isFinished = true;
					TourWinner = this.winner;
				}
			}
			}
		}
		else {
				throw new NotPowerOfTwoException("The number of competitors must be even");
				}
			
		}
	/**
	 * simulates match between two competitors adds a point to the winner
	 * works with the random number that was generated (1 or 2)
	 */
	@Override
	protected void playMatch(Competitor c1, Competitor c2) {
		if (this.match.getRandom()==1) {
			c1.addPoints();
			this.winner=c1;
			//this.loser=c2;
		}
		else {
			c2.addPoints();
			this.winner=c2;
			//this.loser=c1;
		}
		
		
	}

	/**
	 * @return a boolean 
	 * True of the argument is a number power of  2 
	 * False otherwise
	 */
	
	protected boolean isPowerOfTwo(int n) {
		if (n == 0) 
            return false; 
  
        while (n != 1) { 
            if (n % 2 != 0) 
                return false; 
            n = n / 2; 
        } 
        return true; 
	}
}
