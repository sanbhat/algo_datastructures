package algo.sort.string;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class KeyIndexedCounting {

	static class KeyAndString {
		
		private int key;
		
		private String str;
		
		public KeyAndString(int key, String str) {
			this.key = key;
			this.str = str;
		}

		@Override
		public String toString() {
			return str + " " + key;
		}
		
		
	}
	
	//number of ASCII characters
	private static final int R = 256;
	
	public KeyAndString[] sort(KeyAndString[] arr) {
		int n = arr.length;
		
		KeyAndString[] result = new KeyAndString[n];
		int[] count = new int[R+1];
		
		//Compute frequency counts
		for(int i=0; i<n; i++) {
			count[arr[i].key + 1] ++;
		}
		
		//Transform the count into indices
		for(int r=0; r<R; r++) {
			count[r+1] += count[r];
		}
		
		//Distribute the records
		for(int i=0; i<n; i++) {
			result[count[arr[i].key] ++ ] = arr[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		try {
			Path path = Paths.get(KeyIndexedCounting.class.getClassLoader().getResource("algo/sort/string/keyIndexedCounting.txt").toURI());
			Stream<String> lines = Files.lines(path);
			List<KeyAndString> list = new ArrayList<>();
			System.out.println("Input -");
			lines.forEach(s -> {
				String[] split = s.split("\\s");
				String str = split[0].trim();
				int key = Integer.valueOf(split[1].trim());
				KeyAndString k = new KeyAndString(key, str);
				System.out.println(k);
				list.add(k);
			});
			lines.close();
			
			KeyIndexedCounting kic = new KeyIndexedCounting();
			KeyAndString[] result = kic.sort(list.toArray(new KeyAndString[list.size()]));
			for(KeyAndString k : result) {
				System.out.println(k);
			}
			
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	
}
