## Caesar Encryption

Julius Caesar protected his confidential information by encrypting it in a cipher. Caesar's cipher rotated every letter in a string by a fixed number, making it unreadable by his enemies. In the original cipher only letters were encrypted, symbols such as spaces, `-`, `.`, ... were left unencrypted.

### Required knowledge

This challenge is solvable from the moment you know how to make decisions, loop and know about Strings.

### Challenge

Use the caesar encryption cypher to encrypt a string provided by the user. However, compared to the original also encrypt printable symbols. A good subset of the ASCII values are decimal values 32 (space) to 126 `~`.

![ASCII Table](img/asciifull.gif)

The key should be any valid integral value.

Example:

```text
Welcome to this enhanced Caesar Encryption application.
It will allow you to encrypt a given text with a provided key.
The text can contain any ASCII character between 32 and 126 (inclusive).

Please enter key: 15
Would you like to [e]ncrypt of [d]crypt? e

Please enter text to encrypt:
Hello from the World of Java where we can encrypt things like <html> tags, if (15 > 30) structures and also tildes like ~. Cool is it not.

The encrypted result:
Wt{{~/u"~|/$wt/f~"{s/~u/Yp&p/'wt"t/'t/rp}/t}r") $/$wx}v#/{xzt/Kw$|{M/$pv#;/xu/7@D/M/B?8/#$"%r$%"t#/p}s/p{#~/$x{st#/{xzt/.=/R~~{/x#/x$/}~$=
```

### Solution

The solution can be found [here](solution.md).