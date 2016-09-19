package chemical;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PeriodicTableTest {

	ChemicalSymbolNamer namer= new SplurthianChemicalSymbolNamer();

	@Test
	public void testAddElement() throws IOException, NoPossibleSymbolException {
		PeriodicTable table= new PeriodicTable(namer);
		table.addElement("Protactinium");
		assertEquals("Protactinium",table.getNameForSymbol("Pr"));
	}

	@Test
	public void testCreatePeriodicTableWithAllElements() throws IOException {
		PeriodicTable table=new PeriodicTable(namer);
		List<String> elements=new TextFileReader().readLines("elements.txt");
		try {
			table.addElements(elements);
		} catch (NoPossibleSymbolException e) {
			;
		}
		assertEquals("Protactinium",table.getNameForSymbol("Pt"));
		assertEquals("Californium",table.getNameForSymbol("Cf"));
		assertEquals("Lionoium",table.getNameForSymbol("Iu"));
	}



}
