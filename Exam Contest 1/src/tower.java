import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class tower {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for( int i = 0; i < n; i++) {
			System.out.println(br.readLine());
		}
		
	}

}
