public class JavaBasicStringCompare {

    public static void main(String args[]) {
        // Case #1
        System.out.println(new String("test").equals("test"));

        // Case #2
        System.out.println(new String("test") == "test");

        // Case #3
        System.out.println(new String("test") == new String("test"));

        // Case #4
        System.out.println("test" == "test");

        // Case #5
        System.out.println("test" == "te" + "st");
    }
}
