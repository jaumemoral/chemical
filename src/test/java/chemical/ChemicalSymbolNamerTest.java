package chemical;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ChemicalSymbolNamerTest {

	ChemicalSymbolNamer namer = new ChemicalSymbolNamer();

	@Test
	public void testValidSymbols() {
		assertTrue(namer.checkSymbol("Spenglerium","Ee"));
		assertTrue(namer.checkSymbol("Zeddemorium","Zr"));
		assertTrue(namer.checkSymbol("Venkmine","Kn"));
		assertFalse(namer.checkSymbol("Stantzon","Zt"));
		assertFalse(namer.checkSymbol("Melintzum", "Nn"));
		assertFalse(namer.checkSymbol("Tullium", "Ty"));
		assertTrue(namer.checkSymbol("Aa", "Aa"));
	}

	@Test
	public void testValidSymbolLength() {
		assertFalse(namer.checkSymbol("Spenglerium","S"));
	}

	@Test
	public void testValidSymbolCase() {
		assertFalse(namer.checkSymbol("Spenglerium","ee"));
	}

	@Test
	public void testFirstValidSymbol() {
		assertEquals(namer.findFirstValidSymbol("Gozerium"),"Ei");
		assertEquals(namer.findFirstValidSymbol("Slimyrine"),"Ie");
	}

	@Test
	public void testFindNumberOfValidSymbols() {
		assertEquals(namer.findNumberOfValidSymbols("Zuulon"),11);
	}
	
	@Test
	public void testCreatePeriodicTable() throws IOException {
		PeriodicTable table=namer.createPeriodicTable(Arrays.asList("Protactinium"));		
		assertEquals("Protactinium",table.getNameForSymbol("Pr"));		
	}

	@Test
	public void testFindValidSymbols() {
		String firstName=namer.findValidSymbols("Protactinium").get(0);		
		assertEquals("Pr",firstName);		
	}	
	
	@Test
	public void testCreatePeriodicTableWithAllElements() throws IOException {
		PeriodicTable table=namer.createPeriodicTableWithAllElements();		
		assertEquals("Protactinium",table.getNameForSymbol("Pt"));
		assertEquals("Californium",table.getNameForSymbol("Cf"));
		assertEquals("Lionoium",table.getNameForSymbol("Iu"));
	}



}
