
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