# Java

## Gotchas Ch 1-5
##### 1. ```var``` cannot be used to declare multiple variables on the same line
```
var a, b = 5; // DOES NOT COMPILE

var a = 5; // OK
var b = 10; // OK
```

##### 2. ```byte```, ```short```, and ```char``` are promoted to ```int``` in arithmetic operations. Even if both operands are smaller than ```int```, the result is ```int```.
```
byte a = 1;
byte b = 2;

byte c = a + b; // DOES NOT COMPILE
int c = a + b; // OK
```

##### 3. The ```default``` label in a ```switch``` statement can appear anywhere, ```default``` doesn’t have to be last
```
int x = 2;
switch (x) {
    default: System.out.println("Default");
    case 2: System.out.println("Case 2");
}
```
##### 4. ```Arrays.binarySearch()``` requires a sorted array. If the array isn’t sorted, the result is unpredictable.
```
int[] arr = {5, 1, 3};
System.out.println(Arrays.binarySearch(arr, 3)); 
```

##### 5. Java can perform either a ```cast``` or ```autoboxing```, not both at the same time. Java cannot both ```cast``` and ```autobox``` in a single step.
```
Long bad = 8;  // DOES NOT COMPILE

Long good = (long)8; // OK 
Long alsoGood = Long.valueOf(8); // OK
```


## Gotchas Ch 6-10
##### 1. Implicit ```super()``` call and missing no-arg constructor

If a subclass constructor doesn’t explicitly call super(...), the compiler inserts super(). If the superclass has no no-arg constructor, this won’t compile.
```
class Parent {
    private final int x;
    Parent(int x) { this.x = x; }   // no no-arg ctor
}

class Child extends Parent {
    // Compiler injects super() here ->  compile error
    Child() { }
}

// Fix: call an existing superclass constructor explicitly
class ChildFixed extends Parent {
    ChildFixed() { super(42); }
}
```

##### 2. ```permits``` is optional (in one specific case)

For sealed classes, the permits clause is optional when all permitted subclasses are declared in the same source file. Otherwise, you must list them with permits
```
sealed class Shape { } 

final class Circle extends Shape { }
final class Square extends Shape { }

// If Circle/Square are in different files, you must write:
// sealed class Shape permits Circle, Square { }

```

##### 3. Lambdas capture only effectively-final variables

Variables captured by a lambda must be effectively final — not modified after assignment.
```

public class Demo {
    public static void main(String[] args) {
        int base = 10;
        Supplier<Integer> s = () -> base + 5; // OK: base is effectively final

        base++; // compile error

        System.out.println(s.get()); 
    }
}

```

##### 4. Java 21 ```sequenced``` collections

Java 21 adds SequencedCollection, SequencedSet, and SequencedMap to unify “insertion-order” APIs. They expose front/back operations and easy reversed views.
```

public class SequencedDemo {
    public static void main(String[] args) {
        // SequencedCollection via ArrayList
        SequencedCollection<String> sc = new ArrayList<>();
        sc.addFirst("b");
        sc.addLast("c");
        sc.addFirst("a");           // [a, b, c]
        System.out.println(sc.getFirst()); // a
        System.out.println(sc.getLast());  // c
        System.out.println(sc.reversed()); // view: [c, b, a]

        // SequencedSet via LinkedHashSet
        SequencedSet<Integer> ss = new LinkedHashSet<>();
        ss.addLast(2); ss.addFirst(1); ss.addLast(3); // [1, 2, 3]
        System.out.println(ss.reversed());            // [3, 2, 1]

        // SequencedMap via LinkedHashMap
        SequencedMap<String,Integer> sm = new LinkedHashMap<>();
        sm.put("a", 1); sm.put("b", 2); sm.put("c", 3); // order: a,b,c
        System.out.println(sm.firstEntry());             // a=1
        System.out.println(sm.lastEntry());              // c=3
        System.out.println(sm.reversed().keySet());      // [c, b, a]
        sm.pollFirstEntry();                              // removes a=1
        sm.pollLastEntry();                               // removes c=3
        System.out.println(sm);                           // {b=2}
    }
}


```


##### 5. ```Spliterator```

A Spliterator is an iterator designed for parallel and bulk traversal. It can: split itself (trySplit()) for parallel work, advance one element at a time (tryAdvance), report characteristics (e.g., ORDERED, SIZED, DISTINCT, …).
```
import java.util.*;
import java.util.Spliterator;

public class SpliteratorDemo {
    public static void main(String[] args) {
        List<String> data = List.of("a","b","c","d","e","f");
        Spliterator<String> s1 = data.spliterator();
        Spliterator<String> s2 = s1.trySplit(); // split into two parts (may be null if too small)

        System.out.println("S1 characteristics: " + s1.characteristics()); // ORDERED | SIZED | SUBSIZED | ...
        System.out.println("Estimated sizes: s1=" + s1.estimateSize() + ", s2=" + (s2==null?0:s2.estimateSize()));

        // Process in parallel-ish style
        Runnable r1 = () -> s1.forEachRemaining(x -> System.out.println("L1: " + x));
        Runnable r2 = () -> { if (s2 != null) s2.forEachRemaining(x -> System.out.println("L2: " + x)); };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}


```

## Gotchas Ch 11-13
##### 1. Try-with-Resources - AutoCloseable Order, Suppressed Exceptions
Resources are closed in reverse order of declaration.
```
try (A a = new A(); B b = new B()) {
    ...
}
// b.close() runs before a.close()
```

If both the body and the close() throw, the close() exception is suppressed, not lost.
```
class MyRes implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Closing resource...");
        throw new RuntimeException("from close()"); 
    }
}
...
try (MyRes r = new MyRes()) {
    throw new RuntimeException("body");
} catch (Exception e) {
    for (Throwable t : e.getSuppressed())
        System.out.println("Suppressed: " + t);
}
```

```
Closing resource...
Caught: java.lang.RuntimeException: from body
Suppressed: java.lang.RuntimeException: from close()
```
