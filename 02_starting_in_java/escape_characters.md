## Escape Characters

The `println` method also has a variant which does not print a new line at the end of the string.
This method is called `print`. A newline can be displayed by
calling `println` with an empty string `""` as argument or you can add a special character `\n` inside your string
to output newlines. These special characters that are prefixed with a `\` are called escape characters. Most programming languages have them. The code below shows examples of all these techniques.

```java
public static void main(String[] args) {
    // TODO code application logic here
    System.out.print("You can also print ");
    System.out.print("text to the terminal ");
    System.out.print("without starting a newline.");
    System.out.println("");   // Force a newline
    System.out.print("Or you can also force newlines\nusing escape characters.\n");
    System.out.print(".............\n\n");
}
```

Which outputs

```text
You can also print text to the terminal without starting a newline.
Or you can also force newlines
using escape characters.
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