package chemical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ElementReader {
	public List<String> readAllElements() throws IOException {
		InputStream inputStream=this.getClass().getClassLoader().getResource("elements.txt").openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		List<String> names=new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null) names.add(line);
		return names;
	}
}
