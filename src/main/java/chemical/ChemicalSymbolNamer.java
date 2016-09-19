package chemical;

import java.util.List;

public interface ChemicalSymbolNamer {

	public abstract List<String> findValidSymbols(String name);

	public abstract boolean checkSymbol(String name, String symbol);

	public abstract String findFirstValidSymbol(String name);

	public abstract int findNumberOfValidSymbols(String name);

}