## Hello World in Java

Let's jump right in and create a "Hello World" application in Java.

Open NetBeans and create a new Project by selecting `File => New Project => Java Application`. Give is a sensible name such as "HelloWorld".

It will automatically generate an empty application with the code shown below.

{% hint style="info" %}
**Console Applications**

When developing applications a choice must be made between a GUI and a console application. As discussed earlier, a console application has no real graphical user interface and interacts with the user via the terminal (console). The only option for input and output are essentially text. This course will focus on console applications. Object Oriented Programming 2 will introduce JavaFX allowing the creation of graphical applications in Java.
{% endhint %}

```java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author Nico De Witte
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
```

Running this application will output something like shown below.

```java
BUILD SUCCESSFUL (total time: 0 seconds)
```

While not diving into many details here, there are however a couple of things which can be clarified about the code above.