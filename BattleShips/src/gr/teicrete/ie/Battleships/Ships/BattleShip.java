package gr.teicrete.ie.Battleships.Ships;

import gr.teicrete.ie.Battleships.GUI.boardCells;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleShip extends Ships{
    private int size;

    public BattleShip(){
        BattleShip.super.setShipSize(4);
        size = BattleShip.super.getShipSize();
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
                        BattleShip.super.setPressed(true);
                    }else if(event.getBackground() == Color.yellow){
                        BattleShip.super.setPressed(false);
                    }
                }
            });
        }
    }
}
