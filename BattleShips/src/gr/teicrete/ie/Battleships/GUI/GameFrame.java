package gr.teicrete.ie.Battleships.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

import gr.teicrete.ie.Battleships.Board.MainBoard;
import gr.teicrete.ie.Battleships.Ships.*;

public class GameFrame extends JFrame {

    private final int row;
    private final int col;
    private Ships[] ShipsAr;
    private BorderLayout layout;
    private JPanel mainPane,butPane,boardPane,shipsPane;
    private JLabel instL;
    private JButton rotB,startB;
    private Boolean rotFlag;
    
    public GameFrame(){
        super("BattleShip - Ship's Placement");
        row=10;
        col=10;
        layout = new BorderLayout(100,100);
        initComp();
    }
    // gridlayout row(seira),col(sthlh)
    private void initComp(){
        Carrier carrier = new Carrier();
        BattleShip battleShip = new BattleShip();
        SubMarine subMarine= new SubMarine();
        Destroyer destroyer = new Destroyer();
        PatrolBoat patrolBoat = new PatrolBoat();
        rotFlag = false;
        this.setLayout(layout);//to panel olo to parathiro
        mainPane = new JPanel();
        butPane = new JPanel(new BorderLayout());
        boardPane = new JPanel(new GridLayout(10,10));
        shipsPane = new JPanel(new GridLayout(5,1,0,5));
        butPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 

        //insert instruction on a top
        instL = new JLabel("Please select ships from the left and place them in your board. Press 'Start Game' when you are ready!", JLabel.CENTER);
        this.add(instL, BorderLayout.NORTH);
        this.add(mainPane, BorderLayout.CENTER);

        //insert the buttons on the botton
        rotB = new JButton("Rotate Ship");
        rotB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(battleShip.isPressed() && !battleShip.getRotation())
                    battleShip.setRotation(true);
                else if(battleShip.isPressed() && battleShip.getRotation())
                    battleShip.setRotation(false);
            }
        });
        startB = new JButton("Start Game");
        this.add(butPane,BorderLayout.SOUTH);
        butPane.add(rotB, BorderLayout.WEST);
        butPane.add(startB, BorderLayout.EAST);

        //Insert the Ships
        //shipsPane.add(carrier);
        shipsPane.add(battleShip);
        //shipsPane.add(subMarine);
        //shipsPane.add(destroyer);
        //shipsPane.add(patrolBoat);
        shipsPane.setPreferredSize(new Dimension (400,400));
        EmptyBorder shipBorder = new EmptyBorder(50,50,50,50);
        TitledBorder shipBorderTitle = BorderFactory.createTitledBorder(shipBorder, "Ships to be Placed");
        shipBorderTitle.setTitleJustification(TitledBorder.CENTER);
        shipsPane.setBorder(shipBorderTitle);
        //Insert the  Board
        mainPane.add(shipsPane, BorderLayout.EAST);
        //insert the board in the center
        mainPane.add(new MainBoard(10,10,carrier,destroyer, battleShip, subMarine, patrolBoat),BorderLayout.WEST);


        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    
}
