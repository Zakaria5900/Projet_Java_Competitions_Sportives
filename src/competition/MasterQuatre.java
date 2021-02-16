package competition;

import java.util.*;
/**
 * @author Salah Zakaria OUAICHOUCHE
 * A class that extends Master 
 * it is a Competition that starts with a phase of league system 
 * then takes the first of each ranking in order to create a Tournament between them
 * At the end there will be only one winner
 * */

public class MasterQuatre extends Master{
	protected List<Competitor> competitors ;
	protected List<List<Competitor>> cmpc= new ArrayList<List<Competitor>>();
	protected List<League> poule = new ArrayList<League>();
	protected List<Competitor> tmp = new ArrayList<Competitor>();
	protected List<Competitor> tmp2 = new ArrayList<Competitor>();
	
	public MasterQuatre(List<Competitor> l) {
		super(l);
		this.competitors=l;
	}
	/**
	 * This method does the simulation of the this Competition 
	 */
	@Override
	protected void play(List<Competitor> l) throws NotPowerOfTwoException {
		System.out.println("******** GROUPE PHASE STARTS ********");
		this.leagues=this.repartition();
		List<Competitor> firsts =  new ArrayList<Competitor>();
		for (int i=0;i<this.leagues.size();i++) {
			this.leagues.get(i).play();
		}
		System.out.println("******** KNOCKOUT PHASE STARTS ********");
		firsts=this.getFirstOfEachGroup();
		this.knockOut = new Tournament(firsts);
		this.knockOut.play();
		
	}

	/**
	 * This method does the repartition of the groups in ordre to start the first phase of the game
	 */
	@Override
	public List<League> repartition() {
		if(isPowerOfTwo(this.competitors.size())) {
			for(int i = 0; i<this.competitors.size();i++) {
				if(i==this.competitors.size()-1) {
					this.tmp.add(this.competitors.get(i));
					this.cmpc.add(tmp);
				}
				else if(i%4!=0 && i!= 0) {
					this.tmp.add(this.competitors.get(i));
				}
				else {
					if(i==0) {
						this.tmp.add(this.competitors.get(i));
					}else {
						this.tmp2 = this.tmp;
						this.cmpc.add(tmp2);
						this.tmp= new ArrayList<Competitor>();
						this.tmp.add(this.competitors.get(i));
					}
				}
			}
			for(int n = 0;n<this.cmpc.size();n++) {
				League league = new League(this.cmpc.get(n));
				this.poule.add(league);
			}
		}
		else {
			System.out.println("...");
			System.exit(0);
		}
		return this.poule;
		
	}
	/**
	 * It checks if the number is a power of Two
	 * @param n
	 * @return boolean
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
