package chemical;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PeriodicTable {

	ChemicalSymbolNamer namer;
	private Map<String, String> table=new LinkedHashMap<String,String>();

	public PeriodicTable(ChemicalSymbolNamer namer) {
		this.namer=namer;
	}

	public void addElements(List<String> names) throws NoPossibleSymbolException {
		for (String name:names) addElement(name);
	}

	public void addElement(String name) throws NoPossibleSymbolException {
		for (String symbol: namer.findValidSymbols(name)) {
			if (!table.containsKey(symbol)) {
				table.put(symbol,name);
				return;
			}
		}
		throw new NoPossibleSymbolException(name);
	}

	public String getNameForSymbol(String symbol) {
		return table.get(symbol);
	}

	public String toString() {
		StringBuilder builder=new StringBuilder();
		for (Map.Entry<String, String> pair: table.entrySet()) {
			builder.append(pair.getValue());
			builder.append(" -> ");
			builder.append(pair.getKey());
			builder.append("\n");
		}
		return builder.toString();
	}
}
