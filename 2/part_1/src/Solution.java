import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws Exception{
	
		if (args == null || args.length == 0) {
			throw new Exception("Invalid input");
		}

		String fileName = args[0];

		int twos = 0;
		int threes = 0;

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			for (String line; (line = br.readLine()) != null;) {
				Map<Integer, Set<Character>> characterMap = getReverseCharacterMap(line.toCharArray());
				if (characterMap.containsKey(2)) {
					twos++;
				}
				if (characterMap.containsKey(3)) {
					threes++;
				}
				
			}
		}


		long product = (long) twos * threes;

		System.out.println(product);
	}

	private static Map<Integer, Set<Character>> getReverseCharacterMap (char[] characters) {
		Map<Character, Integer> characterMap = new HashMap<>();

		for (char c : characters) {
			Integer currentValue = characterMap.putIfAbsent(c, 1);
			if (currentValue != null) {
				characterMap.put(c, (currentValue + 1));
			}
		}
		
		Map<Integer, Set<Character>> reverseMap = new HashMap<>();

		for (Map.Entry<Character, Integer> entry : characterMap.entrySet()) {
			Set<Character> characterSet = reverseMap.putIfAbsent(entry.getValue(), new HashSet<>(Arrays.asList(entry.getKey())));
			if (characterSet != null) {
				characterSet.add(entry.getKey());
				reverseMap.put(entry.getValue(), characterSet);
			}
		}

		return reverseMap;
	}

}

