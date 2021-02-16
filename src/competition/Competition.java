package competition;
import java.util.*;

import java.util.Map;
import util.MapUtil;

/**
 * @author Salah Zakaria OUAICHOUCHE
 */
public abstract class Competition {
	 protected Competitor winner;
	 protected Competitor looser;
	 protected List<CompetitionObserver> compObservers = new ArrayList<CompetitionObserver>();
	 final Match match;
	 protected String nameClasse = this.getClass().getName();
	 final List<Competitor> competitors;
	 protected HashMap<Competitor,Integer> map = new HashMap<Competitor,Integer>();
	 /**
	  * CONSTRUCTOR that creates an Object Competition
	 * @param l a list of competitors 
	 * it initialize a random match too
	 */
	public Competition(List<Competitor> l) {
		this.competitors = l;
		this.match =  new MatchAleatoire();
	 }
	 /**
	 * TWO ABSTRACT METHODS 
	 * THE FIRST ONE TAKES A LIST OPF COMPETITORS AND IT DOES MAKE MATCH BETWEEN ALL PLAYERS 
	 * THE SND ONE SIMULATES A GAME BETWEEN TWO COMPETITORS NLY
	 * @throws NotPowerOfTwoException 
	 */
	protected abstract void play(List<Competitor> l) throws NotPowerOfTwoException;
	protected abstract void playMatch(Competitor c1 , Competitor c2);
	
	/**
	 * @return (MAP) a map of Competitors with them points 
	 * the final ranking of this competition
	 */
	public Map<Competitor, Integer> ranking(){
		for ( int i = 0 ; i < this.competitors.size();i++) {
			map.put(this.competitors.get(i),this.competitors.get(i).getPoints());
		}
		Map<Competitor, Integer> rank = MapUtil.sortByDescendingValue(map);
		
		return rank;		
	}
	
	/**
	 * it simualtes this Compertition
	 * @throws NotPowerOfTwoException 
	 */
	public void play() throws NotPowerOfTwoException {
		this.play(this.competitors);
		Map<Competitor, Integer> rank = this.ranking();
		if(this.nameClasse =="competition.League") {
			System.out.println("*****************");
			System.out.println(".... RANKING ....");
			System.out.println("*****************");
			for (Competitor name: rank.keySet()){
	            String key = name.getName();
	            int value = name.getPoints();  
	            System.out.println(key +" - "+ value);  
			}
			System.out.println("*****************");
		}else {
			System.out.println("***THE WINNER IS***    ");
	        System.out.println("***      "+Tournament.TourWinner.getName().toUpperCase()+"      ***");
		}
	}
	
	public void register(CompetitionObserver observer) {
		this.compObservers.add(observer);
	}
	
	public void unregister(CompetitionObserver observer) {
		this.compObservers.remove(observer);
	}
	
	public List<CompetitionObserver> getcompObservers(){
		return this.compObservers;
	}
	
}

