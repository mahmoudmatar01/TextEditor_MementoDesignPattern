package org.TextEditor_MementoDesignPattern;


public class TextEditor {

    private String content;

    public TextEditor() {
        this.content = "";
    }

    // helper method
    public TextEditorState save(){
        return new TextEditorState(content);
    }

   public void restore(TextEditorState textEditorState){
        content = textEditorState.getContent();
   }

    // getter and setter methods
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

