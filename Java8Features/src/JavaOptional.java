import java.util.Optional;


public class JavaOptional {

  public static void optional_map_substring_test() {
    Optional<String> number = Optional.of("longword");
    Optional<String> noNumber = Optional.empty();

    Optional<String> smallerWord = number.map(s -> s.substring(0,4));
    Optional<String> nothing = noNumber.map(s -> s.substring(0,4));

    if (smallerWord.get().equals("long")) {
      System.out.println("Optional.of() has the correct string.");
    }
    if (nothing.isPresent() == false) {
      System.out.println("Optional.empty() is empty.");
    } else {
      System.out.println("nothing.get() = " + nothing.get());
    }
  }

  public static void main(String args[]) {
    optional_map_substring_test();
  }

}
