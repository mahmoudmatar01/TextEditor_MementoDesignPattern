package org.TextEditor_MementoDesignPattern;
import java.util.Stack;

public class History {

    private final Stack<TextEditorState> prevState;
    private final Stack<TextEditorState> nextState;

    public History() {
        this.prevState = new Stack<>();
        this.nextState = new Stack<>();
    }

    public void saveHistoryState(TextEditorState textEditorState) {
            prevState.push(textEditorState);
            nextState.clear();
    }

    public TextEditorState undo() {
        if (!prevState.isEmpty()) {
            TextEditorState currentState = prevState.pop();
            nextState.push(currentState);
            return currentState;
        }
        return null;
    }

    public TextEditorState redo() {
        if (!nextState.isEmpty()) {
            TextEditorState state = nextState.pop();
            prevState.push(state);
            return state;
        }
        return null;
    }
}
