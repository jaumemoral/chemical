package chemical;

import java.io.IOException;
import java.util.List;

public class PeriodicTableGenerator {

	ChemicalSymbolNamer namer;

	public PeriodicTableGenerator(ChemicalSymbolNamer namer) {
		this.namer=namer;
	}

	public PeriodicTable createPeriodicTableWithAllElements() throws IOException {
		List<String> names=new ElementReader().readAllElements();
		PeriodicTable table=createPeriodicTable(names);
		return table;
	}

	public PeriodicTable createPeriodicTable(List<String> names) {
		PeriodicTable table=new PeriodicTable();
		try {
			for (String name:names) addToPeriodicTable(name,table);
		} catch (NoPossibleSymbolException e) {
			;// No fem res!
		}
		return table;
	}

	public void addToPeriodicTable(String name, PeriodicTable table) throws NoPossibleSymbolException {
		for (String symbol: namer.findValidSymbols(name)) {
			if (table.isSymbolAvailable(symbol)) {
				table.addElement(name,symbol);
				return;
			}
		}
		throw new NoPossibleSymbolException(name);
	}
}
