package gr.teicrete.ie.Battleships.Ships;

import java.awt.Color;
import java.awt.event.*;

import gr.teicrete.ie.Battleships.GUI.boardCells;

public class Carrier extends Ships{
	private int size;
	
    public Carrier(){
    	Carrier.super.setShipSize(5);
        size = Carrier.super.getShipSize();
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
                        Carrier.super.setPressed(true);
                    }else if(event.getBackground() == Color.yellow){
                        Carrier.super.setPressed(false);
                    }
                }
            });
        }
    }
}
