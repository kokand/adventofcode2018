import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Set;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws Exception{
	
		if (args == null || args.length == 0) {
			throw new Exception("Invalid input");
		}

		String fileName = args[0];

		Set<String> possibilities = new HashSet<>();
		Set<String> matches = new HashSet<>();

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			for (String line; (line = br.readLine()) != null;) {
				Set<String> generatedStrings = generateStrings(line.toCharArray());
				for (String string : generatedStrings) {
					if (possibilities.contains(string)) {
						matches.add(string);
					} else {
						possibilities.add(string);
					}
				}	
			}
		}

		matches.stream().forEach(item -> System.out.println(item.substring(0, item.length() -1)));
	}

	private static Set<String> generateStrings (char[] characters) {
		Set<String> generatedStrings = new HashSet<>();
		for (int i = 0; i < characters.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < characters.length; j++) {
				if (i == j) {
					continue;
				}
				sb.append(characters[j]);	
			}
			generatedStrings.add(sb.append(i).toString());
		}
		return generatedStrings;
	}

}

