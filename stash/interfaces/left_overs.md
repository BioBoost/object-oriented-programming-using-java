












## Driving car example
Mark brings up a good point. Interfaces don't do anything at all, but instead define what behaviors happen. And, he also brings up a good point about not wanting to confuse the audience. Not that it's okay to confuse seasoned developers, but it's definitely not a good idea to confuse a brand new student. In light of this, I'm revising my one-liner into a many-liner.

"Where classes define existence, interfaces define behavior. Classes define what something is, while interfaces define what something does. So I might have a car, and it has things like an Engine, how much gas it has, what it's historic MPG is, and the like, but I would never go "carring". I might, on the other hand, go Driving... can my Car drive? It can if I give it a Drive method. I can also have "Driveable" interface with a drive method, and leave it up to the car to determine what driving really means. Now, if I only have cars it's not a big deal to have an interface. But what about trucks? If they both are Drivable, I can simply have a List<Drivable for both of them. Of course, the observant student says "Why can't Car and Truck both simply extend Vehicle, with an abstract Drive method?" Which, actually is a very valid notion. But, what about the Space Shuttle? Very few of the components between Car and Truck apply to the Space Shuttle, so it doesn't seem well suited to extend the Vehicle class. Or what about future cars? We have no idea what they might be like, they might not have chassises, they might just be bubbles of energy that move us around, but we might still call their behavior drive()."

breathes

Now that paragraph/essay is a little verbose, but I could see, with some slides or a chalkboard, being effective for first year students to get their head around (assuming they understand abstract classes first anyway).



## Home entertainment

In explaining interfaces and object oriented concepts in general to non-programmers, I always use the home entertainment system analogy.

The DVD player, TV, Cable Box, Remote Control are all objects that encapsulate complicated and sophisticated functionality. However, they have interfaces to each other and to the Humans that operate them that largely hide the lion share of that complexity.

The video in jack of a TV is an interface that is implemented by the DVD player and the cable box and a number of other types of devices.

I suspect it would be possible and perhaps an educational exercise for a student to describe their own home entertainment system entirely using Java code.

## Paintable example

If you are trying to explain it to beginners I would stick with the idea that interfaces can promote code reuse and modularity within the code:

For example lets say we are going to paint some objects:

public class Painter {
    private List<Paintable> paintableObjects;

    public Painter(){
       paintableObjects = new ArrayList<Paintable>();
    }

    public void paintAllObjects(){
        for(Paintable paintable : paintableObjects){
            paintable.paint();
        }
    }
}

public interface Paintable {
     public void paint();
}
Now you could explain to the students that without Paintable interface the Painter object would need to have methods to paint certain types of objects, like a method called paintFences() and paintRocks() and we would need to have a new Collection for each type of objects we want the painter to be able to paint.

But thankfully we have interfaces which make painting objects a breeze and how objects are painted is left entirely up to classes that implement the Paintable interface.

EDIT

Another benefit that I forgot to mention is that if you ever need to add new object to paint to your code base, all you need to do is create a new class that implements Paintable and the Painter class never has to change. In this sense the Painter class is never dependent upon the objects it is going to paint, it only needs to be able to paint them.

EDIT 2

James Raybould reminded me of a key use of interfaces I forgot to mention: Having an interface between your components, like the Paintable objects and Painter objects, allows you to more easily develop with other people. One developer can work on the Painter objects and another can work on the Paintable objects and all they have to do to function properly together is define a common interface beforehand that they will both use. I know when I've worked on projects with other people in college level projects its really helpful when you are trying to have everyone work on different parts of the project and still have all components come together nicely in the end.
