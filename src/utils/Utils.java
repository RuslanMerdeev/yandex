package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    static Comparator<Integer> keyComparator = (o1, o2) -> {
        if (o1 % 2 == 1 && o2 % 2 == 0) return -1;
        if (o1 % 2 == 0 && o2 % 2 == 1) return 1;
        return o1.compareTo(o2);
    };

    static Comparator<Map.Entry<Integer, Integer>> valueComparator = (o1, o2) ->
            keyComparator.compare(o1.getValue(), o2.getValue());

    static void printAll(Object... values) {
        Arrays.stream(values).forEach(value -> System.out.println(value.toString()));
    }

    public static void main(String[] args) throws Exception {
        printAll(
                max1(3, 6, 1, 9, 10),
                max2(3, 6, 1, 9, 10),
                min(3, 6, 1, 9, 10),
                mapEqual(Map.of(1, 2), Map.of(1, 2)),
                mapEqual(Map.of(1, 2, 3, 4), Map.of(1, 2)),
                count(1, 2, 3, 2, 2, 5, 1),
                mergeSorted1(List.of(1, 2, 4, 7, 9), List.of(0, 3, 4, 6, 10)),
                mergeSorted2(List.of(1, 2, 4, 7, 9), List.of(0, 3, 4, 6, 10)),
                binarySearch1(2, -10, -6, 0, 1, 2, 4, 6, 8, 10),
                binarySearch2(2, -10, -6, 0, 1, 2, 4, 6, 8, 10),
                sort(List.of(9, 6, 3, 3, -1, 0, 4, 0, 13)),
                sortMap(Map.of(5, 555, 4, 444, 7, 777, 0, 0), keyComparator),
                sortMapByValue(Map.of(5, 777, 4, 0, 7, 444, 0, 555), valueComparator),
                sortList(List.of(8, 5, 10, 3, 6, 2), keyComparator),
                sortSet(Set.of(8, 5, 10, 3, 6, 2), keyComparator),
                round(5.2834, 2, RoundingMode.FLOOR)
        );
    }

    static Integer max1(Integer... values) {
        return Arrays.stream(values).max(Integer::compareTo).get();
    }

    static Integer max2(Integer... values) {
        return Collections.max(List.of(values));
    }

    static Integer min(Integer... values) {
        return Collections.min(List.of(values));
    }

    static Boolean mapEqual(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        return first.equals(second);
    }

    static Map<Object, Long> count(Object... values) {
        return Arrays.stream(values).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        );
    }

    static List<Integer> mergeSorted1(List<Integer> first, List<Integer> second) {
        return Stream.concat(first.stream(), second.stream())
                .sorted()
                .collect(Collectors.toList());
    }

    static List<Integer> mergeSorted2(List<Integer> first, List<Integer> second) {
        if (first.isEmpty()) return second;
        if (second.isEmpty()) return first;
        int firstPos = 0;
        int secondPos = 0;
        ArrayList<Integer> result = new ArrayList();
        while (firstPos < first.size() && secondPos < second.size()) {
            if (first.get(firstPos) < second.get(secondPos)) {
                result.add(first.get(firstPos++));
            } else {
                result.add(second.get(secondPos++));
            }
        }

        while (firstPos < first.size()) {
            result.add(first.get(firstPos++));
        }

        while (secondPos < second.size()) {
            result.add(second.get(secondPos++));
        }

        return result;
    }

    static Integer binarySearch1(Integer key, Integer... values) {
        return Arrays.binarySearch(values, key);
    }

    static Integer binarySearch2(Integer key, Integer... values) {
        List<Integer> listedValues = List.of(values);
        int from = 0;
        int to = listedValues.size();
        while (to != from) {
            int middle = (to + from) / 2;
            if (listedValues.get(middle).equals(key)) {
                return middle;
            } else if (listedValues.get(middle) > key) {
                to = middle;
            } else from = middle;
        }
        return -1;
    }

    static List<Integer> sort(List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }
//        if (values.size() == 2) {
//            if (values.get(0) > values.get(1)) {
//                return List.of(values.get(1), values.get(0));
//            } else return values;
//        }
        List<Integer> sortFirst = sort(values.subList(0, values.size() / 2));
        List<Integer> sortSecond = sort(values.subList(values.size() / 2, values.size()));
        return mergeSorted2(sortFirst, sortSecond);
    }

    static <K, V> TreeMap<K, V> sortMap(Map<K, V> map, Comparator<K> comparator) {
        TreeMap<K, V> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    static <K, V> ArrayList<Map.Entry<K, V>> sortMapByValue(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        ArrayList<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(comparator);
        return list;
    }

    static <T> List<T> sortList(List<T> list, Comparator<T> comparator) {
        return list.stream().sorted(comparator).collect(Collectors.toList());
    }

    static <T> TreeSet<T> sortSet(Set<T> set, Comparator<T> comparator) {
        TreeSet<T> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(set);
        return treeSet;
    }

    static Double round(Double value, int scale, RoundingMode mode) {
        return new BigDecimal(value).setScale(scale, mode).doubleValue();
    }
}
