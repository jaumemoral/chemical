package chemical;

public class NoPossibleSymbolException extends Exception {

	public NoPossibleSymbolException(String symbol) {
		super(symbol);
	}

}
