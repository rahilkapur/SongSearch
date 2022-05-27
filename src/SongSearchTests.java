import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class SongSearchTests {

  /*
   * This test is created by Rahil Kapur and tests the containsSong method in the SearchBackEnd
   * class.
   * 
   * @returns true if containsSong works correctly. Otherwie returns false.
   */
  public static boolean BackEndDevelopertestfindNumberOfSongsInYear(String directory) throws FileNotFoundException {
    SearchBackEnd backEnd = new SearchBackEnd(directory);
    int result = backEnd.findNumberOfSongsInYear("Kills", 2019); // This should store the number of
                                                                 // songs with kills as a title word
                                                                 // and a year of 2019, which should
                                                                 // be one.
    int actual = 1;
    if (result != actual) { // If the result is not one we return false since this method does not
                            // do the expected thing.
      return false;
    }
    result = backEnd.findNumberOfSongsInYear("LALALA", 2017); // Here we make sure we don't get any
                                                              // weird errors where we increase when
                                                              // the key does not exist, so this
                                                              // result should be zero.
    actual = 0;
    if (result != actual) { // If it is not zero, then it is not working correctly so we return
                            // false.
      return false;
    }
    result = backEnd.findNumberOfSongsInYear("You", 2010); // Now we make sure we increase where we
                                                           // have a title word that is very common
                                                           // so we increase for every song
                                                           // correctly.
    actual = 6;
    if (result != actual) {
      return false;
    }
    return true;
  }

  /*
   * This test is written by Rahil Kapur and tests the BackEnd contains song method. It makes sure
   * that the containsSong method has the expected results.
   * 
   * @returns true if containsSong works correctly, otherwise false.
   */
  public static boolean BackEndDevelopertestContainsSong(String directory) throws FileNotFoundException {
    SearchBackEnd backEnd = new SearchBackEnd(directory);
    SongData song = new SongData("Hard", "Rihanna", 2010); // here we create a song that is already
                                                           // in the hashmap, so this should return
                                                           // true if we see if the hashmap contains
                                                           // it.
    boolean result = backEnd.containsSong(song);
    boolean actual = true;
    if (result != actual) { // If it is not true, then it is not working correctly so we return
                            // false.
      return false;
    }
    song = new SongData("Gummy Bear", "IDK", 2011); // Here we create a song that is not in the
                                                    // hashmap, so this should return false if we
                                                    // try to see if it is in the hashmap.
    result = backEnd.containsSong(song);
    actual = false;
    if (result != actual) { // If it is not false, then it is not working correctly so we return
                            // false.
      return false;
    }

    return true;
  }

  /*
   * This test is written by Rahil Kapur and tests the BackEnd findTitles method. It tests it by
   * making sure the findTitles method returns the correct result with multiple cases. i.e. where it
   * would return a list with one element, or two elments, or zero elements. This method ensures it
   * returns the correct arraylist.
   * 
   * @returns true if findTitles works correctly. Otherwise false.
   */
  public static boolean BackEndDevelopertestfindTitles(String directory) throws FileNotFoundException {
    SearchBackEnd backEnd = new SearchBackEnd(directory);
    ArrayList<String> result = (ArrayList<String>) backEnd.findTitles("Taki"); // This arraylist
                                                                               // should only have
                                                                               // one string since
                                                                               // only one song has
                                                                               // the title word
                                                                               // Taki.
    ArrayList<String> actual = new ArrayList<String>();
    actual.add("Taki Taki (feat. Selena Gomez, Ozuna & Cardi B)");
    if (!(result.get(0).equals(actual.get(0)))) { // This if statement checks the two arraylist
                                                  // elements at index zero and ensures that the
                                                  // song title matches with each other. Otherwise
                                                  // we return false.
      return false;
    }
    actual.remove(0);
    result = (ArrayList<String>) backEnd.findTitles("Feeling"); // This arraylist should have two
                                                                // strings or elements in it since
                                                                // there are two songs with Feeling
                                                                // in their title.
    actual.add("The Feeling");
    actual.add("Cut To The Feeling");
    if (result.size() != actual.size()) { // If the two arraylist's sizes do not match, that means
                                          // they do not contain the same titles, and we return
                                          // false.
      return false;
    }
    if (!(result.get(0).equals(actual.get(0)))) { // This if statement checks the two arraylist
                                                  // elements at index zero and ensures that the
                                                  // song
                                                  // title matches with each other. Otherwise we
                                                  // return false.
      return false;
    }
    if (!(result.get(1).equals(actual.get(1)))) { // This if statement checks the two arraylist
                                                  // elements at index one and ensures that the
                                                  // songtitle matches with each other. Otherwise
                                                  // we return false.
      System.out.println(result.get(1));
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    try {
      Scanner in = new Scanner(System.in);
      String inputDirectory = in.nextLine();
      System.out.println(BackEndDevelopertestfindNumberOfSongsInYear(inputDirectory));
      System.out.println(BackEndDevelopertestContainsSong(inputDirectory));
      System.out.println(BackEndDevelopertestfindTitles(inputDirectory));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
