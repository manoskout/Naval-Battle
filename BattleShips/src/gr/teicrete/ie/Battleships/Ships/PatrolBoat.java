package gr.teicrete.ie.Battleships.Ships;

import gr.teicrete.ie.Battleships.GUI.boardCells;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatrolBoat extends Ships{
    private int size;

    public PatrolBoat(){
        PatrolBoat.super.setShipSize(2);
        size = PatrolBoat.super.getShipSize();
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
                        PatrolBoat.super.setPressed(true);
                    }else if(event.getBackground() == Color.yellow){
                        PatrolBoat.super.setPressed(false);
                    }
                }
            });
        }
    }
}
