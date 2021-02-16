package competition;

import static org.junit.Assert.*;

import org.junit.*;
/**
 * @author Salah Zakaria OUAICHOUCHE 
 *
 */

public class MasterTroisTest extends MasterTest {
	protected static MasterTrois masters;
	protected static MasterTrois mastersPlayed;
	@Before
	public void init() throws NotPowerOfTwoException {
		for(int i=0;i<24;i++) {
			Competitor tmpc = new Competitor("x"+i);
			cmp.add(tmpc);
		}	
	}
	@Test
	public void MasterTroisGetFirstOfEachGroup() throws NotPowerOfTwoException {
		masters = (MasterTrois) this.createCompetition();
		masters.play();
		assertTrue(masters.getFirstOfEachGroup().size()==3);
	}
	@Test
	public void MasterTroisBestThirdCompetitorsTypeOfCompetitor() {
		assertEquals(masters.getBestThird().get(0).getClass(),Competitor.class);
	}
	@Test
	public void MasterTroisGetBestThirdsTwonOnlyCompetitors() {
		assertTrue(masters.getBestThird().size()==2);
	}
	
	@Override
	protected Competition createCompetition() {
		l = new MasterTrois(cmp);
		return l;
	}

}
