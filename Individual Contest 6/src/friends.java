import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class friends {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //number of test cases
		int f = 0; //number of people in network
		String input = null; //this will hold the list of names in each network, i.e. the vertices
		String[] vertices; //this will hold each name in the social network, case-sensitive
		int[][] adjMatrix; //this will hold edges between vertices
		int c = 0; //number of friend connections / edges
		int r = 0; //number of rivals to compare
		String rival = null; //current rival to compare against, who may not be registered in the network
		String[] connection; //current friend connection to set
		int vi = 0; //vertex array index
		int vj = 0; //vertex array index
		int yourCoolness = 0;
		int rivalCoolness = 0;
		
		for( int i = 0; i < n; i++) {
			System.out.println("Social Network " + (i + 1) + ":");
			f = Integer.parseInt(br.readLine());
			input = br.readLine();
			vertices = input.split(" ");
			Arrays.sort(vertices);
			adjMatrix = new int[vertices.length][vertices.length]; // |v| x |v| array initialized to 0
			c = Integer.parseInt(br.readLine());
			 
			for( int j = 0; j < c; j++) {
				//read friend connections
				input = br.readLine();
				connection = input.split(" ");
				
				//get index of friend in vertex array
				vi = Arrays.binarySearch(vertices, connection[0]);
				vj = Arrays.binarySearch(vertices, connection[1]);
				
				//use vertex array indices to set edge between friends
				adjMatrix[vi][vj] = 1;
				adjMatrix[vj][vi] = 1;
			}
			int nodes = adjMatrix[0].length;
			int[] visited = new int[nodes];
			int[] done = new int[nodes];
			int[] parents = new int[nodes];
			int you = Arrays.binarySearch(vertices, "You");
			
			//compute YOUR coolness
			DFS(adjMatrix, you, visited, done, parents);
			
			yourCoolness = computeCoolness(visited, adjMatrix, you);
						
//			System.out.println(yourCoolness);
			
			r = Integer.parseInt(br.readLine());
			
			for ( int j = 0; j < r; j++) {
				//compare rival coolness
				
				//clear arrays
				Arrays.fill(visited, 0);
				Arrays.fill(done, 0);
				Arrays.fill(parents, 0);
				
				rival = br.readLine();
				int rivalIndex = Arrays.binarySearch(vertices, rival);
				
				if(rivalIndex < 0) {
					//rival is NOT part of network so do nothing
				}
				else {
					//rival IS part of network
					DFS(adjMatrix, rivalIndex, visited, done, parents);
					rivalCoolness = computeCoolness(visited, adjMatrix, rivalIndex);
//					System.out.println(rivalCoolness);
				}
				
				//compute coolness
				int p = yourCoolness - rivalCoolness;
				System.out.println("   " + rival + ": Difference of " + p + " point(s).");
			}
			System.out.println();
		}
		
	}
	

	private static int computeCoolness(int[] visited, int[][] adjMatrix, int vertex) {
		int result = immediateFriends(adjMatrix, vertex);
		
		for( int k = 0; k < visited.length; k++) {
			if( visited[k] == 1){
				result++;
			}
		}
		
		result--; //subtract one from count to remove counting yourself.
		
		return result;
	}


	private static int immediateFriends(int[][] adjMatrix, int vertex) {
		int result = 0;
		
		for( int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[vertex][i] == 1){
				result++;
			}
		}
		return result;
	}

	private static void DFS(int[][] adjMatrix, int vertex, int[] visited,int[] done, int[] parents) {
		
		visited[vertex] = 1; //visit the current vertex
		
		for ( int i = 0; i < adjMatrix.length; i++) {
			if(adjMatrix[vertex][i] == 1){ //for each (v,u) in E, i.e for each edge this vertex has
				if( done[i] == 1) { //in this case, vertex[i], which has an edge with vertex[v], is a descendent of v and has already been searched
					//do nothing
				}
				else if(visited[i]==1) { // vertex[i] has already been visited, which means u is an ancestor of v in the tree. u might be the parent of v, if not, cycle detected
					//already visited, do nothing
				}
				else {
					//vertex[i] has not been visited before, so visit it and iniate a DFS on it
					parents[i] = vertex;
					DFS(adjMatrix,i,visited,done,parents);
				}
			}
		}
		done[vertex] = 1; //mark this DFS-tree as searched
	}

}
