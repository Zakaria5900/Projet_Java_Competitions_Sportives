package competition;

import java.util.*;

import util.MapUtil;
/**
 * @author Salah Zakaria OUAICHOUCHE
 *  Master is an abstract class that extends Competition 
 * */

public abstract class Master extends Competition{
	protected List<Competitor> competitors;
	protected Competitor winner;
	protected List<League> leagues;
	protected Competition knockOut;
	protected List<Competitor> firstOfEachGroup;
	protected List<Competitor> secondOfEachGroup;
	protected List<Competitor> bestThirds;
	protected List<League> poule = new ArrayList<League>(); 
	public Master(List<Competitor> l) {
		super(l);
		this.competitors=l;
	}
	public abstract List<League> repartition() ;

	/**
	 * A function that simulates the ranking of the competitions and takes 
	 * the first Competitor from every group of the competition
	 * @return List 
	 */
	public List<Competitor> getFirstOfEachGroup(){
		this.firstOfEachGroup = new ArrayList<Competitor>();
		List<Competitor> tmp = new ArrayList<Competitor>();
		Map<Competitor , Integer> map = new HashMap<Competitor,Integer>();
		List<Map<Competitor,Integer>> ranks=  new ArrayList<Map<Competitor,Integer>>();
		for(int i = 0; i<this.leagues.size();i++) {
			map = this.leagues.get(i).ranking();
			MapUtil.sortByDescendingValue(map);
			ranks.add(map);
		}
		for(int i = 0;i<ranks.size();i++) {
			for (Competitor name: ranks.get(i).keySet()){
	            tmp.add(name); 
			}
			this.firstOfEachGroup.add(tmp.get(0));
			tmp= new ArrayList<>();
		}
		
		
		return this.firstOfEachGroup;
	}
	/**
	 * A function that simulates the ranking of the competitions and takes 
	 * the second from every group of the competition
	 * @return List
	 */
	public List<Competitor> getSecondOfEachGroup(){
		this.secondOfEachGroup = new ArrayList<Competitor>();
		List<Competitor> tmp = new ArrayList<Competitor>();
		Map<Competitor , Integer> map = new HashMap<Competitor,Integer>();
		List<Map<Competitor,Integer>> ranks=  new ArrayList<Map<Competitor,Integer>>();
		for(int i = 0; i<this.leagues.size();i++) {
			map = this.leagues.get(i).ranking();
			MapUtil.sortByDescendingValue(map);
			ranks.add(map);
		}
		for(int i = 0;i<ranks.size();i++) {
			for (Competitor name: ranks.get(i).keySet()){
	            tmp.add(name); 
			}
			this.secondOfEachGroup.add(tmp.get(1));
			tmp= new ArrayList<>();
		}
		
		
		return secondOfEachGroup;
	}
	/**
	 * A function that stocks the winner of the actual match of a certain competition between two Competitors 
	 */
	@Override
	protected void playMatch(Competitor c1, Competitor c2) {
		if (this.match.getRandom()==1) {
			c1.addPoints();
			this.winner=c1;
		}
		else {
			c2.addPoints();
			this.winner=c2;
		}		
	}
	
	public List<Competitor> getBestThird() {
		this.bestThirds=new ArrayList<Competitor>();
		List<Competitor> tmp = new ArrayList<Competitor>();
		Map<Competitor , Integer> map;HashMap<Competitor , Integer> xmap = new HashMap<Competitor,Integer>();
		List<Map<Competitor,Integer>> ranks=  new ArrayList<Map<Competitor,Integer>>();
		for(int i = 0; i<this.poule.size();i++) {
			map = this.poule.get(i).ranking();
			MapUtil.sortByDescendingValue(map);
			ranks.add(map);
		}
		for(int i = 0;i<ranks.size();i++) {
			int x = 1;
			for (Competitor name: ranks.get(i).keySet()){
				if(x==3){
					xmap.put(name, name.getPoints());
	            }
				x = x+1;
			}
		}
		Map<Competitor , Integer> mapRanked = MapUtil.sortByDescendingValue(xmap);
		for (Competitor name: mapRanked.keySet()){
            tmp.add(name);
		}
		this.bestThirds.add(tmp.get(0));
		this.bestThirds.add(tmp.get(1));
		
		return this.bestThirds;
	}

}
