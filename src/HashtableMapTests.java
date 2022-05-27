// --== CS400 Project One File Header ==--
// Name: Rahil Kapur
// Email: rkapur3@wisc.edu
// Team: Red
// Group: AE
// TA: Ilay Raz
// Lecturer: Gary Dahl
// Notes to Grader:

import java.util.NoSuchElementException;

/*
 * This class essentially tests all the methods inside the HashtableMap class. This is done by
 * creating multiple scenarios and make sure each method retruns its expected value. Additionally if
 * any method throws and exception, we make sure that the exception is thrown correctly and
 * appropriately.
 */
public class HashtableMapTests {



  /*
   * This test method simply makes sure the clear method works correctly by putting in a random
   * value of pairs inside the hashtable and after calling clear, making sure that the size of the
   * hashtable is zero, effectively removing all the elements inside the hashtable. If the size is
   * not zero, clear did not work correctly and needs to be looked at again.
   * 
   * @return true if clear works correctly. Otherwise false.
   */
  public static boolean test1() {
    HashtableMap map = new HashtableMap();
    int tempKey = 4; // Here we create a key and value, putting them in the hashtable, and making
                     // sure that clear actually removes them after putting them into the map.
    int tempValue = 2;
    map.put(tempKey, tempValue);
    map.clear();
    int correctSize = 0;
    if (map.size() != correctSize) {
      return false;
    }
    tempKey = 10; // Here, we put four new pairs inside the hashtable and call clear to make sure
                  // BOTH pairs are removed from the hashtable, to make sure clear works on maps
                  // with multiple values.
    tempValue = 9;
    map.put(tempKey, tempValue);
    tempKey = 18;
    tempValue = 99;
    map.put(tempKey, tempValue);
    tempKey = 34;
    tempValue = 13;
    map.put(tempKey, tempValue);
    tempKey = 68;
    tempValue = 23;
    map.put(tempKey, tempValue);
    map.clear();
    if (map.size() != correctSize) {
      return false;
    }
    return true;
  }

  /*
   * This test method makes sure that the put method from the HashtableMap class works correctly. We
   * make sure it runs correctly by creating a new hashmap and adding in various key-value pairs,
   * and if the put method returns false when we try to put a pair in, then put does not work
   * correctly and we return false. Otherwise it returns true. We also makes sure it works by making
   * sure size is incremeneted and when we call get with that specific key, we can access the value
   * it is associated with. We put in two pairs to make sure put puts them in correctly, and we try
   * adding a key that is already in the hashmap, and makes sure put works correctly by returning
   * false when we try to do this. We also try to add in a null value and also make sure that put
   * returns false in that case as well.
   * 
   * @return true if the put method works as intended, without any buggy behavior. False otherwise.
   */
  public static boolean test2() {
    HashtableMap map = new HashtableMap();
    int tempKey = 23; // Here we just create new keyValues and ValueTypes
    int tempValue = 44;
    if (map.put(tempKey, tempValue) != true) { // This if statement makes sure that put succesfully
                                               // adds the pair to the map.
      return false;
    }
    int correctSize = 1;
    if (map.size() != correctSize) { // We also make sure that size is incremented correctly. After
                                     // putting in a value.
      return false;
    }
    int value = (int) map.get(tempKey);
    if (tempValue != value) { // we also make sure that get returns the correct value after putting
                              // in the pair.
      return false;
    }
    tempKey = 44;
    tempValue = 56;
    if (map.put(tempKey, tempValue) != true) { // Here we repeat the same process, adding in another
                                               // pair and making sure put returns true, size is
                                               // incremented, and we can get the value that is
                                               // associated with the key.
      return false;
    }
    correctSize = 2;
    if (map.size() != correctSize) {
      return false;
    }
    value = (int) map.get(tempKey);
    if (tempValue != value) {
      return false;
    }
    int sameKey = 44;
    tempValue = 3;
    if (map.put(sameKey, tempValue) == true) { // Here we try adding a key that we already have in
                                               // the hashmap, and make sure put returns false, to
                                               // ensure that this key is not added again, since we
                                               // aren't supposed to allow that in the put method.
      return false;
    }
    Integer blankKey = null;
    tempValue = 5;
    if (map.put(blankKey, tempValue) == true) { // Here we try adding in a key that is null, and put
                                                // is supposed to not let this happen and return
                                                // false in this kind of case, so here we make sure
                                                // that put returns false when we try adding in a
                                                // null value as a key.
      return false;
    }

    return true; // If this point is reached, that means the method works, passing all the tests
                 // I've passed into it.
  }

  /*
   * This test method makes sure the remove method works correctly. It puts a pair in and makes sure
   * that after removing, the value returned is the matching value with the key. It also makes sure
   * that after putting in a key with three digits, calling remove works and returns the correct
   * associated value. We also make sure that calling remove with a key that is not in the hashmap
   * returns null, otherwise we return false.
   * 
   * @return True if the remove method works corrrectly without any buggy behavior. False otherwise.
   */
  public static boolean test3() {
    HashtableMap map = new HashtableMap();

    int tempKey = 23; // Here we just create new keyValues and ValueTypes
    int tempValue = 44;
    map.put(tempKey, tempValue);
    int value = (int) map.remove(tempKey);
    if (tempValue != value) {
      return false;
    }

    int tempKey2 = 128; // Here we add a three digit key, making sure remove works with bigger keys.
    tempValue = 10;

    map.put(tempKey2, tempValue);

    value = (int) map.remove(tempKey2);

    if (tempValue != value) { // We make sure that the value returned matches with the value that is
                              // paired with the key. Otherwise we return false.
      return false;
    }

    int fakeKey = 999; // here we test remove makign sure it returns null when looking for a key
                       // that does not exist within the hashmap.
    Integer noValue = (Integer) map.remove(fakeKey);
    if (noValue != null) { // If the returned vaue is Not null, we return false.
      return false;
    }

    return true; // If this point is reached, then we have passed all the tests for remove.
  }


  /*
   * This method simply tests the get method. It does this by first putting keys in the hashtablemap
   * and calling get to make sure the value that is being returned is correct(matches with the key
   * it should match to). If not, then the get method is written wrong. It also tests that the
   * NoSuchElementException is being thrown correctly in the get method by trying to access a key
   * that does not exist within the method. In the case where the key does not exist, we throw the
   * exception which is what this method is testing for, if this is not thrown, then we return
   * false.
   * 
   * @return true if the get method works correctly without any buggy implemenation. False
   * otherwise.
   */
  public static boolean test4() {
    HashtableMap map = new HashtableMap();
    int tempKey = 4; // Here we create a key and value, putting them in the hashtable, and making
                     // sure that get returns the correct value.
    int tempValue = 2;
    map.put(tempKey, tempValue);
    int value = (int) map.get(tempKey);
    if (value != tempValue) { // If the return of get does not match with the value specified, we
                              // return false.
      return false;
    }
    tempKey = 12; // Here we have three keys, and three values, and put all them in the hashtable
                  // and make sure that get returns the value that is associated with the key given
                  // as the argument.
    int secondTempKey = 13;
    int thirdTempKey = 23;
    tempValue = 60;


    int secondTempValue = 55;
    int thirdTempValue = 99;


    map.put(tempKey, tempValue);
    map.put(secondTempKey, secondTempValue);
    map.put(thirdTempKey, thirdTempValue);


    value = (int) map.get(secondTempKey);

    if (value != secondTempValue) { // If the returned valeu does not match, we return false.
      return false;
    }
    value = (int) map.get(thirdTempKey);

    if (value != thirdTempValue) {
      return false;
    }
    try { // Here we test get where it would throw a NoSuchElementException, by using a key that
          // does not exist as an argument.
      int fakeKey = 20;
      map.get(20);
      return false; // If this point is reached, that means the exception has not been thrown and
                    // the code has been written wrong for the exception throwing.

    } catch (NoSuchElementException e) { // If this point is reached, then the code has thrown an
                                         // exception and it is appropriately caught.
      System.out.println(e.getLocalizedMessage());
    }


    return true; // If this point is reached, then get has passed all its testing.
  }

  /*
   * This method simply tests the size method from the HashtableMap class. It makes sure that the
   * size returns 0 when the map is empty, and everytime we put a new pair in, the size increases
   * accordingly. Otherwise, it is implemented wrong and we have to fix it.
   * 
   * @return true if the size method works correctly. False otherwise.
   */
  public static boolean test5() {
    HashtableMap map = new HashtableMap();
    if (map.size() != 0) { // Here we make sure an empty HashtableMap's size is correct.
      return false;
    }
    int tempKey = 4; // Here we create a key and value, putting them in the hashtable, and making
                     // sure that get returns the correct value.
    int tempValue = 2;
    map.put(tempKey, tempValue);
    int currentSize = map.size();
    int correctSize = 1;
    if (currentSize != correctSize) {
      return false;
    }
    tempKey = 99; // Here we simply add another value to make sure that the size is correct.
    tempValue = 81;
    map.put(tempKey, tempValue);
    currentSize = map.size();
    correctSize = 2;
    if (currentSize != correctSize) {
      return false;
    }
    tempKey = 119; // Here we again add another valeu to make sure size is working for multiple
                   // values.
    tempValue = 8;
    map.put(tempKey, tempValue);
    currentSize = map.size();
    correctSize = 3;
    if (currentSize != correctSize) {
      return false;
    }
    return true;
  }



  public static void main(String[] args) {
    boolean clearResult = test1();
    System.out.println(clearResult);
    boolean putResult = test2();
    System.out.println(putResult);
    boolean removeResult = test3();
    System.out.println(removeResult);
    boolean getResult = test4();
    System.out.println(getResult);
    boolean sizeResult = test5();
    System.out.println(sizeResult);

  }
}
