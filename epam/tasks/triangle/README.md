# Triangle

Given: class [`Point`](src/main/java/com/epam/rd/autotasks/triangle/Point.java) and a skeleton of class [`Triangle`](src/main/java/com/epam/rd/autotasks/triangle/Triangle.java).

Implement `Triangle` methods:

* constructor, having three points as parameters.\
    These points refers to vertices of the triangle.\
    Ensure that created triangle exists and it is not degenerative.\
* `double area()`\
    Returns the area of the triangle.
* `Point centroid()`\
    Returns the centroid of the triangle.

Hints:
* [Triangle existence reference](https://en.wikipedia.org/wiki/Triangle#Existence_of_a_triangle)
* [Triangle area reference](https://en.wikipedia.org/wiki/Triangle#Computing_the_area_of_a_triangle)
* [Centroid reference](https://en.wikipedia.org/wiki/Centroid)

Please *Note* that you may benefit from introducing more classes.
 
## Examples
You may use [Main](src/test/java/com/epam/rd/autotasks/triangle/Main.java) class to try your code.
There are some examples below.
---
Sample code:
```java
...
new Triangle(new Point(0,0), new Point(1, 0), new Point(2, 0));
```

Result: Exception because such a triangle would be degenerative.

---
Sample code:
```java
...
double area = new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 4)).area();
System.out.println(area);
```

Output:

```
6
```

---
Sample code:
```java
...
Point centroid = new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 3)).centroid();

System.out.println(centroid.getX());
System.out.println(centroid.getY());
```

Output:

```
1
1
```
