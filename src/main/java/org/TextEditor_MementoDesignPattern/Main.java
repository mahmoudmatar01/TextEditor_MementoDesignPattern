package org.TextEditor_MementoDesignPattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // create a new TextEditor instance
        TextEditor textEditor = new TextEditor();

        textEditor.setContent("Hello, ");
        textEditor.save();

        textEditor.setContent("World!");
        textEditor.save();

        textEditor.setContent("Welcome to memento design patter"); // content = Welcome to memento design patter
        textEditor.undo();  // content = World!
        textEditor.undo();  // content = Hello,
        textEditor.redo();  // content = World!

        System.out.println(textEditor.getContent());
    }
}