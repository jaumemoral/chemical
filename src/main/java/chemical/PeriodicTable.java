package chemical;

import java.util.HashMap;

public class PeriodicTable {
	
	HashMap<String, String> table=new HashMap<String,String>();

	public boolean isSymbolAvailable(String symbol) {
		return !table.containsKey(symbol);
	}

	public void addElement(String name, String symbol) {
		table.put(symbol, name);
	}

	public Object getNameForSymbol(String symbol) {
		return table.get(symbol);
	}
	
	

}
