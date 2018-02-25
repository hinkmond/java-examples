import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class JavaEnumMap01 {

    enum RACE { DWARF, ELF, HOBBIT, HUMAN }

    public static void main(String[] args) {

        String[] myArray01 = new String[] {
                "Gimli", "Fili", "Kili", "Thorin"
        };
        String[] myArray02 = new String[] {
                "Arwen", "Elrond", "Gladriel", "Legolas"
        };
        String[] myArray03 = new String[] {
                "Frodo", "Bilbo", "Samwise", "Pippin", "Merry"
        };
        String[] myArray04 = new String[] {
                "Aragorn", "Boromir", "Saruman", "Gandalf", "Eowyn"
        };

        // Create a Map of RACE with variable length ArrayList of Strings in each Entry
        EnumMap<RACE, List<String>> namesMap = new EnumMap<>(RACE.class);
        namesMap.put(RACE.DWARF, new ArrayList<>(Arrays.asList(myArray01)));
        namesMap.put(RACE.ELF, new ArrayList<>(Arrays.asList(myArray02)));
        namesMap.put(RACE.HOBBIT, new ArrayList<>(Arrays.asList(myArray03)));
        namesMap.put(RACE.HUMAN, new ArrayList<>(Arrays.asList(myArray04)));

        // For each key/value pair in the Map print the RACE (key) and the List of names (value) of that RACE
        namesMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
