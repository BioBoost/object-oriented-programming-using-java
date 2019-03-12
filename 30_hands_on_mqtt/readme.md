---
description: This chapter introduces the MQTT protocol, often used in the context of IoT.
---

# Chapter 30 - Hands on MQTT

MQTT, short for **Message Queuing Telemetry Transport** is actually a machine-to-machine (M2M) connectivity protocol. It was designed as an extremely **lightweight publish/subscribe messaging protocol**. It is useful for connections with remote locations where a small code footprint is required and/or network bandwidth is limited. It is also ideal for mobile applications because of its small size, low power usage, minimized data packets, and efficient distribution of information to one or many receivers (more...). Basically MQTT is one of pillars of the Internet of Things.

<!-- TODO: Add a nice overview image here ! -->

This chapter is currently linking to MQTT Essentials by HiveMQ [https://www.hivemq.com/mqtt-essentials/](https://www.hivemq.com/mqtt-essentials/).

## Simple MQTT Client Library

Not finished yet. Requires more documentation and Java files should be placed inside of library.

### A Simple MQTT Client

Place the following code in a file called `SimpleMQTTClient.java`. Make sure to change the package declaration to suit your own project.

```java
package be.vives.bug.javafx.mqtt;

import java.util.HashMap;
import java.util.Random;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class SimpleMQTTClient implements MqttCallback {
    private MqttClient client;
    private String broker = "tcp://mqtt.labict.be:1883";
    private String clientId;
    private int qos = 2;            // Exactly once
    private MemoryPersistence persistence;
    private MqttConnectOptions connectionOptions;
    private HashMap<String, IMQTTMessageHandler> subscriptions;

    public SimpleMQTTClient(String clientId) {
      subscriptions = new HashMap<>();
      Random random = new Random();
      this.clientId = clientId + random.nextInt();
      setupMqtt();
    }

    public SimpleMQTTClient() {
      this("guest");
    }

    private void setupMqtt() {
      try {
        persistence = new MemoryPersistence();
        client = new MqttClient(broker, clientId, persistence);
        connectionOptions = new MqttConnectOptions();
        connectionOptions.setCleanSession(true);
        client.connect(connectionOptions);
        client.setCallback(this);
      } catch(MqttException me) {
        System.out.println("Failed to connect to broker");
        System.out.println("reason " + me.getReasonCode());
        System.out.println("msg " + me.getMessage());
        System.out.println("loc " + me.getLocalizedMessage());
        System.out.println("cause " + me.getCause());
        System.out.println("excep " + me);
        me.printStackTrace();
      }
    }

    public void publish(String message, String topic) {
      try {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(qos);
        client.publish(topic, mqttMessage);
      } catch (MqttException me) {
        System.out.println("Failed to publish message");
        System.out.println(me);
      }
    }

    public void subscribe(String topic, IMQTTMessageHandler handler) {
      try {
        client.subscribe(topic);
        subscriptions.put(topic, handler);
      } catch(MqttException me) {
        System.out.println("Failed to connect to broker");
        System.out.println("reason " + me.getReasonCode());
        System.out.println("msg " + me.getMessage());
        System.out.println("loc " + me.getLocalizedMessage());
        System.out.println("cause " + me.getCause());
        System.out.println("excep " + me);
        me.printStackTrace();
      }
    }

    public void disconnect() {
      try {
        client.disconnect();
        client.close();
      } catch (MqttException me) {
        System.out.println("Failed to disconnect");
        System.out.println(me);
      }
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
      System.out.println("Lost connection with broker");
    }

    @Override
    public void messageArrived(String topic, MqttMessage mm) throws Exception {
      IMQTTMessageHandler handler = subscriptions.get(topic);
      if (handler != null) {
        handler.messageArrived(topic, mm.toString());
      } else {
        System.out.println("No handler for topic " + topic);
      }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
    }
}
```

### A Message Handler Interface

Place the following code in a file called `IMQTTMessageHandler.java`. Make sure to change the package declaration to suit your own project.

```java
package be.vives.bug.javafx.mqtt;

/**
 *
 * @author BioBoost
 */
public interface IMQTTMessageHandler {
    public void messageArrived(String topic, String message);
}
```

### Usage

Now you can create a new MQTT client:

```java
SimpleMQTTClient client = new SimpleMQTTClient();
```

Publishing messages to a topic:

```java
client.publish("Hello world from Java", "test/oop2/hello_world");
  // Message: "Hello world from Java"
  // Topic: "test/oop2/hello_world"
```

Subscribing to incoming messages from a topic:

```java
client.subscribe("test/oop2/incoming", new IMQTTMessageHandler(){
  @Override
  public void messageArrived(String topic, String message) {
    System.out.println("Received message " + message + " on topic " + topic);
  }
});
```