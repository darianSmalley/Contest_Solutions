import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Kruskal {
 /**
  * all edges
  */
 ArrayList<Edge> edges= new ArrayList<Edge>();
 
 ArrayList<ItemNode> nodes= new ArrayList<ItemNode>();
 ArrayList<HashSet<ItemNode>> subsets = new ArrayList<HashSet<ItemNode>>();
 
 public static void main(String args[]){
  Kruskal kruskal= new Kruskal();
  kruskal.init();
  

 }
 
 public void init(){
  // setting nodes;
  nodes.add(new ItemNode(0));
  nodes.add(new ItemNode(1));
  nodes.add(new ItemNode(2));
  nodes.add(new ItemNode(3));
  nodes.add(new ItemNode(4));
  nodes.add(new ItemNode(5));
  nodes.add(new ItemNode(6));
  nodes.add(new ItemNode(7));
  nodes.add(new ItemNode(8));
  
  // setting edges;
  edges.add(new Edge(0,1,4));
  edges.add(new Edge(0,7,8));
  edges.add(new Edge(1,2,8));
  edges.add(new Edge(1,7,11));
  edges.add(new Edge(2,8,2));
  edges.add(new Edge(2,3,7));
  edges.add(new Edge(2,5,4));
  edges.add(new Edge(3,4,9));
  edges.add(new Edge(3,5,14));
  edges.add(new Edge(4,5,10));
  edges.add(new Edge(5,6,2));
  edges.add(new Edge(6,7,1));
  edges.add(new Edge(6,8,6));
  edges.add(new Edge(7,8,7));
  
  // make nodes to subsets
  for(int i=0; i<nodes.size(); i++){
   HashSet<ItemNode> set = new HashSet<ItemNode>();
   set.add(nodes.get(i));
   subsets.add(set);
  }
  
  // sort
  Collections.sort(edges, new CustomComparator());
  
  System.out.println(edges);
  
  
  // union and find algorithm
  for(int i=0; i<edges.size(); i++){
   Edge edg = edges.get(i);
   ItemNode srcNode = nodes.get(edg.src);
   ItemNode destNode = nodes.get(edg.dest);
   
   if(find(srcNode) == find(destNode)){
    // same subsets
   }else{
    System.out.println( edg.src + " > " + edg.dest);
    union(find(srcNode), find(destNode));
   }
  }
 }
 
 public void union(int aSubset, int bSubset){
  HashSet<ItemNode> aSet = subsets.get(aSubset);
  HashSet<ItemNode> bSet = subsets.get(bSubset);
  
  Iterator<ItemNode> iter = bSet.iterator();
  while(iter .hasNext()){
   ItemNode b = iter.next();
   aSet.add(b);
//   System.out.println(bSet.size());
//   System.out.println("bnumber : " + b.number);
  }
  subsets.remove(bSubset);
  printSet();
  
 }
 
 public void printSet(){
  
  for(int i=0;i<subsets.size(); i++){
   HashSet<ItemNode> hashSet= subsets.get(i);
   
   Iterator<ItemNode> iter= hashSet.iterator();
   System.out.print("{");
   while(iter.hasNext()){
    ItemNode node = iter.next();
    System.out.print(node.number + ",");
   }
   System.out.print("}");
   
  }
  System.out.println();
 }
 
 public void setvalue(int [][] graph, int start, int end, int val){
  graph[start][end] = val;
  graph[end][start] = val;
 }
 class ItemNode {
  boolean isRoot = true;
  int number = 0;
  LinkedList<ItemNode> subnodes= new LinkedList<ItemNode>();
  ItemNode parendNode = null;
  
  ItemNode(int number){
   this.number = number;
  }
 }
 
 
 public int  find(ItemNode node){
  int number=-1;
  
  for(int i=0; i<subsets.size(); i++){
   HashSet<ItemNode> set = subsets.get(i);
   Iterator<ItemNode> iterator = set.iterator();
   while(iterator.hasNext()){
    ItemNode setnode = iterator.next();
    if(setnode.number == node.number){
     number= i;
     return number;
    }
    
   }
  }
  return number;
 }
}
class CustomComparator implements Comparator<Edge>{

 @Override
 public int compare(Edge o1, Edge o2) {
  return o1.weight - o2.weight;
 }
}

class Edge{
 int src;
 int dest; 
 int weight;
 
 Edge(int src, int dest, int weight){
  this.src = src;
  this.dest = dest;
  this.weight = weight;
 }
 @Override
 public String toString() {
  return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight
    + "] \n";
 }
}