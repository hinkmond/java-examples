/**
 * Created by hinkmond on 6/11/2017.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/*
 * Examples of Java Data Streams flatMap
 *
 * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
 *
 * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
 */
public class JavaDataStreamMap02 {

  public static void main(String[] args) {

    final List<String> jobPositionList = Arrays.asList(
        "Engineer", "Sysadmin", "Programmer"
    );

    Set<List<String>> memberWorkHistorySet = new HashSet<>();
    memberWorkHistorySet.add(Arrays.asList("Clerk", "Cashier", "Salesperson"));
    memberWorkHistorySet.add(Arrays.asList("Stocker","Sysadmin"));
    memberWorkHistorySet.add(Arrays.asList("Engineer", "Manager"));

    // Create a sample Data Stream a String array
    List<String> setList = memberWorkHistorySet.iterator().next();

    // Example of map, filter, then reduce
    Optional<String> nestedMapString = memberWorkHistorySet.stream().map(l -> l.stream()
        .map(s -> {
          String lowerCaseStr = s.toLowerCase();
          return Character.toUpperCase(lowerCaseStr.charAt(0)) +
              lowerCaseStr.substring(1);
        })
        .filter(s -> jobPositionList.contains(s))
        .reduce("", (accumulator, mapValue) -> {
          if (accumulator.isEmpty()) {
            return accumulator + mapValue;
          } else {
            return accumulator + ", " + mapValue;
          }
        })).reduce((a, v) -> {
      if (a.isEmpty()) {
        return a + v;
      } else {
        return a + ", " + v;
      }
    });

    // List all newly mapped elements
    System.out.println(nestedMapString);

    // Example of map, filter, then reduce
    Optional<String> flatMapString = memberWorkHistorySet.stream().flatMap(list ->
        list.stream().map(s -> {
          String lowerCaseStr = s.toLowerCase();
          return Character.toUpperCase(lowerCaseStr.charAt(0)) +
              lowerCaseStr.substring(1);
        }).filter(s -> jobPositionList.contains(s))).reduce((a,s) ->{
      if (a.isEmpty()) {
        return a + s;
      } else {
        return a + ", " + s;
      }
    });


    // List all newly mapped elements
    System.out.println(flatMapString);


    // Show result of convenient map count()
    System.out.println("Number of qualified applicants found = " +
        flatMapString.orElse("Default"));

  }
}
