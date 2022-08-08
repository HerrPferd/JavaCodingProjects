import java.util.*;

public class Node {
  
 private final String name;
 private Node next;
   
 public Node(String name) { this.name = name; }
  
 @Override public String toString() { return name; }
 public String name() { return name; }
  
 public void link(Node next) { this.next = next; }
 public void unlink() { this.next = null; }
 public Node next() { return next; }
  
 public Node node(int n) {
   try{
     if(n == 0) return this;
     return this.next.node(n - 1);
   }
   catch(Exception e){return null;}
 }
  
 public boolean hasLoop() {
   Set<Node> nodes = new HashSet<Node>();
   int x = 0;
   while(nodes.add(this.node(x))) {
    if(this.node(x) == null) return false;
    x++;
   }
   return true;
 }
}
