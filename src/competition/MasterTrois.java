 package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.MapUtil;

/**
 * @author Salah Zakaria OUAICHOUCHE 
 * it is a Competition that starts with a phase of league system 
 * then takes the first , the second of each ranking and then the best thirds in order to create a Tournament between them
 * At the end there will be only one winner
 */
public class MasterTrois extends Master {
	protected List<League> poule = new ArrayList<League>(); 
	protected List<Competitor> bestThirds;
	protected List<Competitor> competitors;
	protected List<List<Competitor>> cmpc= new ArrayList<List<Competitor>>();
	protected List<Competitor> tmp = new ArrayList<Competitor>();
	protected List<Competitor> tmp2 = new ArrayList<Competitor>();
	public MasterTrois(List<Competitor> l) {
		super(l);
		this.competitors=l;
	}
	/**
	 *	This method dimulates this competition
	 */
	@Override
	protected void play(List<Competitor> l) throws NotPowerOfTwoException {
		System.out.println("******** GROUPE PHASE STARTS ********");
		this.leagues=this.repartition();
		List<Competitor> finals =new ArrayList<Competitor>();
		List<Competitor> firsts =  new ArrayList<Competitor>();
		List<Competitor> seconds =  new ArrayList<Competitor>();
		for (int i=0;i<this.leagues.size();i++) {
			this.leagues.get(i).play();
		}
		System.out.println("******** KNOCKOUT PHASE STARTS ********");
		firsts=this.getFirstOfEachGroup();
		seconds = this.getSecondOfEachGroup();
		this.bestThirds=this.getBestThird();
		for(int i =0;i<firsts.size();i++) {
			finals.add(firsts.get(i));
		}
		for(int i =0;i<seconds.size();i++) {
			finals.add(seconds.get(i));
		}
		for(int i =0;i<this.bestThirds.size();i++) {
			finals.add(this.bestThirds.get(i));
		}
		this.knockOut = new Tournament(finals);
		this.knockOut.play();
		
	}
	/**
	 * It does the repartition of the list of the players in order to start this competition
	 */
	@Override
	public List<League> repartition() {
		if(this.competitors.size()==24) {
			for(int i = 0; i<this.competitors.size();i++) {
				if(i==0){
					tmp.add(this.competitors.get(i));
					i++;
				}
				if(i==this.competitors.size()-1) {
					tmp.add(this.competitors.get(i));
					this.cmpc.add(tmp);
				}
				if(i%8!=0) {
					tmp.add(this.competitors.get(i));
				}
				else {
					this.tmp2 = this.tmp;
					this.cmpc.add(tmp2);
					this.tmp= new ArrayList<Competitor>();
					this.tmp.add(this.competitors.get(i));
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
	 * It gets the best two thirds 
	 */
	@Override
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
