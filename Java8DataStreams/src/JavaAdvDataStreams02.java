import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JavaAdvDataStreams02 {

  public static void main(String[] args) {

    final List<String> femaleNamesList = Arrays.asList(
        "Amy", "Ann", "Becky", "Debbie", "Jane", "Justine"
    );

    String[] myArray = new String[] {
        "FREd", "debbIe", "AMY", "JanE", "Theodore",
        "Leonard", "Ralph", "JustiNE", "Samuel",
        "George", "Albert", "Ann", "Becky"
    };

    // Create a sample Data Stream a String array
    Stream<String> mapStream = Arrays.stream(myArray);

    // Example of map, filter, then reduce
    List<String> foundNamesList = mapStream
        .map(s -> {String lowerCaseStr = s.toLowerCase();
          return Character.toUpperCase(lowerCaseStr.charAt(0)) +
              lowerCaseStr.substring(1);})
        .filter(femaleNamesList::contains)
        .collect(Collectors.toList());

    // List all newly mapped elements
    foundNamesList.forEach(System.out::println);

    // Show result of convenient map count()
    System.out.println("Number of female names found = " +
        foundNamesList.size());

  }
}
