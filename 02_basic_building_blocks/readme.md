---
description: This chapter introduces the necessary buildings blocks of every programming language. It also introduces flowcharts - a graphical way of representing application logic.
---

# Basic Building Blocks

Almost every programming language out there has a number of basic building blocks required to solve problems and build programs.

* **Variables** label memory locations where data is stored and allow for ease of access.
* **Operators** allow the manipulation of the data stored in memory.
* **Decision making** allows multiple paths of execution based on conditions.
* **Loop constructs** repeat certain operations a number of times.
* **Functions** allow functionality to be grouped so it can be easily reused.

More high-level programming languages introduce more advanced tools that allow a developer to create applications for more complex problems without making the application overly complex. Some common concepts are classes, inheritance, interfaces, multi-threading, collections, lambda-expressions, generics, ... Some of these will be introduced in the more advanced chapters of this course.

## Flowcharts

Flowcharts are **a structured graphical way to document process flow**. Flowcharts already exist since 1921 and were introduced by Frank and Lillian Gilbreth in the presentation "Process Charts: First Steps in Finding the One Best Way to do Work". The Gilbreths' tools quickly found their way into industrial engineering curricula. In the early 1930s, an industrial engineer, Allan H. Mogensen began to train business people in the use of some of the tools of industrial engineering.

Flowcharts allow developers to document algorithms, application logic, data flows, ... in a visual manner. Graphical representations have proven to be very useful in the software development world, even to people who don't know how to program.

Consider an example: a disco bar which has a bouncer at the door that checks if the person who wants to enter is over 18. If that person is 18 or older, he/she is allowed to enter. If not, he/she is politely asked to leave. The bouncer's process of elimination can be easily represented using a flowchart as shown below.

![Logic of a Disco Bouncer](img/flowchart_bouncer.png)

### Common used Symbols

A quick overview of the most common used symbols is given below.

A **terminal** indicates the start or ending of an application, sub-process, ... It is most often represented using a rounded (fillet) rectangle. They usually contain the word "Start" or "End", or another phrase signaling the start or end of a process.

![Terminal](img/flowchart_terminal.png)

A basic rectangle is used to represent a **process step**. This is an action or operation that changes a value, takes an internal action, ...

![Process step](img/flowchart_process_step.png)

The flow of operation is indicated using a **flowline**. This is a line connecting one symbol with another. While arrowheads are only required if the flow is not the standard top-to-bottom or left-to right, they are almost always added anyways.

![Flowlines](img/flowchart_arrows.png)

A parallelogram is known as a **data input/output** node. Input can come from the terminal (console) or another source. Output can for example be printing a text to the user via the terminal, or writing something to a file. Some developers don't bother to use the parallelogram shape and just use a standard rectangle.

![Data Input/Output](img/flowchart_input_output.png)

When multiple paths of execution can be taken based on a condition, a diamond is used to represent a **decision**. The operation is commonly a *yes/no* question or *true/false* test.

![Decision](img/flowchart_decision.png)

A **predefined process** shows a named process which is defined somewhere else. It is represented as a rectangle with double-struck vertical edges. The name of the predefined process is placed inside the inner rectangle bounds.

![Predefined Process](img/flowchart_predefined_process.png)

A **note** is used to clarify something in your flowchart. It can give a general description of the process or elaborate a certain action or part of your process. Use where needed. 

![Note](img/flowchart_note.png)

There are more flowchart symbols, but these are the ones you will need the most.

### Not a strict standard

Flowcharts are a bit of a free-for-all tool to document a process. This means that if you let 5 developers model a process using flowcharts, you will get 5 different flowcharts. They will all model the same process and use the same symbols but the actual implementation of the blocks will be different.

Take a quick look at the examples below. They all ask the user for his/her age and store it somewhere for later processing but the actual notations inside the symbols use different approaches.

![Asking the age of the user](img/flowchart_age_input.png)

One is not more correct than the other. They are just written from a different view of the process and each developer will need to make this out for himself. There are only two requirements: it should be informative and understandable. There is no use in creating documentation that makes things less clear.

## Variables

The base of almost any computer program is the manipulation of data. Of course before a program can manipulate data it needs to be able to store it. For this it can use the computer memory. This computer memory is accessed via **variables**. Variables are used to store information to be referenced and manipulated in a computer program. They also provide a way of labeling data with a descriptive name, so our programs can be understood more clearly by the reader and ourselves. It is helpful to think of variables as containers that hold information. Their sole purpose is to label and store data in memory. This data can then be used throughout your program.

{% hint style="tip" %}
**Definition of a variable**

A symbolic name associated with a value and whose associated value may be changed.
{% endhint %}

### Variables in Math

As a student you actually have already been using variables for quite a while. When doing math you also use symbolic names as variables. In the example below, `x`, `y` and `p` are all variables.

```text
x = 15
y = 13

p = x * y
```

Or when defining a linear equation

```text
y = f(x) = ax + b
```

### Using variables

Variables and the data they hold are used for all sorts of things. Producing new values based on the available data, making decisions, outputting information to the user, and so on.

Consider the bouncer example again from the start of this chapter:

![Logic of a Disco Bouncer](img/flowchart_bouncer.png)

Several pieces of information can be identified here which are probable stored in the memory of the computer and made available through variables:
* the age of the person at the door
* the minimum age
* the state of the door (open or closed)
* the current time
* the closing time

While not directly apparent, an application typically handles a lot of information via variables. This is the reason why variables are a basic building block of every programming language.

## Operators

Most programs will performs all sorts of operations on data they have at their disposal. We often say that **they process the data**. For this processing, a programming language needs **operators**. Many of the operators you will already be familiar with from Math.

While different programming languages use different operators, the most basic math operators are most often available. These are easy to understand because they have the same functionality as in math. The following operators are the most common ones to do basic math operations:

| Operator | Meaning |
| --- | --- |
| `=` | Assignment operator |
| `+` | Addition operator |
| `-` | Subtraction operator |
| `*` | Multiplication operator |
| `/` | Division operator |

### Body Mass Index example

Consider a small example application that calculates the BMI (Body Mass Index) of a person. This is a measure of body fat based on height and weight that applies to adult men and women. It is an attempt to quantify the amount of tissue mass (muscle, fat, and bone) in an individual, and then categorizes that person as underweight, normal weight, overweight, or obese based on that value.

The BMI is defined as the weight divided by the square of the body height, and is universally expressed in units of `kg/m2`, resulting from mass in kilograms and height in meters.

First one needs to identify the information required from the user:
* the weight of the person in kilograms
* the height of the person in meters

Next the BMI can be calculated using the formula `weight / (height * height)`, where `/` is the division operator and `()` are braces that group calculations just as in Math.

For this small program we would need at least three variables: `weight`, `height` and `bmi`.

This application could be modelled using the flowchart shown below:

![Flowchart of simple BMI application](img/flowchart_bmi_example.png)

## Decision Making

Computer programs often have different things to do based on a certain situation. At certain points in the code, a decision has to be made. This requires that a **decision making** construct is available.

This is also called **branching** (think about the branches of a tree). A branch is an instruction in a computer program that can cause a computer to begin executing a different instruction sequence and thus deviate from its default behavior of executing instructions in order.

A decision asks a question, more commonly referred to as the **condition**. The answer to the question determines which arrow you follow out of the decision shape. Always make sure to label the branch arrows coming from a decision.

Take a good look at the example below of a possible students evening routine. Take a note on the different decisions that are shown. Now you should understand where the term branching comes from.

![A Students Evening Routine](img/flowchart_evening_routine.png)

The arrows flowing from the decision shape are usually labeled with *Yes*, *No* or *True*, *False*. But you can label them any way you want as long as the meaning is clear.

At least two arrows should emerge from a decision symbol. If your choice is not binary, add more arrows as shown below.

![Decision with Multiple Branches](img/flowchart_decision_multiple_outcomes.png)

## Loop Constructs

Software is ideal for executing repetitive tasks (things that have to be done multiple times). To be able to do things multiple times a programming languages needs some sort **loop constructs**.

Programming languages often support multiple looping constructs, such as for loops, while loops, foreach loops, do-while loops, ... While these can all be modelled using flowcharts, we don't actually have to know them to be able to create a loop in a flowchart.

All we need is a condition in a flowchart that is checked. In one of the outcomes we loop again, in the other we quit the loop. Which outcome you use to quit the loop is up to you.

Take a look at the example below. Here the process consist of checking if the cat is hungry. If it is, we feed it a little and check again. If it's not or not anymore, we stop giving food.

![Is Cat Hungry?](img/flowchart_is_cat_hungry.png)

Notice how we first check if it is hungry before we give it food. Now take a look at another implementation where we first give it food and we check after it has eaten if we need to give more food. Basically the outcome is the same: the cat is fed. However the subtle difference here is that we may give food to a cat that was never hungry in the first place.

![Feed the Cat Nonetheless](img/flowchart_feed_the_cat.png)

The condition can also be a counter variable. The process below will output 10 random numbers for the user.

![Generate 10 Random Numbers](img/flowchart_generate_random_numbers.png)

## Functions

Every programming language lets you create **named blocks of code that perform a specific task** called **functions**. Using the name of the function can be **called** from other parts of the application. Calling a function is asking the compiler/interpreter to execute the code inside of the function.

Functions usually **take in data**, **process it**, and **return a result**. How the function does this is most of the time only important to the people that created the functions. Other programmers are often only interested in how to use the function and what the result will be. For this same reason, functions are often called **black-boxes**.

![Functions](img/function.png)

Ideally, a function performs a single, related action. Functions provide better modularity for your application and a high degree of code reusing.

Programming languages often have many built-in functions that can be used by the developer. On the other hand, as a developer you are also able to create your own functions.

{% hint style="tip" %}
**Definition of a function**

A function is a named **self contained** block of code that performs a specific task.
{% endhint %}

Based on the type of programming language, a distinction can be made between functions, sub-routines, procedures and methods. While each is a bit different they all have the same basic concept: a **self contained** entity of code that accomplish a specific task.

### Square Root function

A well-known example of a function is the square root math operation. Every programming language that supports math operations will have some sort of function readily available for you to calculate the square root of a value.

![Black Box Square Root Function](img/function_sqrt.png)

This example also proves the black box principle. While there are many algorithms available to determine the square root of a number, we as a user of the square root function don't care how the result is accomplished. Of course we need to know what inputs the function requires and what output it will generate.

### Functions in flowcharts

Functions in flowcharts are actually called **sub-processes**. Each sub-process is a named flowchart on itself that can be used from inside another (sub-)process. Inputs and outputs are of less importance when using or defining sub-processes in flowcharts. These are more language specific. Calling a sub-process is achieved by placing a rectangle with double-struck vertical edges with the name of the sub-process inside of it.

Take a look at the example flowchart below. It models a very simple guessing game. The game generates a random number between 0 and 1000. The user is asked to guess the number, while the game states if the user should guess higher or lower.

![Secret Number Guessing Game](img/secret_number_guessing_game.png)