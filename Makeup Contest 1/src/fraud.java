import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class fraud {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		String input = null;
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		List<String> matches = new ArrayList<String>();
		boolean result = true;
		
		for(int i = 0; i < n; i++) {
			//check to see if input matches target string
			input = br.readLine();
			
			for(int j = 0; j < target.length(); j++) {
				if(target.charAt(j) != '*'  && input.charAt(j) != target.charAt(j)) {
					result = false;
					break;
				}
			}
			
			if(result) {
				count++;
				matches.add(input);
			}
			result = true;
		}
		System.out.println(count);
		
		for(int i = 0; i < matches.size(); i++) {
			System.out.println(matches.get(i));
		}
	}

}
