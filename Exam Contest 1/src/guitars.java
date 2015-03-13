import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *kruskal's algorithm to find Minimum Spanning Tree of given connected, undirected and weight graph 
 */
public class guitars {
	
	public static class Edge implements Comparable<Edge> {
		int src = 0;
		int dest = 0;
		int weight = 0;
		
		public Edge (int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			if(this.weight > e.weight) {
				return 1;
			}
			else if (this.weight == e.weight) {
				return 0;
			}
			else {
				return -1;
			}
		}

		@Override
		public String toString() {
			return "Edge [src=" + (src + 1) + ", dest=" + (dest + 1) + ", weight=" + weight
					+ "]";
		}
		
		
	}
	
	public static class Graph {
		int verticies = 0;
		int edges = 0;
		List<Edge> E = new ArrayList<Edge>();
		
		public void addEdge(Edge e) {
			E.add(e);
			edges++;
		}
	}
	
	public static int find(int x, int[] par) {
		if( par[x] == x) return x;
		
		int leader = 0;
		leader = find(par[x], par);
		
		par[x] = leader;
		return leader;
	}
	
	public static void join(int a, int b, int[] par) {
		int pa, pb;
		pa = find(a, par);
		pb = find(b, par);
		
		par[pa] = pb;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		int M = 0;
		String input = null;
		String[] terms;
		Graph G;
		Edge e;
		int[] par; 
		List<Edge> list; 
		
		for(int i = 0; i < T; i++) {
			 G = new Graph();
			 list = new ArrayList<Edge> ();
			input = br.readLine();
			terms = input.split(" ");
			N = Integer.parseInt(terms[0]); //num of verticies
			M = Integer.parseInt(terms[1]); //num of edges
			G.verticies = N;
			
			for ( int j = 0; j < M; j++) {
				//break apart input and assign values
				input = br.readLine();
				terms = input.split(" ");
				int src = Integer.parseInt(terms[0]) - 1;
				int dest = Integer.parseInt(terms[1]) -1;
				int weight = Integer.parseInt(terms[2]);
				
				//Initialize edge and add to graph
				e = new Edge(src, dest, weight);
				G.addEdge(e);
				
			}
			
			par = new int[G.verticies];
			Collections.sort(G.E);
			
			for( int k = 0; k < N; k++) {
				par[k] = k;
			}
			
			if(G.edges < G.verticies -1) {
				//in this case there are not enough edges to reach all vertices and the graph is not fully connected
				System.out.println(-1);
			}
			else{
				for(int j = 0; j < N; j++) {
					int u = G.E.get(j).src;
					int v = G.E.get(j).dest;
					
					if(find(u,par) != find(v,par)) {
						join(u,v,par);
						list.add(G.E.get(j));
					}
				}
				
//				System.out.println(list.toString());
				int sum = 0;
				for( int l = 0; l < list.size(); l++) {
					sum += list.get(l).weight;
				}
				System.out.println(sum);
			}
			
		}
	}
}
