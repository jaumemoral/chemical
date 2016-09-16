package chemical;

import java.util.HashMap;

public class PeriodicTable {
	
	private HashMap<String, String> table=new HashMap<String,String>();
	private String lastName;

	public boolean isSymbolAvailable(String symbol) {
		return !table.containsKey(symbol);
	}

	public void addElement(String name, String symbol) {
		table.put(symbol, name);
		lastName=name;
	}

	public Object getNameForSymbol(String symbol) {
		return table.get(symbol);
	}
	
	public String lastElementAdded() {
		return lastName;
	}

}
