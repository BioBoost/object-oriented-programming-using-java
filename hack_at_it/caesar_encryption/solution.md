## Caesar Encryption - Solution

This is a step-by-step solution build guide to the Caesar Encryption Hack @ IT challenge.

### Step 1 - Output and User Input

Start of by generating some meaningful output and requesting some of the information from the user such as the key, encryption or decryption and the input text.

```java
Scanner console = new Scanner(System.in);
System.out.println("Welcome to this enhanced Caesar Encryption application.");
System.out.println("It will allow you to encrypt a given text with a provided key.");
System.out.println("The text can contain any ASCII character between 32 and 126 (inclusive).");

System.out.print("\nPlease enter key: ");
int userKey = console.nextInt();
System.out.print("Would you like to [e]ncrypt of [d]crypt? ");
boolean doEncrypt = true;
if (console.next().toLowerCase().equals("d")) {
  doEncrypt = false;
}
console.nextLine();   // Eat trailing newline

String userInput = "";
if (doEncrypt) {
  System.out.println("\nPlease enter text to encrypt:");
} else {
  System.out.println("\nPlease enter text to decrypt:");
}
userInput = console.nextLine();
```

### Step 2 - Accessing the Characters for Encryption

The characters can be looped using a for-loop and each character can be accessed using the `charAt()` method of a String by providing the index.

```java
  Scanner console = new Scanner(System.in);
  System.out.println("Welcome to this enhanced Caesar Encryption application.");
  System.out.println("It will allow you to encrypt a given text with a provided key.");
  System.out.println("The text can contain any ASCII character between 32 and 126 (inclusive).");

  System.out.print("\nPlease enter key: ");
  int userKey = console.nextInt();
  System.out.print("Would you like to [e]ncrypt of [d]crypt? ");
  boolean doEncrypt = true;
  if (console.next().toLowerCase().equals("d")) {
    doEncrypt = false;
  }
  console.nextLine();   // Eat trailing newline

  String userInput = "";
  if (doEncrypt) {
    System.out.println("\nPlease enter text to encrypt:");
  } else {
    System.out.println("\nPlease enter text to decrypt:");
  }
  userInput = console.nextLine();

  if (doEncrypt) {
    String encrypted = "";
    for (int i = 0; i < userInput.length(); i++) {
      char x = userInput.charAt(i);
      encrypted += x;
    }
    System.out.println("\nThe encrypted result:\n" + encrypted + "\n");
  }
```

The output should like look:

```text
Welcome to this enhanced Caesar Encryption application.
It will allow you to encrypt a given text with a provided key.
The text can contain any ASCII character between 32 and 126 (inclusive).

Please enter key: 12
Would you like to [e]ncrypt of [d]crypt? e

Please enter text to encrypt:
Hello World

The encrypted result:
Hello World

Press any key to continue . . .
```

### Step 3 - Encryption

This is probable the hardest part to understand. Try to write it out on paper to understand the steps.

The basic idea is that we need to add the value of the key to the ASCII value of the `x` character. A restriction is that the value should stay without the boundaries of the subset of characters we chose (32 and 126 in our case). This can be achieved using a modulo operation.

However applying modulo to `x + key` is not correct because our minimal value is 32 while the modulo operation also takes the values below 32 into account. So if we for example have an x-value of `126` and we add `2`, we would like to land at `33`. Using `(x + key) % 127` we would land at `1`.

This can be solved by shifting our ASCII subset range to zero first where the modulo operator can its work correctly. This is easily achieved by extracting our minimal value from `x`. After applying the encryption and module we can shift back to the original range by adding the minimal value to `x`.

Or by pseudo code example:

```text
x = 126
key = 2

valid range: [32, 126]

x = x - 32 shifts our range to [0, 94] or [0, maximal - minimal]
x = x + key would now result in x = 96
x = x % 95 (maximal - minimal + 1) would result in x = 1
x = x + 32 would shift back to range: x = 33
```

Or translated into a one-liner in code:

```java
// ...
final int MIN_ASCII = 32;
final int MAX_ASCII = 126;

if (doEncrypt) {
  String encrypted = "";
  for (int i = 0; i < userInput.length(); i++) {
    char x = userInput.charAt(i);
    x = (char)((((x - MIN_ASCII) + userKey) % (MAX_ASCII - MIN_ASCII + 1)) + MIN_ASCII);
    encrypted += x;
  }
  System.out.println("\nThe encrypted result:\n" + encrypted + "\n");
}
```

Now the `Hello World` text should be encrypted into `Wt{{~/f~"{s` when using a key of `15`.

### Step 4 - Decryption

There are two approaches to decrypting the text. One is to inverse the `+ key` operation by extracting the key. This would result in the fact that we would have to deal with possible negative numbers. If it previously wrapped and got fixed by the modulo operation, we get the same here but on the other side.

However if we could find a key value that we can add to the ASCII value of the characters that would result in the original ASCII character value, than we could reuse the previous code construct.

Lets hack at a pseudo-code example again:

```text
Consider x = 44
key = 4

This would result in an encrypted value for x of 48. Call this y

y = 48

We need to change the key to a value so that when we add
the key to 48 the result would be 44 with the same algorithm
as for the encryption.

valid range: [32, 126]

So our shifted range was [0, 94]
Which would put x = 12 and y = 16
Inside of this range we have 95 possible values: MAX - MIN + 1

|-----x...y----------------------------|     => 95 values in range
0     12 16                           94

So the new key has a value that bridges from 16 to 12.
Or: newKey = 95 - currentKey
    newKey = 95 - 4 = 91 in this case

Or as code: userKey = MAX_ASCII - MIN_ASCII + 1 - userKey;
```

Leading to:

```java
if (doEncrypt) {
  String encrypted = "";
  for (int i = 0; i < userInput.length(); i++) {
    char x = userInput.charAt(i);
    x = (char)((((x - MIN_ASCII) + userKey) % (MAX_ASCII - MIN_ASCII + 1)) + MIN_ASCII);
    encrypted += x;
  }
  System.out.println("\nThe encrypted result:\n" + encrypted + "\n");
} else {
  userKey = MAX_ASCII - MIN_ASCII + 1 - userKey;
  String decrypted = "";
  for (int i = 0; i < userInput.length(); i++) {
    char x = userInput.charAt(i);
    x = (char)((((x - MIN_ASCII) + userKey) % (MAX_ASCII - MIN_ASCII + 1)) + MIN_ASCII);
    decrypted += x;
  }
  System.out.println("\nThe decrypted result:\n" + decrypted + "\n");
}
```

### Step 5 - Cleanup

The current solution has some duplicate code which we can remove. If we move the encryption/decryption after the if construct we have a lot less code. For this we also need to rename the Strings `encrypted` and `decrypted` to for example `processedString`.

This gives us the solution:

```java
Scanner console = new Scanner(System.in);
System.out.println("Welcome to this enhanced Caesar Encryption application.");
System.out.println("It will allow you to encrypt a given text with a provided key.");
System.out.println("The text can contain any ASCII character between 32 and 126 (inclusive).");

System.out.print("\nPlease enter key: ");
int userKey = console.nextInt();
System.out.print("Would you like to [e]ncrypt of [d]crypt? ");
boolean doEncrypt = true;
if (console.next().toLowerCase().equals("d")) {
  doEncrypt = false;
}
console.nextLine();   // Eat trailing newline

String userInput = "";
if (doEncrypt) {
  System.out.println("\nPlease enter text to encrypt:");
} else {
  System.out.println("\nPlease enter text to decrypt:");
}
userInput = console.nextLine();

final int MIN_ASCII = 32;
final int MAX_ASCII = 126;

if (!doEncrypt) {
  userKey = MAX_ASCII - MIN_ASCII + 1 - userKey;
}

// Encrypt / decrypt
String processedString = "";
for (int i = 0; i < userInput.length(); i++) {
  char x = userInput.charAt(i);
  x = (char)((((x - MIN_ASCII) + userKey) % (MAX_ASCII - MIN_ASCII + 1)) + MIN_ASCII);
  processedString += x;
}

if (doEncrypt) {
  System.out.println("\nThe encrypted result:\n" + processedString + "\n");
} else {
  System.out.println("\nThe decrypted result:\n" + processedString + "\n");
}
```

<!-- What happens if the key is bigger than `94` of negative? -->