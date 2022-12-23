import java.sql.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DefaultValueTest {
    byte byteDefaultValue;
    static int intDefaultValue;
    short shortDefaultValue;
    long longDefaultValue;
    float floatDefaultValue;
    double doubleDefaultValue;
    boolean booleanDefaultValue;
    String referenceDefaultValue;
}

public class PracticeTest {
    public static void main(String[] args) {
        Stream<Integer> stream = IntStream.range(1,10).boxed();

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c"));
                list.stream()
                .filter("a"::equals)
                .forEach(System.out::println);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(4, 2);
        map.put(1, 3);
        map.put(5, 3);
        map.put(2, 3);
        System.out.println(Collections.max(map.values()));
        System.out.println(Collections.min(map.values()));
        for (Map.Entry<Integer, Integer> test: map.entrySet()
             ) {
            System.out.println(test.getKey()+","+test.getValue());
        }
        System.out.println(Collections.max(map.entrySet(), (o1, o2) -> {
            return compare(o1, o2);
        }));

    }
    private static int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getKey() - o2.getKey();
    }
}
