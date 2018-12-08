package gr.teicrete.ie.Battleships.Ships;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import gr.teicrete.ie.Battleships.GUI.boardCells;

public class Ships extends JPanel{
	private boardCells[] slot;
	//den exei epilex8ei kanena ploio
	private boolean shipClicked = false;
	private boolean pressed;
	private int shipSize;
	private boolean rotation;

	
	
    public Ships(){
		initComp();
    }
    
    private void initComp() {
    	this.setLayout(new GridLayout(1,5));   //dhmiourgia tou panel gia kataxwrish tou ploiou
    	slot = new boardCells[5]; 				//dhmiourgia pinaka koumpion 5 8esewn
    	
    	//dhmiourgia slots kai eisagogh sto panel
    	for(int i=0; i<5; i++) {
    		slot[i] = new boardCells(Color.lightGray);
    		slot[i].setEnabled(false);
    		this.add(slot[i]);
    	}
    	//mouseListener se kathe koumpi
		for(int i=0; i<5; i++){
			int j=i;
			slot[i].addActionListener(e-> {
				if(slot[j].getBackground() == Color.gray && !shipClicked){
					for(int k=0; k<5; k++){
						if(slot[k].getBackground()== Color.lightGray)
							slot[k].setEnabled(false);
						if(slot[k].getBackground() == Color.gray){
							slot[k].setBackground(Color.yellow);
						}
						shipClicked = true;
					}
				}
				else if(slot[j].getBackground() == Color.yellow && shipClicked){
					for(int l=0; l<5; l++){
						if(slot[l].getBackground()== Color.lightGray)
							slot[l].setEnabled(false);
						if(slot[l].getBackground() == Color.yellow ){
							slot[l].setBackground(Color.gray);
						}
						shipClicked = false;
					}
				}
			});
		}

    }

    public void setShipSize(int shipSize) {
    	this.shipSize = shipSize;
    }
    
    public int getShipSize() {
    	return shipSize;
    }

    public void setRotation(boolean rotation){
    	this.rotation = rotation;
    }

    public boolean getRotation(){
    	return rotation;
	}
    
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	public boolean isPressed(){
    	return pressed;
	}

	public boardCells[] getSlot() {
		return slot;
	}
}
