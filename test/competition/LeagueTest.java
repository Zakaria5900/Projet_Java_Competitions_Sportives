package competition;

import static org.junit.Assert.*;


import java.util.*;
import org.junit.*;

import util.MapUtil;
/**
 * @author Salah Zakaria OUAICHOUCHE 
 *
 */
public class LeagueTest extends CompetitionTest {
	protected Competition comp;

	@Override
	protected Competition createCompetition() {
		return new League(super.cmp);
	}

	@Before
	public void init() {
		this.comp = this.createCompetition();
	}

	@Test
	public void CompetitionRankingTrueTest() throws NotPowerOfTwoException {
		super.cmp.add(alice);
		super.cmp.add(lucas);
		comp.play();
		List<Competitor> ranking = new ArrayList<Competitor>();
		if (alice.getPoints() == 0) {
			ranking.add(lucas);
			ranking.add(alice);
		} else if (alice.getPoints() == 1) {
			ranking.add(alice);
			ranking.add(lucas);
		} else {
			ranking.add(alice);
			ranking.add(lucas);
		}
		HashMap<Competitor, Integer> map = new HashMap<Competitor, Integer>();
		for (int i = 0; i < cmp.size(); i++) {
			map.put(cmp.get(i), cmp.get(i).getPoints());
		}
		Map<Competitor, Integer> rank = MapUtil.sortByDescendingValue(map);
		assertEquals(rank, comp.ranking());

	}
}
