package gr.teicrete.ie.Battleships.Board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import gr.teicrete.ie.Battleships.GUI.boardCells;
import gr.teicrete.ie.Battleships.Ships.*;

public class MainBoard extends JPanel {

    private final int rows;
    private final int cols;
    private  Carrier carrier;
    private  Destroyer destroyer;
    private BattleShip battleShip;
    private SubMarine subMarine;
    private PatrolBoat patrolBoat;
    private boardCells[][] cellArray;


    public MainBoard(int rows, int cols, Carrier carrier, Destroyer destroyer, BattleShip battleShip, SubMarine subMarine, PatrolBoat patrolBoat){
        this.rows = rows;
        this.cols = cols;
        this.carrier = carrier;
        this.destroyer = destroyer;
        this.battleShip = battleShip;
        this.subMarine = subMarine;
        this.patrolBoat = patrolBoat;
        initComp();


    }
    private void initComp(){
        this.setLayout(new GridLayout(rows,cols));

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                cellArray[i][j] = new boardCells(Color.CYAN);
                this.add(cellArray[i][j]);
            }
        }
        //na ginete h epilogi mono enos ploiou
        for(int j =0; j<5; j++) {
            carrier.getSlot()[j].addActionListener(e -> {
                boardCells event = ((boardCells) e.getSource());
                if (event.getBackground() == Color.YELLOW) {
                    setShipsEnable(carrier, true);
                }else{
                    setShipsEnable(carrier, false);
                }
            });
            battleShip.getSlot()[j].addActionListener(e -> {
                boardCells event = ((boardCells) e.getSource());
                if (event.getBackground() == Color.YELLOW) {
                    setShipsEnable(battleShip, true);
                }else{
                    setShipsEnable(battleShip, false);
                }
            });
            subMarine.getSlot()[j].addActionListener(e -> {
                boardCells event = ((boardCells) e.getSource());
                if (event.getBackground() == Color.YELLOW) {
                    setShipsEnable(subMarine, true);
                }else{
                    setShipsEnable(subMarine, false);
                }
            });
            destroyer.getSlot()[j].addActionListener(e -> {
                boardCells event = ((boardCells) e.getSource());
                if (event.getBackground() == Color.YELLOW) {
                    setShipsEnable(destroyer, true);
                }else{
                    setShipsEnable(destroyer, false);
                }
            });
            patrolBoat.getSlot()[j].addActionListener(e -> {
                boardCells event = ((boardCells) e.getSource());
                if (event.getBackground() == Color.YELLOW) {
                    setShipsEnable(patrolBoat, true);
                }else{
                    setShipsEnable(patrolBoat, false);
                }
            });
        }


        //ruthmisi twn boarders tou board
        this.setPreferredSize(new Dimension (600,600));
        EmptyBorder boardBorder = new EmptyBorder(50,50,50,50);
        TitledBorder boardBorderTitle = BorderFactory.createTitledBorder(boardBorder, "Your Board");
        boardBorderTitle.setTitleJustification(TitledBorder.CENTER);
        this.setBorder(boardBorderTitle);
    }
    
    private void setShipsEnable(Ships e, boolean flag){
        for(int i=0; i<5; i++){
        	//if(e.getSlot()[i].getBackground()== Color.gray || e.getSlot()[i].getBackground()== Color.yellow) {
        		carrier.getComponents()[i].setEnabled(flag);
                battleShip.getComponents()[i].setEnabled(flag);
                destroyer.getComponents()[i].setEnabled(flag);
                patrolBoat.getComponents()[i].setEnabled(flag);
                subMarine.getComponents()[i].setEnabled(flag);
                if(e!=null && !flag){
                    e.getComponents()[i].setEnabled(true);
                }
        	
            
        }
    }
}
