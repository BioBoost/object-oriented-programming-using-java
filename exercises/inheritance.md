## Exercises on Inheritance

### Shape

Create a UML diagram and Java implementation for the following requirements. Make use
of inheritance or composition as required.

First model the following 2D shapes:

* square which has an property side to specify the size of its sides
* triangle which has a height and a base (width)
* circle which has a radius

All these shapes should also have an origin property which specifies a reference point
inside the 2D coordinate system.
Make sure all classes have at least one constructor to build the objects.

Next model the following 3D shapes:

* a cilinder which has a circle at its base and a height to make it 3D
* a beam which has a square at its base and a height to make it 3D
* a tri-beam (or whatever you call it) which has a triangle at its base and a height to make it 3D.

Now you should be able to easily add a method `calculateArea()` to the 2D shapes. Also add
`calculateVolume()` to the 3D shapes. This should be possible using 2 lines of code.

An important hint can be that you will need to make your 2D superclass abstract as the `calculateArea()` method
will make it abstract.
