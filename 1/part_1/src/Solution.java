import java.io.FileReader;
import java.io.BufferedReader;

public class Solution {
	
	public static void main(String[] args) throws Exception {
	
		if (args == null || args.length == 0) {
			throw new Exception("Invalid input");
		}

		String fileName = args[0];

		long value = 0L;

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			for(String line; (line = br.readLine()) != null; ) {
				int drift = Integer.valueOf(line);
				value += drift;
			}
		}
					
		System.out.println(value);
	}

}
