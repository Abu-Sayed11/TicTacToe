package com.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    private JPanel panel,board;
    String letter = "";
    int count = 0;
    private JLabel label;
    JButton resetButton;
    JButton[] button = new JButton[9];
    boolean win = false;

    public TicTacToe(){
        JFrame frame = new JFrame("tictactoe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,350);
        label = new JLabel("");
        board = new JPanel(new GridLayout(3,3));
        for( int i=0; i<9; i++ ){
            button[i] = new JButton("");
            button[i].setEnabled(true);
            button[i].setBackground(Color.white);
            button[i].setBorder(BorderFactory.createLineBorder(Color.RED));
            button[i].addActionListener(this);
            board.add(button[i]);
        }
        frame.add(board,BorderLayout.CENTER);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        panel = new JPanel(new FlowLayout());
        panel.add(resetButton);
        panel.add(label);
        frame.add(panel,BorderLayout.SOUTH);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        if(count == 1 || count == 3 || count == 5 || count == 7 || count == 9){
            letter = "x";
        }else if(count == 2 || count == 4 || count == 6 || count == 8 ){
            letter = "o";
        }
        if(e.getSource() == button[0]){
            button[0].setText(letter);
            button[0].setEnabled(false);
        }else if(e.getSource() == button[1]){
            button[1].setText(letter);
            button[1].setEnabled(false);
        }else if(e.getSource() == button[2]){
            button[2].setText(letter);
            button[2].setEnabled(false);
        }else if(e.getSource() == button[3]){
            button[3].setText(letter);
            button[3].setEnabled(false);
        }else if(e.getSource() == button[4]){
            button[4].setText(letter);
            button[4].setEnabled(false);
        }else if(e.getSource() == button[5]){
            button[5].setText(letter);
            button[5].setEnabled(false);
        }else if(e.getSource() == button[6]){
            button[6].setText(letter);
            button[6].setEnabled(false);
        }else if(e.getSource() == button[7]){
            button[7].setText(letter);
            button[7].setEnabled(false);
        }else if(e.getSource() == button[8]){
            button[8].setText(letter);
            button[8].setEnabled(false);
        }else if(e.getSource() == resetButton){
            letter = "";
            count = 0;
            for( int i =0; i<9; i++ ){
                button[i].setEnabled(true);
                button[i].setText(letter);
            }
            label.setText("");
            win = false;
        }
        checkWinner();
    }
    private void checkWinner(){
        if(button[0].getText() == button[1].getText() &&
                button[1].getText() == button[2].getText() &&
                button[0].getText() !="" &&
                button[1].getText() != "" &&
                button[2].getText() != "")
        {
            win = true;
        }else if((button[3].getText() == button[4].getText() &&
                button[4].getText() == button[5].getText() &&
                button[3].getText() != "" &&
                button[4].getText() != "" &&
                button[5].getText() != ""))
        {
            win = true;
        }else if(button[6].getText() == button[7].getText() &&
                button[7].getText() == button[8].getText() &&
                button[6].getText() != "" &&
                button[7].getText() != "" &&
                button[8].getText() != "")
        {
            win = true;
        }
        else if(button[0].getText() == button[3].getText() &&
                button[3].getText() == button[6].getText() &&
                button[0].getText() != "" &&
                button[3].getText() != "" &&
                button[6].getText() != "")
        {
            win = true;
        }else if(button[0].getText() == button[3].getText() &&
                button[3].getText() == button[6].getText() &&
                button[0].getText() != "" &&
                button[3].getText() != "" &&
                button[6].getText() != "")
        {
            win = true;
        }else if(button[2].getText() == button[5].getText() &&
                button[5].getText() == button[8].getText() &&
                button[2].getText() != "" &&
                button[5].getText() != "" &&
                button[8].getText() != "")
        {
            win = true;
        } else if(button[0].getText() == button[4].getText() &&
                button[4].getText() == button[8].getText() &&
                button[0].getText() != "" &&
                button[4].getText() != "" &&
                button[8].getText() != "")
        {
            win = true;
        }else if(button[2].getText() == button[4].getText() &&
                button[4].getText() == button[6].getText() &&
                button[2].getText() !="" &&
                button[4].getText() != ""&&
                button[6].getText() != ""){
            win = true;
        }else{
            win = false;
        }
        if(win){
            label.setText("Hurray ! Player " + letter + " Win");
            for (int i = 0;i<9; i++){
                button[i].setEnabled(false);
            }
        }else if(!win && count == 9){
            label.setText("The game is tie.");
            for (int i = 0 ; i<9 ; i++){
                button[i].setEnabled(false);
            }
        }
    }
}
