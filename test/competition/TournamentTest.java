package competition;

import static org.junit.Assert.*;


import org.junit.Test;

import java.util.*;
import org.junit.*;
/**
 * @author Salah Zakaria OUAICHOUCHE 
 *
 */
public class TournamentTest extends CompetitionTest {
	Competition comp;

	@Override
	protected Competition createCompetition() {
		return new Tournament(super.cmp);
	}

	@Before
	public void init() {
		super.cmp.add(alice);
		super.cmp.add(lucas);
		super.cmp.add(bilel);
		super.cmp.add(lina);
	}

	@Test(expected = NotPowerOfTwoException.class)
	public void CompetitionTournamentNumberIsPowerOfTwoWhenNotOkTest() throws NotPowerOfTwoException {
		cmp.add(adam);
		comp = new Tournament(cmp);
		comp.play();
	}

	@Test
	public void CompetitionTournamentOnlyOneWinnerTest() throws NotPowerOfTwoException {
		comp = new Tournament(cmp);
		Competitor temp;
		comp.play();
		Map<Competitor, Integer> rank = comp.ranking();
		temp = cmp.iterator().next();
		assertTrue(cmp.contains(temp));
	}
}
