[Introduction](../../hands_on/gson/readme.md)
* [Step 1 - Adding Gson Dependency](../../hands_on/gson/step_1_adding_gson_dependency.md)
* [Step 2 - Simple Object Serialization](../../hands_on/gson/step_2_simple_object_serialization.md)
* [Step 3 - Deserialization of a Motorcycle](../../hands_on/gson/step_3_deserialization_motorcycle.md)
* [Step 4 - Composition](../../hands_on/gson/step_4_composition.md)

# Hands-on - gson

Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.

There are a few open-source projects that can convert Java objects to JSON. However, most of them require that you place Java annotations in your classes; something that you can not do if you do not have access to the source-code. Most also do not fully support the use of Java Generics. Gson considers both of these as very important design goals.

Gson Goals:
* Provide simple `toJson()` and `fromJson()` methods to convert Java objects to JSON and vice-versa
* Allow pre-existing unmodifiable objects to be converted to and from JSON
* Extensive support of Java Generics
* Allow custom representations for objects
* Support arbitrarily complex objects (with deep inheritance hierarchies and extensive use of generic types)
