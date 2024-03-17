# Cycle Swap

Given a skeleton of [`CycleSwap`](src/main/java/com/epam/rd/autotasks/CycleSwap.java) class, implement its static methods:

* `void cycleSwap(int[] array)`\
  Shifts all the elements in the given array to the right by 1 position.\
  The originally last element of the array becomes first.\
  E.g. `1 3 2 7 4` becomes `4 1 3 2 7`.

* `void cycleSwap(int[] array, int shift)`\
  Shifts all the elements in the given array to the right direction in the cycle manner by `shift` positions.\
  Shifts value is guaranteed to be non-negative and not bigger than array length.\
  E.g. `1 3 2 7 4` with shift of `3` becomes `2 7 4 1 3`.

For greater challenge, try not using loops in your code (not obligatory).

## Examples
You may use [Main](src/test/java/com/epam/rd/autotasks/Main.java) class to try your code.
There are some examples below.

---
Code Sample:
```java
...
int[] array = new int[]{1, 3, 2, 7, 4};
CycleSwap.cycleSwap(array);
System.out.println(Arrays.toString(array));
```

Output:
```
[4, 1, 3, 2, 7]
```

---
Code Sample:
```java
...
int[] array = new int[]{1, 3, 2, 7, 4};
CycleSwap.cycleSwap(array, 2);
System.out.println(Arrays.toString(array));
```

Output:
```
[7, 4, 1, 3, 2]
```

---
Code Sample:
```java
...
int[] array = new int[]{1, 3, 2, 7, 4};
CycleSwap.cycleSwap(array, 5);
System.out.println(Arrays.toString(array));
```

Output:
```
[1, 3, 2, 7, 4]
```
