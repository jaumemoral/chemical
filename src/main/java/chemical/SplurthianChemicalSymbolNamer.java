package chemical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplurthianChemicalSymbolNamer implements ChemicalSymbolNamer {

	/* (non-Javadoc)
	 * @see chemical.ChemicalSymbolName#findValidSymbols(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see chemical.ChemicalSymbolName#checkSymbol(java.lang.String, java.lang.String)
	 */
	public boolean checkSymbol(String name, String symbol) {
		return findValidSymbols(name).contains(symbol);
	}

	/* (non-Javadoc)
	 * @see chemical.ChemicalSymbolName#findFirstValidSymbol(java.lang.String)
	 */
	public String findFirstValidSymbol(String name) {
		return Collections.min(findValidSymbols(name));
	}

	/* (non-Javadoc)
	 * @see chemical.ChemicalSymbolName#findNumberOfValidSymbols(java.lang.String)
	 */
	public int findNumberOfValidSymbols(String name) {
		return findValidSymbols(name).size();
	}

}
