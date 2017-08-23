import java.util.*;
import java.util.stream.Collectors;


public class JavaAdvDataStreams03 {

  public static void main(String[] args) {

    final List<String> femaleNamesList = new ArrayList<>(Arrays.asList(
        "Amy", "Ann", "Becky", "Debbie", "Jane", "Justine"
    ));

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
    HashMap<Integer, List<String>> namesMap = new HashMap<>();
    namesMap.put(1, new ArrayList<>(Arrays.asList(myArray01)));
    namesMap.put(2, new ArrayList<>(Arrays.asList(myArray02)));
    namesMap.put(3, new ArrayList<>(Arrays.asList(myArray03)));

    // Example of map, filter, then collect
    List<String> foundNamesList = namesMap.values().stream()
        .flatMap(mapValuesStream -> mapValuesStream.stream().map(strElem -> {
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
