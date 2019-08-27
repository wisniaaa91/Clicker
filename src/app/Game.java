package app;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class Game{
    
    JFrame gameFrame;
    int counter = 0;
    JButton clickButton;
    JButton resetButton;
    JLabel gameScore;
    int score;
    JPanel gameScorePanel;

    public void init(){
        //Create and set up the window.
        gameFrame = new JFrame("Clicker");
        gameFrame.setSize(500, 700);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a buttons.
        clickButton = new JButton("CLICK HERE TO GET SCORE");
        resetButton = new JButton("Reset Game");

        //Set size for buttons
        clickButton.setSize(300, 100);
        resetButton.setSize(100, 300);
        
        //Add panel for Click button.
        JPanel clickButtonPanel = new JPanel();
        clickButtonPanel.add(clickButton);
        
        //Add panel for Reset button
        JPanel resetButtonPanel = new JPanel();
        resetButtonPanel.add(resetButton);

        //Add actionListener to button.
        clickButton.addActionListener(new ClickGameActionListener());
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
        gameScorePanel = new JPanel();
        gameScorePanel.add(gameScore);
        gameFrame.getContentPane().add(BorderLayout.CENTER, gameScorePanel);

        //Place button on the buttom of game window.
        gameFrame.getContentPane().add(BorderLayout.SOUTH, clickButtonPanel);
        gameFrame.getContentPane().add(BorderLayout.WEST, resetButtonPanel);

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
            fileReader.close();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    //Reset score method. 
    public void resetGame(){
        counter = 0;
        gameScore.setText(String.valueOf(counter));
        saveGame();
    }
    //Restar button listener
    public class ResetGameActionListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            resetGame();
        }
    }

    //CLick button listener
    public class ClickGameActionListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            counter++;
            clickButton.setText("click");
            changeColor();
            gameScore.setText(String.valueOf(counter));
            score = counter;
            saveGame();
        }
    }

    public void changeColor(){
        int r = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);

        gameScorePanel.setBackground(new Color(r,b,g));
    }
    
}