package competition;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
/**
 * @author Salah Zakaria OUAICHOUCHE 
 *
 */
public abstract class MasterTest {
	protected static List<Competitor> cmp = new ArrayList<Competitor>();
	protected static Competition l ;
	
	protected abstract Competition createCompetition() ;
}
