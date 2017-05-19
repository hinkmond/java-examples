import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JavaAdvDataStreams01 {
  public static void main(String[] args) {
    String[] myArray = new String[] {
        "Fred", "Debbie", "Amy", "Jane", "Theodore", "Leonard", "Ralph", "Justine"
    };

    // Create some sample Streams all from the same array
    Stream<String> mapStream = Arrays.stream(myArray);

    // Example of multiple maps
    String newString = mapStream
            .filter(s -> s.contains("Amy"))
            .reduce("", (a, s) -> a + s + ", ");

    // List all newly mapped elements
    System.out.println(newString);

    // Show result of convenient map count()
    System.out.println("Number of Elements Using count() = ");
  }
}
