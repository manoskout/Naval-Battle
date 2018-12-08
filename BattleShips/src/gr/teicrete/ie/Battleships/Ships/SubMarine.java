package gr.teicrete.ie.Battleships.Ships;

import gr.teicrete.ie.Battleships.GUI.boardCells;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubMarine extends Ships{
    private int size;

    public SubMarine(){
        SubMarine.super.setShipSize(3);
        size = SubMarine.super.getShipSize();
        initComp();
    }

    private void initComp(){
        for(int i=0; i<size; i++){
            this.getSlot()[i].setBackground(Color.gray);
            getSlot()[i].setEnabled(true);
        }
        for(int i=0;i<size;i++){
            this.getSlot()[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boardCells event = ((boardCells) e.getSource());

                    if(event.getBackground() == Color.gray){
                        SubMarine.super.setPressed(true);
                    }else if(event.getBackground() == Color.yellow){
                        SubMarine.super.setPressed(false);
                    }
                }
            });
        }
    }
}
