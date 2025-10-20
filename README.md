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

