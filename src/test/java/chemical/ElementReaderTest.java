package chemical;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ElementReaderTest {

	ElementReader reader = new ElementReader();
	
	@Test
	public void testReadAllElements() throws IOException {
		List<String> names=reader.readAllElements();
		assertEquals("Hydrogen",names.get(0));		
		assertEquals("Sharptoothium",names.get(names.size()-1));
	}



}
