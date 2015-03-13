import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class cosmic {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int u = Integer.parseInt(br.readLine());
		int a = 0;
		int b = 0;
		String input = null;
		String[] terms;
		double survivalRate = 0;
		
		for(int i = 0; i < u; i++) {
			input = br.readLine();
			terms = input.split(" ");
			a = Integer.parseInt(terms[0]);
			b = Integer.parseInt(terms[1]);
			survivalRate = survivalRate(a,b);
			System.out.println("Universe #" + (i + 1) + ": There's a " + formatOutput(survivalRate) + "% chance we'll survive!");
		}
		
	}
	
	private static String formatOutput(double survivalRate) {
		DecimalFormat df = new DecimalFormat("#####0.0000");
		return df.format(survivalRate);
	
	}

	public static double survivalRate(int a, int b) {
		int lcm = lcm(a,b);
		int multiplesOfA_exclusive = lcm / a - 1;
		int mutliplesOfB_exclusive = lcm /b - 1;
		int numOfDestStars = multiplesOfA_exclusive + mutliplesOfB_exclusive;
		double precentTobeDestroyed = ((double)numOfDestStars / (double)lcm) * 100 ;
		double precentToSurvive = 100 - precentTobeDestroyed;
		
		return precentToSurvive;
	}
	
	public static int lcm(int a, int b) {
		return (a * b)/gcd(a,b);
	}
	
	public static int gcd(int a, int b) {
		return  b == 0 ? a : gcd(b, a % b);
	}
}
