package competition;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author Salah Zakaria OUAICHOUCHE 
 *
 */
public class CompetitorTest {
	Competitor zakaria;

	@Before
	public void init() {
		zakaria = new Competitor("Zakaria");
	}

	@Test
	public void getNameTest() {
		assertTrue(zakaria.getName() == "Zakaria");
	}

	@Test
	public void pointInitializedToZeroTest() {
		assertEquals(zakaria.getPoints(), 0);
	}

	@Test
	public void addPointsOkTest() {
		assertTrue(zakaria.getPoints() == 0);
		zakaria.addPoints();
		assertEquals(zakaria.getPoints(), 1);
	}

}