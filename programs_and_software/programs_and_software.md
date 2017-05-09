<!-- toc -->

# Programs and Software

Based on https://en.wikiversity.org/wiki/Introduction_to_Programming/About_Programming

## An Application

A computer is a tool for solving problems with data.

A program or an application is a sequence of instructions that tell a computer how to do a certain task. When a computer follows the instructions in a program, it is said it executes the program. You can think of it like a recipe that tells you how to make a peanut butter sandwich. In this model, you are the computer, making a sandwich is the task, and the recipe is the program that tells you how to execute the task.

> #### Assignment::Cleaning a Car
>
>  Come up with a sequence of instructions to tell someone how to clean a car. Don't leave any steps out, or put them in the wrong order.

Was that easy? Did you remember all the steps? Maybe you forgot to tell me to use a sponge to rub the soap on the car. Now I might be rubbing a car with my bare hands. Of course, you say, a person wouldn't be that dumb. But a computer is that dumb. A computer will only do what you tell it to do. This might make programming frustrating at first, but it's relieving in a way: if you do everything right, you know exactly what the computer is going to do, because you told it.

> #### Note::Don't blame the Computer, blame the programmer
>
>  As a future programmer you should never state that the computer is doing something wrong when your applications fails, crashes or does something unexpected. You should instead ask yourself, did I tell the computer how to do the job correctly? Did I forget something? Did I misinterpret the problem or do I have the solution wrong?

Of course, computers don't understand recipes written on paper. Computers are machines, and at the most basic level, they are a collection of switches - where 1 represents "on" and 0 represents "off". Everything that a computer does is implemented in this most basic of all numbering systems - binary. If you really wanted to tell a computer what to do directly, you'd have to talk to it in binary, giving it coded sequences of 1s and 0s that tell it which instructions to execute. However, this is nearly impossible. In practice, we use a programming language.

![Programming Language to Instruct Computer[^1]](img/Programming_language.png)

[^1]: Source https://en.wikiversity.org/wiki/Introduction_to_Programming/About_Programming

## Programming Language

A programming language is, as the name would suggest, a language developed to express programs. All computers have a native programming language that they understand, commonly referred to as machine code. However, machine code is a difficult language for us to follow: amongst a number of difficulties, it is typically expressed in the binary number system, and it is unique to a particular computer architecture (thus two different computers could potentially use two different versions of machine code).

Other programming languages, such as Assembly, BASIC, Java and C++ exist to provide a better interface between us, as the programmers, and the computer, by allowing programs to be expressed in a language that is easier for us to understand and potentially common to a number of computer architectures, but which can still be translated into machine code. In order for this to happen, a computer must either compile or interpret programs written in one of these languages before they can be executed.

## Compilation vs Interpretation

A compiled program has to be translated into machine code before it is used. The binary is then permanently stored. As an analogy, think of a novel that was written in one language and then translated into another. For example, the Harry Potter novels were written in British English, and were then subsequently translated into 67 other languages. In much the same way, a computer program can be compiled (or "translated") into machine code, and it may potentially be compiled into different architectures (or "dialects") of machine code to suit different computers. Each translation will be a unique version of the program, in the same way that each translated book is a unique version of the original novel. To take the analogy further, if I was fortunate enough to have written the first Harry Potter novel, it may be the case that I wouldn't understand the language into which it is translated. Thus I could be given the Latvian version of the novel, and I could reasonably surmise that it tells the same story as the British English one, but I would be unable to read it. In the same sense, the version of my program that has been compiled into machine code might be impossible for me to read: it is said to be "machine-readable", in that the computer can understand it, but it is far from easily readable for humans.

An interpreted program is stored in a human-readable form. When the program is executed, an interpreter translates the human-readable content as it is run. This is analogous to the role that a human interpreter performs. For example, rather than translating the British English version of Harry Potter into Latvian and then providing the Latvian version to someone who understands the language, (as per compilation), we could hire a translator who knows both British English and Latvian. The translator may choose to read each line from the British English novel, translate each line (one at a time) into Latvian, and, as each line is translated, relate it to the listener. The computer interpreter performs the same function: it reads an instruction in one programming language, translates it into machine code, and then executes the machine code version. Once that instruction is out of the way it moves along to the next, performing exactly the same task, in much the same way that the interpreter of the Harry Potter novel would move on to the next line once the first has been related. Unlike compiled programs, at no point is a complete, discrete, machine code version of the program produced: at any point in time only a small number of instructions exist as machine code versions, and these will be removed from the computer's memory when they are no longer required.

There are advantages for both types of software development. As a generalization, compiled programs are faster to run but slower to develop. Compiled programs often run faster because the computer only needs to execute the previously translated instructions. In interpreted languages, every time the program is run the computer also needs to translate each of the instructions. This translation causes a delay, slowing the execution of the program. On the other hand, interpreted languages are often written in a smaller time frame, because the languages are simpler and the whole program does not need to be compiled each time a new feature is bug tested.

## Levels of programming languages

Programming languages are described in levels. Low-level programming is close to machine code, high-level programming is closer to natural languages. At the most basic level (or "lowest level") is assembly language. This language is just a direct translation of the binary instructions the computer executes - each assembly language instruction directly relates to one in machine code. Thus just as every kind of processor architecture has its own machine code, each processor architecture also has its own assembly language.

An assembly example:

```assembly
LUI  R1, #1
LUI  R2, #2
DADD R3, R1, R2
```

This just did the calculation `1 + 2 = 3`. Very roughly, the first two lines load the numbers "1" and "2" into the computer's memory, and the third instruction tells the computer to add the values together and store the result.

As you can see from the example, assembly language is quite dissimilar to natural languages. Higher level languages both get closer to natural languages and provide more efficient methods of expressing the instructions - thus to implement a given feature for a program in assembly language almost always requires more code than implementing the same feature in a higher level language such as C or C++. Assembly language gives the programmer the ultimate in flexibility and performance, at the expense of complexity and development time.

High-level languages look more like natural language with mathematical operations thrown in. These languages require more translation before the computer will understand them, but they are much easier to write. Here's what the same program might look like in a high-level language such as Java:

```java
x = 1 + 2;
```

The variation between different programming languages can be quite extensive.

> #### Assignment::Different Programming Languages
>
>  Find 5 examples of different programming languages. Try to find a small code example and determine if the language is interpreted or compiled.

## How to become a programmer

A programmer is generally tasked with producing a **solution to a problem** via a computer program, which can be reused as various particular instances of that problem arise. To accomplish this task, the programmer therefore must be able to **understand the problem**, derive an **appropriate solution**, and then be able to effectively **express that solution in a computer programming language**.

The first prerequisite to becoming a programmer is to develop a strong background in **problem solving** as is often required in fields such as mathematics and engineering. The ability to formally, concisely, and clearly state a problem and then derive its solution is a fundamental skill that precedes the process of any computer coding. The study of computer algorithms focuses on the generalized problem solving approaches often applicable in computer science. Techniques such as programming design patterns provide practical templates which often help frame solutions in an understandable, reusable manner. In general, there are many different classes of problems in computer science that require different techniques to solve effectively: having a strong repertoire of approaches aids in finding good solutions.

The second prerequisite to becoming a programmer is knowing a programming language with which to express a particular solution to a problem. A programming language is a tool, which practice will help hone into expertise. Learning multiple languages can often be helpful as the process will demonstrate the particular strengths of different approaches to solving particular classes of problems.

In both these areas, **practice is essential**. Exposure to a wide variety of problems and tools to solve them will increase your understanding of the field as whole, to judge for yourself the relative merit of techniques in the field, as well as to discover unique, new approaches to addressing the problems of computer science. As with the practice of any new skill, do not be afraid to make mistakes, to redo earlier work, or to stumble along the way to expertise.

**Don't be afraid to make mistakes** because you will make them - constantly and for the rest of your career. Even the best programmers make mistakes regularly (if they try to say differently then they are either lying or deluded). Making mistakes is really part of the programming process. Someone said, to find a solution to a problem you must partly solve the problem. So you'll probably end up rewriting parts of your programs several times. Part of what distinguishes better programmers is their ability to catch at least some mistakes before they become a problem. Nobody can catch them all without help. Well, nobody can catch them all: there is no bug-free program.

Learn to work with others in a **team** environment. People have different strengths and weaknesses and a good team can bring together people whose strengths and weaknesses are complementary. The members of a team can teach each other. Most importantly, teams can tackle problems that would be too big for an individual. Beware, though, teams are not easy to lead and you can easily make a project a disaster by just gathering as many people as you can. If you want to work with a team, come with a solid design and a strong vision of what the project should look like when it's finished. If other members of the team suggest new ideas, take them with consideration but do not fall in the feature-greed pitfall, e.g. your project is never finished because the final goal grows beyond all proportions.

## Console and GUI applications

A console application is a computer program designed to be used via a text-only computer interface, such as a text terminal, the command line interface of some operating systems (Unix, DOS, etc.) or the text-based interface included with most Graphical User Interface (GUI) operating systems, such as the Win32 console in Microsoft Windows, the Terminal in Mac OS X, and xterm in Unix. A user typically interacts with a console application using only a keyboard and display screen, as opposed to GUI applications, which normally require the use of a mouse or other pointing device. Many console applications such as command line interpreters are command line tools, but numerous text-based user interface (TUI) programs also exist.

![A Modern Terminal[^2]](img/Bash_screenshot.png)

[^2]: Source https://en.wikipedia.org/wiki/Graphical_user_interface

As the speed and ease-of-use of GUIs applications have improved over time, the use of console applications has greatly diminished, but not disappeared. Some users simply prefer console based applications, while some organizations still rely on existing console applications to handle key data processing tasks.

The ability to create console applications is kept as a feature of modern programming environments such as Visual Studio and the .NET Framework on Microsoft Windows because it greatly simplifies the learning process of a new programming language by removing the complexity of a graphical user interface (see an example in the C# article).

For data processing tasks and computer administration, these programming environments represent the next level of operating system or data processing control after scripting. If an application is only going to be run by the original programmer and/or a few colleagues, there may be no need for a pretty graphical user interface, leaving the application leaner, faster and easier to maintain.

![A Modern Graphical User Interface application[^3]](img/750px-E17_bw_screenshot.png)

[^3]: Source https://en.wikipedia.org/wiki/Graphical_user_interface
