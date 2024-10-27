package org.TextEditor_MementoDesignPattern;

import java.util.Stack;

public class TextEditor {

    private String content;
    private final Stack<String> previousState;
    private final Stack<String> nextState;

    // constructor for initialization fields
    public TextEditor() {
        this.content="";
        this.previousState = new Stack<>();
        this.nextState = new Stack<>();
    }

    // getter and setter methods

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // helper method
    public void save(){
        previousState.push(content);
        nextState.clear();
    }

    public String undo(){
        if(!previousState.isEmpty()){
            nextState.push(content);
            content=previousState.pop();
            return content;
        }
        return null;
    }

    public String redo(){
        if(!nextState.isEmpty()){
            previousState.push(content);
            content=nextState.pop();
            return content;
        }
        return null;
    }
}

