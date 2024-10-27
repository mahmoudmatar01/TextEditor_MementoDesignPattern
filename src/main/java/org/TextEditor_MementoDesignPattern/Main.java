package org.TextEditor_MementoDesignPattern;

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
