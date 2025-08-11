import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Game {
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    JButton restart,exit;
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;
    int turns = 0; 
    
    Game() {
        frame.setVisible(true);
        frame.setSize(800,850);
       frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
        restart = new JButton("Restart");
        restart.setBounds(200, 680, 200, 90);
        frame.add(restart);
        restart.setBackground(Color.GRAY);
        restart.setForeground(Color.WHITE);
        restart.setFont(new Font("Arrial",2, 40));
        exit  = new JButton("Exit");
        exit.setBounds(550, 680, 200, 90);
        frame.add(exit);
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Arrial",2, 40));
        boardPanel.setLayout(new GridLayout(4, 4));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                // tile.setText(currentPlayer);
               exit.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       System.exit(0);
                   }
               });
               restart.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       gameOver = false;
                       turns = 0;
                       currentPlayer = playerX;
                       textLabel.setText("Tic-Tac-Toe");
                       for (int r = 0; r < 3; r++) {
                           for (int c = 0; c < 3; c++) {
                                        board[r][c].setText("");
                                           board[r][c].setForeground(Color.WHITE);
                                           board[r][c].setBackground(Color.DARK_GRAY);
                                       }
                                   }
                               }


               });
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText() == "") {
                            tile.setText(currentPlayer);
                            turns++;
                            //checkWinner();
                            if (!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s turn.");
                            }
                        }

                    }
                });
            }
        }
    }


 public static void main(String[] args) throws Exception {
             Game ticTacToe = new Game();
         }
 }

