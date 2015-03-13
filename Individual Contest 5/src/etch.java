import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class etch {
	static double target = 0;
	static double a = 0;
	static double b = 0;
	static double c = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = null;
		String[] terms;
		for (int i = 0; i < n; i++) {
			input = br.readLine();
			terms = input.split(" ");
			a = Double.parseDouble(terms[2]);
			b = Double.parseDouble(terms[3]);
			c = Double.parseDouble(terms[4]);
			
			System.out.print("Crystal #" + (i + 1) + ": ");
			etchTime(Double.parseDouble(terms[0]), Double.parseDouble(terms[1]));
			System.out.println();
			System.out.println();
		}
	}
	
	public static void etchTime(double f1, double f2) {
		target = (f2 - f1) / (f1*f2);
		binarySearch(0.00, 1000000.00);
	}
	
	//in this use "mid" is our t value
	public static void binarySearch(double lo, double hi) {
		
		DecimalFormat df = new DecimalFormat("#######.##");
		while (lo < hi) {
			double mid = lo + (hi-lo)/2;
			if (df.format(lo).equals(df.format(hi) )) {
				break;
			}
			if (p(mid) > target) {
				hi = mid;
			}
			else
				lo = mid + .001;
		}

		formattedPrint(lo);
	}

	private static void formattedPrint(double lo) {
		DecimalFormat df = new DecimalFormat("#####0.00");
		System.out.print(df.format(lo));		
	}

	public static double p(double t) {
		double result = (a*t) + (b * (1-(1/Math.exp(c*t))));
		return result;
	}
}
