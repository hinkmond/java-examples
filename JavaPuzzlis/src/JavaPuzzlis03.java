/**
 * Created by hinkmond on 4/27/2017.
 */
public class JavaPuzzlis03 {
  private static class Casting {

    private static void doIt(String[] args) {
      if ((byte)0x90 == 0x90) {
        System.out.println("#1 True");
      } else {
        System.out.println("#1 False");
      }

      if (0x90 == 0x90) {
        System.out.println("#2 True");
      } else {
        System.out.println("#2 False");
      }

      if (0x90 == 144) {
        System.out.println("#3 True");
      } else {
        System.out.println("#3 False");
      }

      if ((byte)0x90 == (byte)0x90) {
        System.out.println("#4 True");
      } else {
        System.out.println("#4 False");
      }

      if ((int)0x90 == (int)144) {
        System.out.println("#5 True");
      } else {
        System.out.println("#5 False");
      }

      System.out.println("Done");
    }

  }

  // JavaPuzzlis02 Main
  public static void main(String[] args) {
    Casting.doIt(null);
  }

}
