A **minimal** version of the classic XO (Tic-Tac-Toe) game — this project focuses only on:
- Checking **who wins**
- Showing the result **at the top** of the screen

---

##  Features
-  Checks **rows, columns, and diagonals** for a winner  
-  Detects **Draw** when the board is full  
-  Displays result clearly at the top of the window/console  
-  Lightweight and easy to integrate into a full game

---

## 🛠 Code Example
Here’s the **Java** method that checks the winner:

```java
public String checkWinner(String[][] board) {
    // Check rows
    for (int i = 0; i < 3; i++) {
        if (!board[i][0].isEmpty() && 
            board[i][0].equals(board[i][1]) && 
            board[i][1].equals(board[i][2])) {
            return board[i][0] + " Wins!";
        }
    }

    // Check columns
    for (int i = 0; i < 3; i++) {
        if (!board[0][i].isEmpty() && 
            board[0][i].equals(board[1][i]) && 
            board[1][i].equals(board[2][i])) {
            return board[0][i] + " Wins!";
        }
    }

    // Check diagonals
    if (!board[0][0].isEmpty() && 
        board[0][0].equals(board[1][1]) && 
        board[1][1].equals(board[2][2])) {
        return board[0][0] + " Wins!";
    }
    if (!board[0][2].isEmpty() && 
        board[0][2].equals(board[1][1]) && 
        board[1][1].equals(board[2][0])) {
        return board[0][2] + " Wins!";
    }

    // Check for draw
    boolean full = true;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j].isEmpty()) {
                full = false;
                break;
            }
        }
    }
    if (full) return "Draw";

    return ""; // No winner yet
}
## Usage
Integrate checkWinner() into your game loop:

String result = checkWinner(board);
if (!result.isEmpty()) {
    displayOnTop(result); // Your method to show result at top
}
