import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class coins {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = null;
		int count1 = 0;
		int count2 = 0;
		
		for( int i = 0; i < n; i++) {
			if(Integer.parseInt(br.readLine()) == 1) {
				count1++;
			}
			else
				count2++;
		}
		
		System.out.println(count1 > count2 ? count2 : count1);
		
		
	}

}
