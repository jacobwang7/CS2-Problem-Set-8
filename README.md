# Problem Set 8: Maps with Hashes and Trees

### Due Friday, April 17th @ 11.59pm anywhere in the world

---

There are two parts to this problem set. Only one will be graded for your problem set 8 grade, so you can choose to do whichever part suits you.

If you would like to complete the other part, you can do so and have that grade replace an earlier grade that you were not happy with. This is entirely optional, of course!

Part 2 will probably be easier for most people, so you might want to start with that.

In this problem set, you will be implementing your own map map ADT interface, which you will find in the `src` directory:

``` java

public interface MapCS2<Key extends Comparable<Key>, Value> { 
  Value get(Key key);           // returns a Value for the specified key
  void put(Key key, Value val); // puts a Key-Value pair in the map
  ArrayList<Keys> getKeys();    // returns the keys of the map as an ArrayList
  Key min();                    // returns the minimum key in the map
  Key max();                    // returns the maximum key in the map
  boolean contains(Key key);    // returns true if the map contains the key
  boolean isEmpty();            // returns true if map is empty
  int size();                   // returns size of map
  String toString();            // returns a string that lists each key-value pair
}

```

**Helpful Hints**

* Keys are unique in a map! If the user calls `put()` with a key that has already been added to the map, replace the current value for that key with the new value.

* The `toString()` method should return a string with key-value pairs, where the key is separated from the value by a space-colon-space, and the pairs are separated by a comma-space, e.g., ``dog : animal, tree : vegetable, salt : mineral``. Make sure that your `toString()` method returns the correctly formatted `String`.

* I expect you to use the files I have provided. Do not create new `.java` files, do not create new directories, and keep all your `.java` files in the `src` directory. In addition, do not change the names of the methods. I will be testing your code using these specific methods.


### Part 1: Hash map with separate chaining: `HashMapCS2.java`
I have provided skeleton code for a hash-based implementation of the `MapCS2` interface in the `HashMapCS2.java` file. Your hash map implementation will include all of the above interface methods, as well as the following components:

* You will be storing your values in an `ArrayList` **of size 17** of `LinkedList` objects, each of which will contain elements of the `KeyValuePair` type. (I have defined the `KeyValuePair` class for you in the `HashMapCS2.java` file.) That is, you will have an `ArrayList`, and every element in the `ArrayList` will be a `LinkedList` of `KeyValuePair` objects. This will allow you to implement separate chaining for collision resolution. For more information on how separate chaining works, see the textbook and the lecture notes on maps.

* You must also finishing writing the hash function. To keep things manageable, you will generate hash codes only for  **these three data types:** `String`, `Integer`, and `Double`. The hash function will convert an instance of the `String`, `Integer`, or `Double` data type into an integer between 0 and 16.  I have provided some code for the `hashFunction()` method. Details are provided in the `HashMapCS2.java` file. Your code needs to handle keys of these three types only. Do not use a different hash function than the one described in the file.

*There are many implementations of the hash map data structure on the web. You must implement your hash map as I have described above using the skeleton code I have provided.*


### Part 2: Tree map with a binary search tree: `TreeMapCS2.java`
I have provided skeleton code for a binary search tree-based implementation of the `MapCS2` interface in the `TreeMapCS2.java` file. Your tree map implementation will include all of the interface methods, plus the following components:

* You will create your trees using an inner `Node` class, whose instance variables will include `Key k, Value v, Node rightchild`, and `Node leftchild`. You will define this inner class.

* Every `TreeMapCS2` object will have a pointer to the top `Node` and a size variable.

* You will use a binary search tree to store your key-value pairs. Therefore, your keys can be anything that implements `Comparable`. You don't need to write a `compareTo()` method. You can just assume that the user will only use keys that already implement `Comparable`.

* When you are writing the code for `getKeys()` to return an ArrayList of ordered keys, consult the class notes on tree traversal to remember how to traverse the tree in the correct order to return an ordered list. (Hint: it's in-order!)

*There are many implementations of the tree map data structure on the web. You must implement your tree map as I have described above using the skeleton code I have provided. Remember that I have provided [a ton of BST sample code here](  https://github.com/BC-CSCI-1102-S20-MWF12/example_code/tree/master/week8/BInarySearchTrees). You definitely can and should use the code, though you will have to change it to make it work with these different data types, of cours!*


### Testing your data structure

No matter which implementation you choose, you must write a `main()` method that will test the functionality you have created. In addition, you can try out the included `TestMyMap.java` class.

Once your code works to your satisfaction, push your changes, as you have done for your previous problem sets. Use the commit message "READY FOR GRADING" so we know you are done. 

---

## Important notes on grading

1. The files **must be in the `src` directory**. 

2. Your code must compile. 

3. One point in your grade will be for "style and formatting". This includes (1) comments; (2) indenting in a way that allows for easy reading; (3) naming variables in helpful or memorable ways; (4) remembering that methods and variables should start with lowercase letters, while class and interface names should begin with a capital letter; (5) making consistent formatting choices.

4. One point in your grade for this problem set will be for "efficiency". Do not write more code than you need. Do not create objects that do not need to be created. 



