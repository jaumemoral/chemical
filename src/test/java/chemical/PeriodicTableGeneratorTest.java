package chemical;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PeriodicTableGeneratorTest {

	PeriodicTableGenerator generator= new PeriodicTableGenerator(new ChemicalSymbolNamer());

	@Test
	public void testCreatePeriodicTable() throws IOException {
		PeriodicTable table=generator.createPeriodicTable(Arrays.asList("Protactinium"));
		assertEquals("Protactinium",table.getNameForSymbol("Pr"));
	}

	@Test
	public void testCreatePeriodicTableWithAllElements() throws IOException {
		PeriodicTable table=generator.createPeriodicTableWithAllElements();
		assertEquals("Protactinium",table.getNameForSymbol("Pt"));
		assertEquals("Californium",table.getNameForSymbol("Cf"));
		assertEquals("Lionoium",table.getNameForSymbol("Iu"));
		assertEquals("Margium",table.lastElementAdded());
	}



}
