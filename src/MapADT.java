// --== CS400 Project One File Header ==--
// Name: Rahil Kapur
// Email: rkapur3@wisc.edu
// Team: Red
// Group: AE
// TA: Ilay Raz
// Lecturer: Gary Dahl
// Notes to Grader:
import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {

  public boolean put(KeyType key, ValueType value);

  public ValueType get(KeyType key) throws NoSuchElementException;

  public int size();

  public boolean containsKey(KeyType key);

  public ValueType remove(KeyType key);

  public void clear();

}
