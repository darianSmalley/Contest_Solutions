import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class contractor {
	
	static ArrayList<Integer> savedSums = new ArrayList<Integer>();
	
	private static class Job {
		int p = 0;
		int d = 0;
		
		public Job(int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Job [p=" + p + ", d=" + d + "]";
		}
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		int	n = 0;
		int d = 0;
		String input = null;
		String[] terms;
		List<Job> jobs = new ArrayList<Job>();
		
		
		long startTime = System.nanoTime();
		
		for (int i = 0; i < c; i++) {
			input = br.readLine();
			terms = input.split(" ");
			n = Integer.parseInt(terms[0]);
			d = Integer.parseInt(terms[1]);
			
			for ( int j = 0; j < n; j++) {
				input = br.readLine();
				terms = input.split(" ");
				jobs.add(new Job(Integer.parseInt(terms[1]), Integer.parseInt(terms[0])));
			}
			
			jobs = prune( jobs, d);
			recurse(0, d, 0, 0, jobs);
			
			System.out.println(Collections.max(savedSums));
			savedSums.clear();
			jobs.clear();
		}
		
		long endTime = System.nanoTime();

		long duration = (endTime - startTime); 
//		System.out.println(duration/1000000);
	}
	
	public static void recurse(int curDays, int maxDays, int sum, int i, List<Job> list){
		if ( i > list.size() - 1) {
			if ( curDays <= maxDays) {
				savedSums.add(sum);
			}
			return;
		}
			
		if ( curDays > maxDays)
			return;
		
		recurse(curDays + list.get(i).d, maxDays, sum + list.get(i).p, i + 1, list);
		recurse(curDays, maxDays, sum, i + 1, list);
	}
	
	public static List<Job> prune (List<Job> list, int n) {
		
		for ( int i = 0; i < list.size(); i++) {
			if ( list.get(i).d > n) {
				list.remove(i);
			}
		}
		
		return list;
	}
	
}
