# Chapter 14 - Exceptions

Exceptions (exceptional events) are problems that occur during the execution of an application, which disrupt the normal flow of the application's code. If the exception is not handled by the application code itself, the process terminates abnormally.

An exception can occur on many different occasions. Some common reasons are:

* A user has entered invalid data.
* A file that needs to be opened cannot be found.
* A network connection has been lost in the middle of communications.
* A number is being divided by zero.

Some of these exceptions are caused by user error, others by programmer error, and others by physical resources that have failed in some manner.

When such an exceptional event occurs, the method currently executing creates an **exception object** of a certain type. This object contains information about the exceptional event and the state of the application at the moment of the event. The process of creating this exception object and handing it to the runtime system is called **throwing an exception**.