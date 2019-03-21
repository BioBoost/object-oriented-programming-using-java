---
description: This chapter introduces the MQTT protocol, often used in the context of IoT.
---

# Chapter 30 - Hands on MQTT

MQTT, short for **Message Queuing Telemetry Transport** is actually a machine-to-machine (M2M) connectivity protocol. It was designed as an extremely **lightweight publish/subscribe messaging protocol**. It is useful for connections with remote locations where a small code footprint is required and/or network bandwidth is limited. It is also ideal for mobile applications because of its small size, low power usage, minimized data packets, and efficient distribution of information to one or many receivers (more...). Basically MQTT is one of pillars of the Internet of Things.

<!-- TODO: Add a nice overview image here ! -->

This chapter is currently linking to MQTT Essentials by HiveMQ [https://www.hivemq.com/mqtt-essentials/](https://www.hivemq.com/mqtt-essentials/).

## Simple MQTT Client Library

To start using the `SimpleMQTTClient` class, you first need to add the library as a dependency to your project.

Do this by first adding the JitPack repositories to your `pom.xml` file:

```xml
<project>
  ...
  <repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
  </repositories>
```

and then by adding the library itself as a dependency to the same `pom.xml` file.

```xml
<project>
  ...
  <dependencies>
    ...
    <dependency>
        <groupId>com.github.BioBoost</groupId>
        <artifactId>java_simple_mqtt_client</artifactId>
        <version>0.1.2</version>
    </dependency>
```

Now you should be able to import the classes into your application:

```java
import be.biosplanet.bioboost.mqtt.simple_mqtt_client.*;
```

### A Simple MQTT Client

The UML class diagram of the `SimpleMQTTClient` class is shown below:

![UML Class Diagram of SimpleMQTTClient](./img/simple_mqtt_client.png)

To create a SimpleMQTTClient object, you can use any of the given contructors. The ones without a `broker` will automatically connect to `mqtt.labict.be`.

For example using the default constructor:

```java
SimpleMQTTClient client = new SimpleMQTTClient();
```

From this point on messages can be easily published to a given topic:

```java
client.publish("test/oop2/hello_world", "Hello world from Java");
  // Topic: "test/oop2/hello_world"
  // Message: "Hello world from Java"
```

### A Message Handler Interface

When subscribing to a topic, the client needs to know where to redirect the received messages. This is handled using an interface called `IMQTTMessageHandler`. Implementing the `messageArrived` method in your own classes, allows your objects to be registered as message receivers.

You can pass an object of a class that implements the `IMQTTMessageHandler` explicitly, for example an `FXMLController`:

```java
public class FXMLController implements Initializable, IMQTTMessageHandler {
  // ...

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    client.subscribe("test/oop2/bug/health", this);
  }

  @Override
  public void messageArrived(String topic, String message) {
    System.out.println("Received message " + message + " on topic " + topic);
  }
}
```

Or you can use an anonymous inner class object:

```java
client.subscribe("test/oop2/hello_world", new IMQTTMessageHandler() {
  @Override
  public void messageArrived(String topic, String message) {
    System.out.println("Received message " + message + " on topic " + topic);
  }
});
```