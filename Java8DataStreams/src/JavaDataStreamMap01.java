import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class JavaDataStreamMap01 {

  public static void main(String[] args) {

    final List<String> jobPositionList = Arrays.asList(
            "Engineer", "Sysadmin", "Programmer"
    );

    Map<Integer, List<String>> memberWorkHistoryMap = new HashMap<>();
    memberWorkHistoryMap.put(1, Arrays.asList("Clerk", "Cashier", "Salesperson"));
    memberWorkHistoryMap.put(2, Arrays.asList("Stocker", "Salesperson"));
    memberWorkHistoryMap.put(3, Arrays.asList("Engineer", "Manager"));

    // Create a sample Data Stream a String array
    Stream<String> mapStream = memberWorkHistoryMap.get(1).stream();

    // Example of map, filter, then reduce
    String newString = mapStream
        .map(s -> {
          String lowerCaseStr = s.toLowerCase();
          return Character.toUpperCase(lowerCaseStr.charAt(0)) +
            lowerCaseStr.substring(1);
        })
        .filter(s -> jobPositionList.contains(s))
        .reduce("Results:", (accumulator, mapValue) -> {
          if (accumulator.endsWith(":")) {
            return accumulator + " " + mapValue;
          } else {
            return accumulator + ", " + mapValue;
          }
        });

    memberWorkHistoryMap.forEach((key, list) -> {
      System.out.print("key = " + key + ": ");
      for (String listString : list) {
        System.out.println("item: " + listString);
      }
      Stream listStream = Stream.of(list);
      listStream.map(value -> {
        System.out.println("item from for-loops: " + value);
        return value;
      });
      return;
    });

    for (List mapList : memberWorkHistoryMap.values()) {
      mapList.forEach(string -> System.out.println("item from for/forEach: " + string));
    }

    // List all newly mapped elements
    System.out.println(newString);

    // Show result of convenient map count()
    System.out.println("Number of qualified applicants found = " +
        newString.split(", ").length);

  }
}
