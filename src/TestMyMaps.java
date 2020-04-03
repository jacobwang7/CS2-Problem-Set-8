public class TestMyMaps {
  public static void main (String[] args) {

    // Select one of the lines below depending on whether you
    // chose to implement the hash map or the tree map.

    HashMapCS2<Integer, String> mymap = new HashMapCS2<Integer, String>();

    // MapCS2<Integer, String> mymap = new TreeMapCS2<Integer, String>();

    mymap.put(5, "dog");
    mymap.put(22, "lion");
    mymap.put(36, "cat");
    mymap.put(73, "elephant");
    mymap.put(89, "manatee");
    mymap.put(177, "donkey");
    mymap.put(215, "cheetah");
    mymap.put(315, "panda");
    mymap.put(470, "aligator");
    mymap.put(496, "koala");
    mymap.put(315, "narwhal");
    mymap.put(177, "unicorn");

    // Testing min() and max()
    // This wil be faster with a tree map of course!
    System.out.println("Minimum: " + mymap.min());
    System.out.println("Maxmium: " + mymap.max());

    // Make sure you don't have any duplicates! :)
    System.out.println(mymap.toString());

    // This is just testing contains()
    Integer looky = 470;
    if (mymap.contains(looky)) {
      System.out.println("Key found: " + looky);
    } else {
      System.out.println("Key not found: " + looky);
    }

    // This is testing getKeys()
    for (Integer i : mymap.getKeys()) {
      if (i % 2 == 0) {
        System.out.println("This key is even: " + i);
      } else {
        System.out.println("This key is odd: " + i);
      }
    }

  }
}
