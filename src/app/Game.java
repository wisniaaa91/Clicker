package app;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class Game implements ActionListener{
    
    JFrame gameFrame;
    int counter = 0;
    JButton clickButton;
    JButton resetButton;
    JLabel gameScore;
    int score;

    public void init(){
        //Create and set up the window.
        gameFrame = new JFrame("Clicker");
        gameFrame.setSize(500, 700);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a buttons.
        clickButton = new JButton("CLICK HERE TO GET SCORE");
        resetButton = new JButton("Reset Game");
        clickButton.setSize(300, 30);

        //Add actionListener to button.
        clickButton.addActionListener(this);
        resetButton.addActionListener(new ResetGameActionListener());

        //Add top label
        JLabel topLabel = new JLabel("Score: ");
        JPanel topPanel = new JPanel();
        topPanel.add(topLabel);
        gameFrame.getContentPane().add(BorderLayout.NORTH, topPanel);

        //Load score from last sesion.
        loadGame();

        //Add label with show score.
        gameScore = new JLabel(String.valueOf(counter));
        JPanel gameScorePanel = new JPanel();
        gameScorePanel.add(gameScore);
        gameFrame.getContentPane().add(BorderLayout.CENTER, gameScorePanel);

        //Place button on the buttom of game window.
        gameFrame.getContentPane().add(BorderLayout.SOUTH, clickButton);
        gameFrame.getContentPane().add(BorderLayout.WEST, resetButton);

        //Display the window.
        gameFrame.setVisible(true);
    }

    //Save score method to the file.
    public void saveGame(){
        try{
            File saveFile = new File("save.bin");
            FileWriter fileWriter = new FileWriter(saveFile);
            fileWriter.write(score);
            fileWriter.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //Load score method from the file.
    public void loadGame(){
        try{
            File loadFile = new File("save.bin");
            FileReader fileReader = new FileReader(loadFile);
            counter = fileReader.read();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void resetGame(){
        counter = 0;
        gameScore.setText(String.valueOf(counter));
        saveGame();
    }
    public class ResetGameActionListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            resetGame();
        }
    }

    public void actionPerformed(ActionEvent arg0) {
        counter++;
        clickButton.setText("click");
        gameScore.setText(String.valueOf(counter));
        score = counter;
        saveGame();
    }
}