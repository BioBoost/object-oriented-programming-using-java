## JavaFX Application Structure

In general, a JavaFX application will have three major components namely a **Stage**, **Scenes** and **Nodes** as shown in the following diagram.

![Basic Application Architecture](img/javafx-hierarchy.png)

The Stage is the main container which is usually a window with a border and the typical minimize, maximize and close buttons. Inside the Stage you add a Scene which can, of course, be switched out by another Scene. Inside the Scene the actual JavaFX nodes like AnchorPane, TextBox, Button, etc. are added.

A scene graph is a tree-like data structure (hierarchical) representing the contents of a scene. In contrast, a node is a visual/graphical object of a scene graph.

The diagram below shows an abstract example of a scene and its scene graph.

![A Simple JavaFX Scene](https://www.lucidchart.com/publicSegments/view/755ee6e2-8d01-4201-92b5-1f76b9801e0c/image.png)

The JavaFX Scene Graph API makes graphical user interfaces easier to create, especially when complex visual effects and transformations are involved. A scene graph is a tree data structure, most commonly found in graphical applications and libraries such as vector editing tools, 3D libraries, and video games. The JavaFX scene graph is a retained mode API, meaning that it maintains an internal model of all graphical objects in your application. At any given time, it knows what objects to display, what areas of the screen need repainting, and how to render it all in the most efficient manner. Instead of invoking primitive drawing methods directly, you instead use the scene graph API and let the system automatically handle the rendering details. This approach significantly reduces the amount of code that is needed in your application.

A single element in a scene graph is called a **node**. Each node has an
* **ID:** Each node in the scene graph can be given a unique id. This id is much like the "id" attribute of an HTML tag in that it is up to the designer and developer to ensure that the id is unique within the scene graph. The ID can be used to find a node within the scene graph, or within a subtree of the scene graph. The id can also be used identify nodes for applying styles.
* **Style class:** The style class can be used to style the node from CSS. The id and styleClass variables are used in CSS style sheets to identify nodes to which styles should be applied.
* **Bounding volume:** Every node has a geometric shape and it is positioned in a coordinate system. The size and the position of the node are collectively knows as its bound. The bound of a node are defined in terms of a bounding rectangular box that closes the entire geometry of the node.

A node may include:

* **Geometrical (Graphical) objects (2D and 3D)** such as Circle, Rectangle, Polygon, etc.
* **UI Controls** such as Button, Checkbox, Choice Box, Text Area, etc.
* **Containers** (Layout Panes) such as Border Pane, Grid Pane, Flow Pane, etc.
* **Media elements** such as Audio, Video and Image Objects.

The Node Class represents a node in JavaFX. This class is the super class of all other above mentioned types of nodes.
