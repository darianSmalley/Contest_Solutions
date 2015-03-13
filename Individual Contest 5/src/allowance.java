import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class allowance {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		long n = 0;
		
		for ( int i = 0; i < w; i++) {
			n = Long.parseLong(br.readLine());
			
		maxAllowance(n);
			
		}
		
	}

	private static void maxAllowance(long n) {
		//2^x -1 
		//x must be less than 34
		double[] arrPowTwo = powersOfTwo();
		bianrySearch(arrPowTwo, n);
	}
	
	private static void bianrySearch(double[] arrPowtwo, long n) {
		int i = 0;
		
		for (i = 0; i < 34;i++) {
			if (arrPowtwo[i] > n)
				break;
		}

		i--;
		print(i , (int) arrPowtwo[i]);
	}


	private static void print(int sum, int i) {
		System.out.println(sum + " " + i);
	}

	public static double[] powersOfTwo(){
		int n = 34; //2^34 > 10^9
		double[] arr = new double[n];
		
		for ( int i = 0; i < n; i++) {
			arr[i]=Math.pow(2, (double) i) - 1; //minus one offset to get max number of binary digets
		}
		
		return arr;
	}

}