package chemical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplurthianChemicalSymbolNamer implements ChemicalSymbolNamer {

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
		return Collections.min(findValidSymbols(name));
	}

	public int findNumberOfValidSymbols(String name) {
		return findValidSymbols(name).size();
	}

}
