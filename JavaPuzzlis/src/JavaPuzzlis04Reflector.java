import java.util.*;
import java.lang.reflect.*;
import java.lang.String;

public class JavaPuzzlis04Reflector {
    public static void main(String[] args) throws Exception {
        Set<java.lang.String> s = new HashSet<>();
        s.add("foo");
        Iterator it = s.iterator();
        Method m = it.getClass().getMethod("hasNext");
        System.out.println(m.invoke(it));
    }
}