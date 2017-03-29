public class JavaStringBuilder {

  public static void main(String args[]) {
    // StringBuilder: Builder Design Pattern
    StringBuilder sb = new StringBuilder();
    String result = sb.append("do this ")
        .append("do that ")
        .append("do the other thing.")
        .toString();
    System.out.println("StringBuilder result: " + result);
  }

}
