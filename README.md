# TextEditor_MementoDesignPattern

This project demonstrates the **Memento Design Pattern** in a text editor application, allowing the user to undo and redo changes to the text content. This design pattern is particularly useful in applications that need to manage a history of states, such as text editors or document processors.

## Project Structure

The project contains the following classes:

1. **TextEditor**
   - Represents a simple text editor with content stored as a `String`.
   - Includes a `save` method that captures the current state in a `TextEditorState` object (acting as a memento).
   - A `restore` method allows the editor to revert to a previously saved state.

2. **TextEditorState**
   - Acts as the memento that holds a snapshot of the `TextEditor` content.
   - Provides a getter to retrieve the stored content when restoring a previous state.

3. **History**
   - Manages the history of `TextEditorState` objects using two stacks (`prevState` and `nextState`) to implement undo and redo functionality.
   - `saveHistoryState` saves a new state to the `prevState` stack, enabling reversal of changes.
   - `undo` reverts the content to the last saved state by moving it from `prevState` to `nextState`.
   - `redo` restores the content to the most recent undone state by moving it back from `nextState` to `prevState`.

4. **Main**
   - Demonstrates the usage of `TextEditor` and `History` classes.
   - Shows how to set text, save states, and perform undo and redo operations.
   - Outputs the final content to confirm the memento pattern's effect.

## How It Works

1. **Initial Setup**:
   - A `TextEditor` object is initialized with content.
   - Each change in content is saved to the `History` stack for potential undo/redo actions.

2. **State Modifications**:
   - Text content is modified and saved at different points, allowing restoration to any saved version using undo/redo operations.

3. **Undo and Redo Operations**:
   - The program performs multiple undo actions to revert to earlier states.
   - Redo restores a previous state that was undone, demonstrating the memento pattern's capabilities.

## Usage

### Setup

1. Clone the repository and import it into your Java IDE.
2. Compile and run the `Main` class to see the Memento Design Pattern in action.

### Example Code

Here’s an example code snippet demonstrating the system:

```java
public class Main {
    public static void main(String[] args) {

        // Create a new TextEditor instance
        TextEditor textEditor = new TextEditor();
        History history = new History();

        // Set content and save states
        textEditor.setContent("Hello, ");
        history.saveHistoryState(textEditor.save());

        textEditor.setContent("World!");
        history.saveHistoryState(textEditor.save());

        textEditor.setContent("Welcome to memento design pattern");
        history.saveHistoryState(textEditor.save());

        textEditor.setContent("This is will n't print out");
        history.saveHistoryState(textEditor.save());

        // Undo operations
        textEditor.restore(history.undo()); // content = "Welcome to memento design pattern"
        textEditor.restore(history.undo()); // content = "World!"

        // Redo operation
        textEditor.restore(history.redo()); // content = "Welcome to memento design pattern"

        System.out.println(textEditor.getContent()); // Expected output: Welcome to memento design pattern
    }
}
```

### Sample Output

```plaintext
Welcome to memento design pattern
