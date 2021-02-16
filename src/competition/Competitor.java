package competition;

/**
 * @author Salah Zakaria OUAICHOUCHE
 * class creates Competitor
 **/

public class Competitor {
	private String name ;
	private int points = 0 ;
	
	public Competitor(String name) {
		this.name = name ; 
	}
/**
 * Getter
 * @return (String) competitor's name
 */
	public String getName() {
		return this.name;
	}
/**
 * Getter 
 * @return (int) competitor's points
 */
	public int getPoints() {
		return this.points;
	}
	
	
	/**
	 * adds 1 to the points of a Competitor
	 */
	public void addPoints() {
		this.points+=1;
	}
/**
 * description of the competitor
 * @return (String) Description
 */
	public String toString() {
		return (this.name+" has "+this.points+" points.");
	}
}
