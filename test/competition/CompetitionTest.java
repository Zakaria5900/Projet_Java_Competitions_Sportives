package competition;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
/**
 * @author Salah Zakaria OUAICHOUCHE
 *
 */

public abstract class CompetitionTest {
	protected static Competitor lucas = new Competitor("lucas");
	protected static Competitor adam = new Competitor("adam");
	protected static Competitor alice = new Competitor("alice");
	protected static Competitor lina = new Competitor("lina");
	protected static Competitor bilel = new Competitor("bilel");
	protected static List<Competitor> cmp = new ArrayList<Competitor>();
	protected static Competition c;

	protected abstract Competition createCompetition();

}