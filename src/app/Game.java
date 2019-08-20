package app;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game implements ActionListener{
    
    JFrame gameFrame;
    int counter = 0;
    JButton clickButton;
    JLabel gameScore;

    public void init(){
        //Create and set up the window.
        gameFrame = new JFrame("Clicker");
        gameFrame.setSize(500, 700);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a panel for object.
        JPanel gamePanel = new JPanel();
        
        //Create a button.
        clickButton = new JButton("CLICK HERE TO GET SCORE");

        //Add actionListener to button.
        clickButton.addActionListener(this);

        //Add button to panel.
        gamePanel.add(clickButton);

        gameFrame.;

        gameFrame.getContentPane().add(BorderLayout.SOUTH, gamePanel);


        //Display the window.
        gameFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {
        counter++;
        clickButton.setText("click");
    }
}