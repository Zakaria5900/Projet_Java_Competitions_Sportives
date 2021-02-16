package competition;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
import org.junit.*;
/**
 * @author Salah Zakaria OUAICHOUCHE 
 *
 */
public class MatchTest {
	protected static List<Competitor> cmp = new ArrayList<Competitor>();
	protected static League l;
	protected static Competitor c1;
	protected static Competitor c2;
	protected static Competitor c;

	@Before
	public void init() {
		c1 = new Competitor("Zakaria");
		cmp.add(c1);
		c2 = new Competitor("Ons");
		cmp.add(c2);
		l = new League(cmp);
	}

	@Test
	public void MatchNoDrawTest() {
		assertTrue(c1.getPoints() == c2.getPoints());
		l.playMatch(c1, c2);
		c = l.winner;
		assertTrue(c == c1 || c == c2);
		if (c.getName() == c1.getName()) {
			assertTrue(c1.getPoints() == 1);
			assertEquals(c2.getPoints(), 0);
		} else {
			assertEquals(c2.getPoints(), 1);
			assertFalse(c1.getPoints() == 1);
		}
	}

	@Test
	public void MatchNoTwoWinnersTest() {
		assertTrue(c1.getPoints() == 0);
		assertTrue(c2.getPoints() == 0);
		l.playMatch(c1, c2);
		assertFalse(c1.getPoints() == c2.getPoints());
		c = l.winner;
		assertFalse(c == c2 && c == c1);

	}

}
