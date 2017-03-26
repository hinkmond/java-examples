import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Java8Features {

    static List<Integer> myList =
        new ArrayList<>(Arrays.asList( 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 ));

    public static void main(String[] args) {

        // StringBuilder: Builder Design Pattern
        StringBuilder sb = new StringBuilder();
        String result = sb.append("do this ")
            .append("do that ")
            .append("do the other thing.")
            .toString();
        System.out.println("StringBuilder result: " + result);

        // Typical for-loop
        System.out.print("for-loop: ");
        int numArray[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i<numArray.length; i++) {
            System.out.print(numArray[i] + " ");
        }
        System.out.println();  // Line-feed

        // Traversing using Iterator
        System.out.print("Iterator: ");
        Iterator<Integer> myListIterator = myList.iterator();
        while (myListIterator.hasNext()) {
            Integer i = myListIterator.next();
            System.out.print(i + " ");
        }
        System.out.println();  // Line-feed

        // Traversing using Generics and Enhanced for-loop
        System.out.print("Generics & Enhanced for-loop: ");
        for (Integer intVal : myList) {
            System.out.print(intVal + " ");
        }
        System.out.println();  // Line-feed

        // Traversing using forEach() and Lambdas
        System.out.print("forEach() & Lambda Expression: ");
        myList.forEach(intVal -> System.out.print(intVal + " "));
        System.out.println();  // Line-feed

    }
}
