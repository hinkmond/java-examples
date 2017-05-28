import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JavaAdvDataStreams03 {

  public static void main(String[] args) {

    final List<String> femaleNamesList = Arrays.asList(
        "Amy", "Ann", "Becky", "Debbie", "Jane", "Justine"
    );

    String[] myArray01 = new String[] {
        "FREd", "debbIe", "AMY", "JanE"
    };
    String[] myArray02 = new String[] {
        "Theodore",  "Leonard", "Ralph", "JustiNE"
    };
    String[] myArray03 = new String[] {
        "Samuel", "George", "Albert", "ANn", "BeCKy"
    };

    // Create a sample Map with multiple Sets in each Entry
    HashSet<String[]> namesMap = new HashSet<>();
    namesMap.add(myArray01);
    namesMap.add(myArray02);
    namesMap.add(myArray03);

    // Example of map, filter, then collect
    List<String> foundNamesList = namesMap.stream()
        .flatMap(s -> Arrays.stream(s).map(strElem -> {
          String lowerCaseStr = strElem.toLowerCase();
          return Character.toUpperCase(lowerCaseStr.charAt(0)) +
              lowerCaseStr.substring(1);}))
        .filter(femaleNamesList::contains)
        .collect(Collectors.toList());

    // List all newly processed elements
    foundNamesList.forEach(System.out::println);

    // Show result of count
    System.out.println("Number of female names found = " +
        foundNamesList.size());

  }
}
