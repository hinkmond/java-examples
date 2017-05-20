import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class JavaAdvDataStreams01 {

  public static void main(String[] args) {

    final List<String> femaleNamesList = Arrays.asList(
        "Amy", "Debbie", "Jane", "Justine"
    );

    String[] myArray = new String[] {
        "FRED", "debbie", "AMY", "JanE", "Theodore",
        "Leonard", "Ralph", "JustiNE", "Samuel",
        "George", "Albert"
    };

    // Create a sample Data Stream a String array
    Stream<String> mapStream = Arrays.stream(myArray);

    // Example of map, filter, then reduce
    String newString = mapStream
        .map(s -> {String lowerCaseStr = s.toLowerCase();
        return Character.toUpperCase(lowerCaseStr.charAt(0)) +
            lowerCaseStr.substring(1);})
        .filter(femaleNamesList::contains)
        .reduce("Search results:", (accumulator, mapValue) -> {
          if (accumulator.endsWith(":")) {
            return accumulator + " " + mapValue;
          } else {
            return accumulator + ", " + mapValue;
          }
        });

    // List all newly mapped elements
    System.out.println(newString);

    // Show result of convenient map count()
    System.out.println("Number of female names found = " +
        newString.split(", ").length);

  }
}
