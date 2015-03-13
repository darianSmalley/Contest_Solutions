import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class watch {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		int v = 0;
		int t = 0;
		String input;
		String[] terms;
		int[] movieTimes;
		int k = 0; //index into sorted movieTime array
		int result = 0; //the sum of the minutes of the movies
		
		for ( int i = 0; i < w; i++) {
			input = br.readLine();
			terms = input.split(" ");
			v = Integer.parseInt(terms[0]);
			t = Integer.parseInt(terms[1]);
			movieTimes = new int[v];
			
			for( int j = 0; j < v; j++) {
				terms = br.readLine().split(",");
				movieTimes[j] = Integer.parseInt(terms[1]);
			}
			
			//sort movie list by time ascending
			Arrays.sort(movieTimes);
			
			while ( t > 0) {
				if( (t -= movieTimes[k]) < 0) {
					break;
				}
				result += movieTimes[k]; 
//				System.out.println(t);
				k++;
//				System.out.println(result + " " + k);
			}
			
			System.out.println(k + " " + result);
//			System.out.println(Arrays.toString(movieTimes));
			k=0;
			result = 0;
		}
		
	}

}
