package gr.teicrete.ie.Battleships.GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UserFrame extends JFrame{
    public UserFrame(){
        super("BattleShips - Player's Details.");
        initComp();
    }
    
    private void initComp(){
        this.setLayout(new BorderLayout(25,25));
        panel = new JPanel();
        nameLabel = new JLabel("Please insert your name and press 'OK'", JLabel.CENTER);
        nameText = new JTextField(10);
        okB = new JButton("OK");
        okB.addActionListener((ActionEvent e) -> {
            StartGame();
        });
        add(nameLabel);
        panel.add(nameText);
        panel.add(okB);
        add(panel, BorderLayout.PAGE_END);
        //okB.setBounds(50,50,50,50);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }	
    
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameText;
    private JButton okB;

    private void StartGame() {
        if(nameText.getText().equals("")){
            //JOptionPane.showMessageDialog(this, "Please insert your name!");
        }else{
            dispose();
            new GameFrame().setVisible(true);
        }
    }
}