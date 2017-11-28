## For-Each Loop

Iterating over an array or collection is often uglier than it needs to be. Consider the following method, which an array of integers and calculates the average:

```java
int values[] = {1, 5, 43, 2, 0};

int sum = 0;
for (int i = 0; i < values.length; i++) {
  sum += values[i];
}

System.out.println("Average = " + 1.0*sum/values.length);
```

The iteration variable `i` is just clutter. Furthermore, it is an opportunity for error. The iteration variable occurs four times in each loop: that is three chances to get it wrong. The for-each construct gets rid of the clutter and the opportunity for error. Here is how the example looks with the for-each construct:

```java
int values[] = {1, 5, 43, 2, 0};

int sum = 0;
for (int value : values) {
    sum += value;
}
System.out.println("Average = " + 1.0*sum/values.length);
```

When you see the colon (:) read it as "in". The loop above reads as "for each int value in values". As can be seen from the code, the for-each makes the code a lot cleaner. It preserves all of the type safety, while removing the remaining clutter. A huge advantage is that you do not need to declare the iteration variable. (The compiler does this for you behind your back, but you need not concern yourself with it.)

### On Collections

The for-each loop also works perfectly with collection classes such as the `ArrayList`. Take a look at the example below where an ArrayList is used to store "Hello World" messages in different languages.

```java
ArrayList<String> hellos = new ArrayList();
hellos.add("Hello World in English");
hellos.add("Hallo wereld in het Nederlands");
hellos.add("Bonjour le monde en français");
hellos.add("Hallo Welt auf Deutsch");
hellos.add("Hello World ann an Gàidhlig na h-Alba");

for (String hello : hellos) {
    System.out.println(hello);
}
```

### Limitations of for-each loop

So when should you use the for-each loop? Any time you can. It can make your code a lot more cleaner. Unfortunately, it cannot be used everywhere.

Consider the situations listed below where a for-each loop cannot be used.

1. A for-each loop cannot be used if you wish to modify the array itself:
```java
for (int val : values) {
    // Only changes the local `val` variable and not the actual array element
    val = val * 2;
}
```
This also means that a for-each cannot be used to initialize an array or collection.

2. For-each loops do not keep track of an iteration variable. This means it is not possible to use an array index inside the for-each loop.

3. For-each only iterates forward over the array in single steps.
```java
int values[] = {1, 5, 43, 2, 0};
// Impossible to do with a for-each
for (int i = values.length-1; i > 0; i--) {
    System.out.print(values[i] + " ");
}
```

4. For-each loops are not useable when one must iterate over multiple collections/arrays at the same time:

```java
int temperatures1[] = { 23, 14, 144, 23, 44 };
int temperatures2[] = { 23, 22, 144, 33, 44 };

// Not possible to do with a for-each loop
for (int i = 0; i < temperatures1.length; i++) {
    if (temperatures1[i] != temperatures2[i]) {
        System.out.println("Temperatures differ");
    }
}
```

These shortcomings were known by the designers, who made a conscious decision to go with a clean, simple construct that would cover the great majority of cases.
