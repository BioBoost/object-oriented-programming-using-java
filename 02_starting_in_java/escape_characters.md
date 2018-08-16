## Escape Characters

The `println` method also has a variant which does not print a new line at the end of the string.
This method is called `print`. A newline can be displayed by
calling `println` with an empty string `""` as argument or you can add a special character `\n` inside your string
to output newlines. These special characters that are prefixed with a `\` are called escape characters. Most programming languages have them. The code below shows examples of all these techniques.

```java
public static void main(String[] args) {
    System.out.println("There\tis\ta\ttab\tbetween\teach\tword");
    System.out.println("You can also use quotes here but they need to be escaped:");
    System.out.println("--------------------------------------------------------");
    System.out.println("\"C makes it easy to shoot yourself in the foot; C++ makes it harder,\nbut when you do it blows your whole leg off.\"");
    System.out.println("by Bjarne Stroustrup");
    System.out.println("--------------------------------------------------------");
}
```

Which generates the following output:

```text
There	is	a	tab	between	each	word
You can also use quotes here but the need to be escaped:
--------------------------------------------------------
"C makes it easy to shoot yourself in the foot; C++ makes it harder,
but when you do it blows your whole leg off."
by Bjarne Stroustrup
.............

BUILD SUCCESSFUL (total time: 0 seconds)
```

The table below lists the escape sequences supported by Java.

| Escape Sequence | Description |
| --- | --- | --- |
| `\t` | Insert a tab in the text at this point. |
| `\b` | Insert a backspace in the text at this point. |
| `\n` | Insert a newline in the text at this point. |
| `\r` | Insert a carriage return in the text at this point. |
| `\f` | Insert a formfeed in the text at this point. |
| `\'` | Insert a single quote character in the text at this point. |
| `\"` | Insert a double quote character in the text at this point. |
| `\\` | Insert a backslash character in the text at this point. |
