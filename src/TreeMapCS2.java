import java.util.*;

//When you are writing the code for getKeys() to return an ArrayList of ordered keys, consult the class
//notes on tree traversal
//to remember how to traverse the tree in the correct order to return an ordered list. (Hint: it's in-order!)

public class TreeMapCS2<Key extends Comparable<Key>, Value> {

  // _________________________________________
  // Note: Once you have implemented all the
  // interface methods, be sure to add
  //      implements MapCS2<Key, Value>
  // in the class declaration above between
  // the final > and the {
  // _________________________________________


  // -----------------------------------------
  // Member variables:
  // ------------------------------------------
  // Create pointer to top Node and a size int variable

  Node top;
  int size;

  // -----------------------------------------------
  // Node inner class
  // -----------------------------------------------
  // Create an inner class called Node which has the
  // following instance variable:
  // Key k, Value v, Node rightchild, Node leftchild
  // Also create one or more constructors for the Node class.
  // Remember that your binary search tree will be organized
  // according to the Key only (not the value).

  public class Node {
    Key k;
    Value v;
    Node rightchild;
    Node leftchild;

    public Node(Key k, Value v) {
      this.k = k;
      this.v = v;
    }
  }

  // -----------------------------------------------
  // Constructor(s)
  // -----------------------------------------------
  // Write a constructor for TreeMapCS2, if you wish.

  //Establishes a Tree Map with the top node as null and size as 0
  public TreeMapCS2() {
    this.top = null;
    this.size = 0;
  }

  // -----------------------------------------------
  // Interface methods to implement
  // -----------------------------------------------
  /*
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  ArrayList<Key> getKeys();     // returns the *SORTED* keys as an ArrayList
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string with each key : value pair
  */


  Value get(Key key) {
    //If there's nothing in the map, return null
    if (this.size == 0) {
      return null;
    }
    //Otherwise, traverse through the tree map recursively and if traverse matches the key,
    //return the value. IF traverse is less than the key, move traverse to its right child.
    //Otherwise, move traverse to its left child. If traverse becomes null, then no match was found.
    Node traverse = top;
      while (traverse != null) {
        if (key.compareTo(traverse.k) == 0) {
          return traverse.v;
        } if (traverse.k.compareTo(key) < 0)
            traverse = traverse.rightchild;
          else {
            traverse = traverse.leftchild;
          }
      }
      System.out.println("No match found");
      return null;
    }


  void put(Key key, Value val) {
    //Creates a new node to insert
    Node insert = new Node(key, val);

    //If the tree map is empty, simply make insert the top node
   if (this.size == 0) {
      top = insert;
      size++;
      return;
    }
    //If the tree map isn't empty, compare insert to Node n which points to the top node
    Node n = top;
      while (n != null) {
        //If n's key is greater than insert's key and n's left child is null, make insert n's leftchild and increase size.
        //If n's leftchild isn't null, make n n's leftchild and keep comparing until you reach a null so that insert can be placed into the tree map.
        if (insert.k.compareTo(n.k) < 0) {
          if (n.leftchild == null) {
            n.leftchild = insert;
            size++;
          } else {
              n = n.leftchild;
          }
        }
        //Otherwise if n's key is less than insert's key and n's right child is null, make insert n's rightchild and increase size.
        //IF n's rightchild isn't null, make n n's rightchild and keep comparing until you reach a null so that insert can be placed into the tree map.
        else if (insert.k.compareTo(n.k) > 0) {
          if (n.rightchild == null) {
            n.rightchild = insert;
            size++;
          } else {
              n = n.rightchild;
            }
        }
        //If the insert's key is the same as n's key, just set them equal.
        else {
          n.v = insert.v;
          return;
        }
      }
  }

  //Traverses the tree in-order
  void inOrder(Node n, ArrayList<Key> keys) {
    if (n == null) {
      return;
    } else {
        inOrder(n.leftchild, keys);
        keys.add(n.k);
        inOrder(n.rightchild, keys);
      }
  }

  //Creates an arraylist and adds all the keys into it with the in-order function
  //so the keys are added in-order
  ArrayList<Key> getKeys() {
    ArrayList<Key> keys = new ArrayList<Key>();
    if (size == 0) {
      return null;
    } else {
        inOrder(top, keys);
      }
      return keys;
  }

  //traverses the tree to find the left-most node which is the min
  Key min() {
    Node traverse = top;
    while (traverse.leftchild != null) {
      traverse = traverse.leftchild;
      }
    return traverse.k;
  }

  //traverses the tree to find the right-most node which is the max
  Key max() {
    Node traverse = top;
    while (traverse.rightchild != null) {
      traverse = traverse.rightchild;
      }
    return traverse.k;
  }

  //return true if the key is in the map and false if it isn't
  boolean contains(Key key) {
    if (get(key) == null) {
      return false;
    } else {
        return true;
    }
  }

  //return true if size of tree map is 0
  boolean isEmpty() {
    return (size == 0);
  }

  //returns the size of the tree map
  int size() {
    return size;
  }

  //Goes through the arraylist and prints out each key:value pair
  public String toString() {
    String toreturn = "";
    for (Key k : this.getKeys()) {
      if (k != this.max()) {
        toreturn += k + " : " + get(k) + ", ";
      } else {
          toreturn += k + " : " + get(k);
        }
    }
    return toreturn;
  }


  // -----------------------------------------------
  // Main method to test your code
  // -----------------------------------------------
  public static void main (String[] args) {
    TreeMapCS2<String, String> myMap=new TreeMapCS2<String, String>();
    System.out.println (myMap.isEmpty());
    myMap.put ("dog", "animal");
    myMap.put ("tree", "plant");
    myMap.put("apple", "fungi");
    myMap.put ("human", "animal");
    System.out.println (myMap.getKeys());
    System.out.println (myMap.min());
    System.out.println (myMap.max());
    System.out.println (myMap.toString());
    System.out.println (myMap.get("apple"));
    System.out.println (myMap.contains("apple"));
    System.out.println (myMap.size());

  }

}
