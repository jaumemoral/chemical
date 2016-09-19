package chemical;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class TextFileReaderTest {

	TextFileReader reader = new TextFileReader();

	@Test
	public void testReadAllElements() throws IOException {
		List<String> names=reader.readLines("elements.txt");
		assertEquals("Hydrogen",names.get(0));
		assertEquals("Sharptoothium",names.get(names.size()-1));
	}



}
