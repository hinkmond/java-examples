import java.util.Arrays;
import java.util.stream.Stream;

public class JavaDataStream {

  public static void main(String[] args) {
    String[] myArray = new String[] {
        "Fred", "Debbie", "Theodore", "Lenny", "Justine"
    };

    // Create some sample Streams all from the same array
    Stream<String> mapStream = Arrays.stream(myArray);
    Stream<String> mapReduceStream = Arrays.stream(myArray);
    Stream<String> countStream = Arrays.stream(myArray);

    // Example of multiple maps
    Stream<String> mapNewStream = mapStream.map(s -> s.replace("e", "3")).
        map(s -> s.replace("o", "0")).map(s -> s.replace("i", "1"));

    // Example of map and reduce
    int numElements = mapReduceStream.map(x -> 1).
        reduce(0, (x, y) -> x + 1);

    // Example of counting map elements
    long count = countStream.count();

    // List all newly mapped elements
    mapNewStream.forEach(System.out::println);

    // Show result of MapReduce
    System.out.println("Number of Elements Using MapReduce = " +
        numElements);

    // Show result of convenient map count()
    System.out.println("Number of Elements Using count() = " + count);
  }
}
