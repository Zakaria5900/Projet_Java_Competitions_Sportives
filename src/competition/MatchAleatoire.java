package competition;
/**
 * @author Salah Zakaria OUAICHOUCHE
 *
 */
public class MatchAleatoire implements Match{
	
	private int rand;
	/**
	 * constructor only initialize a random match
	 * generates a random number (int) between 1 and 2 
	 */
	public MatchAleatoire() {
		super();
		 
	}
	
	/**
	 *a getter that return the Random number
	 */
	public int getRandom() {
		this.rand = (int) (Math.random() * (2 - 1 + 1) ); 
		return this.rand;
	}
}
