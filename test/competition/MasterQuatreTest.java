package competition;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
/**
 * @author Salah Zakaria OUAICHOUCHE 
 *
 */
public class MasterQuatreTest extends MasterTest {
	protected static MasterQuatre mastersQuatre;
	@Before
	public void init() throws NotPowerOfTwoException {
		for(int i=0;i<16;i++) {
			Competitor tmpc = new Competitor("x"+i);
			cmp.add(tmpc);
		}
		mastersQuatre = (MasterQuatre) this.createCompetition();	
		mastersQuatre.play();
	}
	@Test 
	public void MasterQuatrePowerOfTwoTest() throws NotPowerOfTwoException {
		assertTrue(mastersQuatre.isPowerOfTwo(cmp.size()));
	}
	
	@Test
	public void QuatrePremiersMasterQuatreGetFirstOfEachGroup() {
		assertTrue(mastersQuatre.getFirstOfEachGroup().size()==4);	
	}
	@Override
	protected Competition createCompetition() {
		l = new MasterQuatre(cmp);
		return l;
	}

}

