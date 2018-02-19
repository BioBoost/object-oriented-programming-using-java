## Cascading Style Sheets

Never has styling a Java UI been easier than with JavaFX and **Cascading Style Sheets (CSS)**. Going from one theme to another, or customizing the look of just one control, can all be done through CSS.

### CSS and the JavaFX Scene Graph

JavaFX Cascading Style Sheets (CSS) is based on the W3C CSS version 2.1 with some additions from current work on version 3. JavaFX CSS also has some extensions to CSS in support of specific JavaFX features. The goal for JavaFX CSS is to allow web developers already familiar with CSS for HTML to use CSS to customize and develop themes for JavaFX controls and scene‑graph objects in a natural way.

To the extent possible, JavaFX CSS follows the W3C standards; however, with few exceptions, JavaFX property names have been prefixed with a vendor extension of `-fx-`. Even if these properties seem to be compatible with standard HTML CSS, JavaFX CSS processing assumes that the property values make use of JavaFX CSS extensions.

CSS styles are applied to nodes in the JavaFX scene‑graph in a way similar to the way CSS styles are applied to elements in the HTML DOM. Styles are first applied to the parent, then to its children. The code is written such that only those branches of the scene‑graph that might need CSS reapplied are visited. A node is styled after it is added to the scene graph. Styles are reapplied when there is a change to the node's pseudo‑class state, style‑class, id, inline style, or parent, or stylesheets are added to or removed from the scene. Note that the Node must be in the scene‑graph for CSS to be applied. The Node does not have to be shown, but must have a non‑null value for its sceneProperty.

During a normal scene‑graph pulse, CSS styles are applied before the scene‑graph is laid out and painted.

CSS selectors are used to match styles to scene‑graph nodes. The relationship of a Node to a CSS selector is as follows:

Each node in the scene‑graph has a styleClass property. Note that a node may have more than one style‑class. A Node's styleClass is analogous to the class="..." attribute that can appear on HTML elements.

Each node in the scene‑graph has an id variable, a string. This is analogous to the id="..." attribute that can appear HTML elements.

JavaFX CSS also supports pseudo‑classes, but does not implement the full range of pseudo‑classes.

More information can be found at [https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html](https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html).
