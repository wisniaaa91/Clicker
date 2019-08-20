package app;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Game{
    
    JFrame gameFrame;

    public void init(){
        //Create and set up the window.
        gameFrame = new JFrame("Clicker");
        gameFrame.setBounds(100, 100, 500, 700);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create a panel for object.
        JPanel gamePanel = new JPanel();
        
        //Create a button.
        JButton clickButton = new JButton("CLICK HERE TO GET SCORE");
        //Add actionListener to button.
        clickButton.addActionListener(new ClickActionListener());
        //Add button to panel.
        gamePanel.add(clickButton);

        gameFrame.getContentPane().add(BorderLayout.SOUTH, gamePanel);


        //Display the window.
        gameFrame.setVisible(true);
    }
    
    public class ClickActionListener{
        public void actionPerformanced(ActionEvent ev){

        }
    }
}