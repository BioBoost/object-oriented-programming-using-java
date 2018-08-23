## Flowcharts

Flowcharts are **a structured graphical way to document process flow**. Flowcharts already exists since 1921 and were introduced by Frank and Lillian Gilbreth in the presentation "Process Charts: First Steps in Finding the One Best Way to do Work". The Gilbreths' tools quickly found their way into industrial engineering curricula. In the early 1930s, an industrial engineer, Allan H. Mogensen began to train business people in the use of some of the tools of industrial engineering.

Flowcharts allow developers to document algorithms, application logic, data flows, ... in a visual manner. Graphical representations have proven to be very useful in the software development world, even to people who don't know how to program.

Consider an example: a disco bar which has a bouncer at the door that checks if the person who wants to enter is over 18. If that person is 18 or older, he/she is allowed to enter. If not, he/she is politely asked to leave. The bouncer's process of elimination can be easily represented using a flowchart as shown below.

![Logic of a Disco Bouncer](img/flowchart_bouncer.png)

### Common used Symbols

A quick overview of the most common used symbols is given below. They will be discussed in more detail later in this chapter.

A **terminal** indicates the start or ending of an application, sub-process, ... It is most often represented using a rounded (fillet) rectangle. They usually contain the word "Start" or "End", or another phrase signaling the start or end of a process.

![Terminal](img/flowchart_terminal.png)

A basic rectangle is used to represent a **process step**. This is an action or operation that changes a value, outputs something to the user, ...

![Process step](img/flowchart_process.png)

The flow of operation is indicated using a **flowline**. This is a line connecting one symbol with another. While arrowheads are only required if the flow is not the standard top-to-bottom or left-to right, they are almost always added anyways.

![Flowlines](img/flowchart_arrows.png)

When multiple path of execution can be taken based on a condition, a diamond is used to represent a **decision**. The operation is commonly a *yes/no* question or *true/false* test.

![Decision](img/flowchart_decision.png)

A **predefined process** shows a named process which is defined somewhere else. It is represented as a rectangle with double-struck vertical edges. The name of the predefiness process is placed inside the inner rectangle bounds.

![Predefined Process](img/flowchart_predefined_process.png)

A **note** is used to clarify something in your flowchart. It can give a general description of the process or elaborate a certain action or part of your process. Use where needed. 

![Note](img/flowchart_note.png)

### Not a strict standard

Flowcharts are a bit of a free-for-all tool to document a process. This means that if you let 5 developers model a process using flowcharts, you will get 5 different flowcharts. They will all model the same process and use the same symbols but the actual implementation of the blocks will be different.

Take a quick look at the examples below. They all ask the user for his/her age and store it somewhere for later processing but the actual notations inside the symbols use different approaches.

![Asking the age of the user](img/flowchar_age_input.png)

One is not more correct than the other. They are just written from a different view of the process and each developer will need to make this out for himself. There are only two requirements: it should be informative and understandable. There is no use in creating documentation that makes things less clear.