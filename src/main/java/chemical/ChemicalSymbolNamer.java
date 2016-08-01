package chemical;

import java.util.TreeSet;

public class ChemicalSymbolNamer {

	private TreeSet<String> findValidSymbols(String name) {
		TreeSet<String> symbols=new TreeSet<String>();
		char letters[]=name.toCharArray();
		for (int i=0;i<letters.length-1;i++) {
			for (int j=i+1;j<letters.length;j++) {
				symbols.add(""+Character.toUpperCase(letters[i])+letters[j]);
			}
		}
		return symbols;
	}

	public boolean checkSymbol(String name, String symbol) {
		return findValidSymbols(name).contains(symbol);
	}

	public String findFirstValidSymbol(String name) {
		return findValidSymbols(name).first();
	}

	public int findNumberOfValidSymbols(String name) {
		return findValidSymbols(name).size();
	}

}
