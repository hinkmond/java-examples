import java.util.Optional;


public class JavaOptional {

  public static void optional_map_substring_test() {
    Optional<String> number = Optional.of("longword");
    Optional<String> noNumber = Optional.empty();
    noNumber = Optional.of("test");

    Optional<String> smallerWord = number.map(s -> s.substring(0,4));
    Optional<String> nothing = noNumber.map(s -> s.substring(0,4));

    if (smallerWord.get().equals("long")) {
      System.out.println("Optional.of() has the correct string.");
    }

    System.out.println("Optional.orElse() = " + nothing.orElse("UNKNOWN"));
  }

  public static void main(String args[]) {
    optional_map_substring_test();
  }

}
