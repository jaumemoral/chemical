package chemical;

import java.io.IOException;
import java.util.List;

public class PeriodicTableSolver {

	public static void main(String[] args) throws IOException {
		PeriodicTable table= new PeriodicTable(new SplurthianChemicalSymbolNamer());
		List<String> elements=new TextFileReader().readLines("elements.txt");
		try {
			table.addElements(elements);
		} catch (NoPossibleSymbolException e) {
			System.out.println(table);
			System.out.println("First element with no symbol: "+e.getMessage());
		}
	}

}
