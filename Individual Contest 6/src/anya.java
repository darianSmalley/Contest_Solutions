import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class anya {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = null;
		
		for ( int i = 0;i < n; i++) {
			input = br.readLine();
			if ( isPali(input))
				System.out.println("Ay");
			else
				datPali(input);
		}
		
	}
	
	public static void datPali(String s) {
		StringBuilder sb;
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			sb = new StringBuilder(s.charAt(i));
			
			for(int j = i; j < s.length(); j++) {
				sb.append(s.charAt(j));
				
				if ( sb.length() >= 3 && sb.charAt(0) == (sb.charAt(sb.length() - 1))) {
					if( isPali(sb.toString())) {
						count++;
						i+=j;
						break;
					}
				}
				
				if(count >= 2)
					break;
			}
			
			if(count >= 2)
				break;
		}
		
		if(count >= 2) {
			System.out.println("Ay");
		}
		else
			System.out.println("Nap");
	}

	public static boolean isPali(String s) {
		s = s.toLowerCase();
		s = s.replaceAll("[^a-zA-Z]","");
		StringBuilder sb = new StringBuilder(s);
		
		if ( sb.reverse().toString().equals(s))
			return true;
		else
			return false;
	}
	
}
