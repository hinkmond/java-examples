import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JavaAdvDataStreams01 {
  public static void main(String[] args) {
    String[] myArray = new String[] {
        "Fred", "Debbie", "Theodore", "Lenny", "Justine"
    };

    // Create some sample Streams all from the same array
    Stream<String> mapStream = Arrays.stream(myArray);

    // Example of multiple maps
    String newString = mapStream
            .map(s -> s.replace("e", "3"))
            .map(s -> s.replace("o", "0"))
            .map(s -> s.replace("i", "1"))
            .collect(Collectors.joining(", "));

    // List all newly mapped elements
    System.out.println(newString);

    // Show result of convenient map count()
    System.out.println("Number of Elements Using count() = ");
  }
}
