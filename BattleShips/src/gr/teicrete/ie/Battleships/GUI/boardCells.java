package gr.teicrete.ie.Battleships.GUI;

import java.awt.Color;

import javax.swing.JButton;

public class boardCells extends JButton  {
    private Color c;
    private Boolean click;
    
    public boardCells(Color c){
        initComp(c);
    }
    
    private void initComp(Color c){
        this.setBackground(c);
        click = false;
        this.setRolloverEnabled(false);


    }

    public Color getColor(){
        return c;
    }

    public boolean setPressed(Boolean pressed){
        click = pressed;
        return false;
    }

}
