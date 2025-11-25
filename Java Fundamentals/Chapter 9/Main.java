import java.util.*;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        testListBehavior();

        testListOperations();

        testHashSet();

        testLinkedHashSet();

        testTreeSet();

        addElementsAndPrint(new HashMap<>());

        addElementsAndPrint(new LinkedHashMap<>());

        addElementsAndPrint(new TreeMap<>());

        getValuesSafely();

        testMapMerge();

        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<A>();
        List<? super A> list3 = new ArrayList<Object>();
    }

    public static void testListBehavior() {
        String[] array = new String[] {"a", "b", "c"};
        List<String> asList = Arrays.asList(array);
        List<String> of = List.of(array);
        List<String> copy = List.copyOf(asList);

        array[0] = "z";

        System.out.println(asList);
        System.out.println(of);
        System.out.println(copy);

        asList.set(0, "x");
        System.out.println(Arrays.toString(array));

//        of.set(0, "y");
//        copy.set(0, "y");
//        asList.add("z");
//        of.remove(0);
//        copy.remove(0);
    }

    public static void testListOperations() {
        List<String> list = new ArrayList<>();
        list.add("SD");
        list.add(0, "NY");
        list.set(1, "FL");
        System.out.println(list.get(0));
        list.remove("NY");
        list.remove(0);
//        list.set(0, "?");
    }

    public static void testHashSet(){
        Set<Integer> set = new HashSet<>();
        boolean b1 = set.add(66);
        boolean b2 = set.add(10);
        boolean b3 = set.add(66);
        boolean b4 = set.add(8);
        for (Integer value: set)
            System.out.print(value + ",");
        System.out.println();
    }

    public static void testLinkedHashSet(){
        Set<Integer> set = new LinkedHashSet<>();
        boolean b1 = set.add(66);
        boolean b2 = set.add(10);
        boolean b3 = set.add(66);
        boolean b4 = set.add(8);
        for (Integer value: set)
            System.out.print(value + ",");
        System.out.println();
    }

    public static void testTreeSet(){
        Set<Integer> set = new TreeSet<>();
        boolean b1 = set.add(66);
        boolean b2 = set.add(10);
        boolean b3 = set.add(66);
        boolean b4 = set.add(8);
        for (Integer value: set)
            System.out.print(value + ",");
        System.out.println();
    }

    public static void addElementsAndPrint(Map<String, String> map) {
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala");
        System.out.println(food);
        for (String key: map.keySet())
            System.out.print(key + ",");
        System.out.println();
    }

    public static void getValuesSafely(){
       Map<Character, String> map = new HashMap<>();
       map.put('x', "spot");
       System.out.println("X marks the " + map.get('x'));
       System.out.println("X marks the " + map.getOrDefault('x', ""));
       System.out.println("Y marks the " + map.get('y'));
       System.out.println("Y marks the " + map.getOrDefault('y', ""));
    }

    public static void testMapMerge() {
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");

        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);

        System.out.println(favorites);
        System.out.println(jenny);
        System.out.println(tom);
    }


}

class A {}
class B extends A {}
class C extends B {}