import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class JavaEnumMap01 {

    enum RACE { DWARF, ELF, HOBBIT, HUMAN }

    public static void main(String[] args) {

        String[] myArray01 = new String[] {
                "Gimli", "Fili", "Kili"
        };
        String[] myArray02 = new String[] {
                "Arwen", "Elrond", "Gladriel", "Legolas"
        };
        String[] myArray03 = new String[] {
                "Frodo", "Bilbo", "Samwise", "Pippin", "Merry"
        };
        String[] myArray04 = new String[] {
                "Aragorn", "Boromir"
        };

        // Create a Map of RACE with variable length ArrayList of Strings in each Entry
        EnumMap<RACE, List<String>> namesMap = new EnumMap<>(RACE.class);
        namesMap.put(RACE.DWARF, new ArrayList<>(Arrays.asList(myArray01)));
        namesMap.put(RACE.ELF, new ArrayList<>(Arrays.asList(myArray02)));
        namesMap.put(RACE.HOBBIT, new ArrayList<>(Arrays.asList(myArray03)));
        namesMap.put(RACE.HUMAN, new ArrayList<>(Arrays.asList(myArray04)));

        int numCandidates[] = new int[RACE.values().length];

        // DO NOT use enum .ordinal() this way!
        System.out.println("Don't use enum .ordinal() this way for indexing");
        for (RACE race : RACE.values()) {
            numCandidates[race.ordinal()] = namesMap.get(race).size();
            System.out.println("Number of " + race + " candidates: " + numCandidates[race.ordinal()]);
        }

        // Use the EnumMap (namesMap) instead
        System.out.println("\nUse the EnumMap directory with .forEach() without explicit indexing");
        namesMap.forEach((key, value) -> System.out.println("Number of " + key + " candidates: " + value.size()));
    }
}
