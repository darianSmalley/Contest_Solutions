import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class genetics {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		String input = null;
		
		for(int i = 0; i < c; i++) {
			input = br.readLine();
			
			//if input is only numbers, convert from decimal to base 4
			if( input.matches("[0-9]+")) 
				System.out.println("Sequence #" + (i + 1) + ": " + decimalToBaseGenes(Integer.parseInt(input)));
			else //else input has characters
				System.out.println("Sequence #" + (i + 1) + ": " + sequenceToDecimal(input));
		}

	}

	private static int sequenceToDecimal(String input) {
		int sum = 0;
		int n = input.length();
		
		for( int i = 0; i < n; i++) {
			
			switch(input.charAt(i)) {
				case 'A':break;
				case 'C':sum+= 1 * Math.pow(4,n-1-i);break;
				case 'G':sum+= 2 * Math.pow(4,n-1-i);break;
				case 'T':sum+= 3 * Math.pow(4,n-1-i);break;
			}
		}
		
		return sum;
	}

	private static String decimalToBaseGenes(int n) {
		StringBuilder sb = new StringBuilder();
		
		while ( n > 0) {
			sb.append(n%4);
			n /= 4;
		}
		
		sb.reverse();
		
		for(int i = 0; i < sb.length(); i++) {
			switch(sb.charAt(i)) {
				case '0': sb.setCharAt(i, 'A');break;
				case '1': sb.setCharAt(i, 'C');break;
				case '2': sb.setCharAt(i, 'G');break;
				case '3': sb.setCharAt(i, 'T');break;
			}
		}
		return sb.toString();
		
	}

}
