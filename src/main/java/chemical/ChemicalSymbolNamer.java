package chemical;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ChemicalSymbolNamer {


	public List<String> findValidSymbols(String name) {
		List<String> symbols=new ArrayList<String>();
		char letters[]=name.toCharArray();
		for (int i=0;i<letters.length-1;i++) {
			for (int j=i+1;j<letters.length;j++) {
				String symbol=""+Character.toUpperCase(letters[i])+letters[j];
				if (!symbols.contains(symbol)) symbols.add(symbol);
			}
		}
		return symbols;
	}
	
	
	public boolean checkSymbol(String name, String symbol) {
		return findValidSymbols(name).contains(symbol);
	}

	public String findFirstValidSymbol(String name) {
		List<String> symbols=findValidSymbols(name);
		Collections.sort(symbols);
		return symbols.get(0);
	}

	public int findNumberOfValidSymbols(String name) {
		return findValidSymbols(name).size();
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
		for (String symbol: findValidSymbols(name)) {
			if (table.isSymbolAvailable(symbol)) {
				table.addElement(name,symbol);
				return;
			}
		}
		throw new NoPossibleSymbolException(name);
	}

}
