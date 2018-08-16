## Comments

First of all, not all lines of text that are shown in the program are considered code. Some are actually comments which are not executed. There are
two ways in Java to indicate that some text is a comment. The first is prepending a double slash `//` before your comment. This needs to
be placed before each line of comments.

```java
// This is a line of comments
// This is another line of comments
// Yet again some comments
```

Because this can be a bit of a nuisance when you have a big block of comments, you can also place `/*` before your block and `*/` after the block (also called a block-comment). This allows a programmer to easily create a paragraph as comments.

```java
/*
  This is a bigger paragraph
  that consists of multiple lines.
  It is typically also called a block-comment.
  */
```

Do note that the initial code shows an `*` before each line in a block-comment. This is a special notation that is called Javadoc. It allows automatic generation of Javadoc manual pages similar to the Java API at [https://docs.oracle.com/javase/10/docs/api/](https://docs.oracle.com/javase/10/docs/api/). More information about Javadoc can be found at [http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html).

{% hint style="warning" %}
**Too much Information**

It is completely normal as a beginning programmer to place a lot of comments inside your code. While this is helpful when learning to program, it is also kind of dangerous. Code typically changes while the project evolves and often comments do not. They can therefore contain wrong information about the code and become useless and even misleading. A good programmer (one that takes care of code) will not need a lot of comments. The best documentation is the code itself, of course provided that you take care of your naming of things and your code in general.
{% endhint %}