import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class JavaBasicMap {

    public static void main(String args[]) {
        String[] myArray01 = new String[]{
                "FREd", "dEbbIe", "AMY", "JAnE"
        };
        String[] myArray02 = new String[]{
                "TheODOre", "LEONard", "RaLPh", "JustiNE"
        };
        String[] myArray03 = new String[]{
                "sAMUel", "GeorGE", "ALBert", "ANn", "BeCKy"
        };

        HashMap<Integer, List<String>> namesMap = new HashMap<>();

        namesMap.put(1, new ArrayList<>(Arrays.asList(myArray01)));
        namesMap.put(2, new ArrayList<>(Arrays.asList(myArray02)));
        namesMap.put(3, new ArrayList<>(Arrays.asList(myArray03)));

        List<String> mappedList = namesMap.values().stream()
                .flatMap(mapValues -> mapValues.stream()
                        .map(item -> {
                            String tempString = item.toLowerCase();
                            return Character.toUpperCase(tempString.charAt(0)) +
                                    tempString.substring(1);
                        }))
                .collect(Collectors.toList());
        mappedList.forEach(System.out::println);
    }

}
