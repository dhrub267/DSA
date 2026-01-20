// class Solution {
//     public void append(char x) {
//         // append x into document
//     }

//     public void undo() {
//         // undo last change
//     }

//     public void redo() {
//         // redo changes
//     }

//     public String read() {
//         // read the document
//     }
// }


import java.util.*;

class Solution {

    StringBuilder doc = new StringBuilder();
    Stack<Character> undoStack = new Stack<>();
    Stack<Character> redoStack = new Stack<>();

    public void append(char x) {
        doc.append(x);
        undoStack.push(x);
        redoStack.clear(); // new operation clears redo history
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            char ch = undoStack.pop();
            doc.deleteCharAt(doc.length() - 1);
            redoStack.push(ch);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            char ch = redoStack.pop();
            doc.append(ch);
            undoStack.push(ch);
        }
    }

    public String read() {
        return doc.toString();
    }
}
