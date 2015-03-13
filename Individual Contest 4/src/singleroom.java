import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class singleroom {
	
	private static class Event implements Comparable<Event>{
		int s = 0;
		int f = 0;
		
		public Event(int start, int finish) {
			s = start;
			f = finish;
		}
		public static final Comparator<Event> finishTimeComparator = new Comparator<Event>() {

			@Override
			public int compare(Event e1, Event e2) {
				if (e1.f > e2.f)
					return 1;
				else if( e1.f < e2.f)
					return -1;
				else
					return 0;
			}
			
		};

		@Override
		public int compareTo(Event e) {
			if ( this.f > e.f)
				return 1;
			else if (this.f < e.f)
				return -1;
			else
				return 0;
		}

		@Override
		public String toString() {
			return "Event [start=" + s + ", finish=" + f + "]";
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if ( n < 1) System.out.println("No test cases."); 
		String[] terms;
		List<Event> eventList = new ArrayList<Event>();
		Event currentEvent;
		
		for ( int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < k; j++) {
				terms = br.readLine().split(" ");
				int s = Integer.parseInt(terms[0]);
				int f = Integer.parseInt(terms[1]);
				currentEvent = new Event(s,f);
				eventList.add(currentEvent);
			}
			
			System.out.println("Test case " + (i + 1) + ": A maximum of " + doGreedy(eventList) + " events can be scheduled.");
			eventList.clear();
		}
	}
	
	/**
	 * 
	 * @param arr - array of the finish times of all entered events
	 * @param map - hash map of key: finish time, value: start time
	 * @return - maxium number of events that can be scheduled
	 */
	public static int doGreedy(List<Event> list) {
		Collections.sort(list, Event.finishTimeComparator);
		Event prev = new Event(list.get(0).s,list.get(0).f);
		int total = 1; //accounting for preloading schedule event list with first event
		
		for ( int i = 0; i < list.size(); i++) {
			int currentStart = list.get(i).s;
			int previousEnd = prev.f;
			
			if (currentStart >= previousEnd) { //if the current start time is greater or equal to the previous's end time, schedule
				total++;
				prev = list.get(i);
			}
		}
		return total;
	}

}
