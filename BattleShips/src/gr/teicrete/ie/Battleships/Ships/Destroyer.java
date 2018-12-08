package gr.teicrete.ie.Battleships.Ships;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gr.teicrete.ie.Battleships.GUI.boardCells;

public class Destroyer extends Ships {
	private int size;
	
    public Destroyer(){
    	Destroyer.super.setShipSize(3);
    	size = Destroyer.super.getShipSize();
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
                        Destroyer.super.setPressed(true);
                    }else if(event.getBackground() == Color.yellow){
                        Destroyer.super.setPressed(false);
                    }
                }
            });
        }
    }
}

