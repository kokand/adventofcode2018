import java.io.FileReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
	
	public static void main(String[] args) throws Exception {
	
		if (args == null || args.length == 0) {
			throw new Exception("Invalid input");
		}

		String fileName = args[0];

		long value = 0L;

		Set<Long> freqs = new HashSet<>();
		freqs.add(value);
		Long firstDuplicate = null;

		List<Integer> drifts = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			for(String line; (line = br.readLine()) != null; ) {
				int drift = Integer.valueOf(line);
				drifts.add(drift);
				value += drift;
				if (addIfNotExist(freqs, value)) {
					firstDuplicate = value;
					break;
				}
			}
		}

		int index = 0;
		while (firstDuplicate == null) {
			value += drifts.get(index);
			if (addIfNotExist(freqs, value)) {
				firstDuplicate = value;
				break;
			}
			index = (index + 1) % drifts.size();
		}
					
		System.out.println(firstDuplicate);
	}

	private static boolean addIfNotExist(Set<Long> values, Long value) {
		if (values.contains(value)){
			return true;
		} else {
			values.add(value);
			return false;
		}
	}

}
