import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BshipPlaceP2 implements ActionListener{

	static JFrame frame = new JFrame();
	
	
	static JLabel p2Place = new JLabel("Player Two Place your ships");
	static JLabel directions = new JLabel ("Player Two, set the coordinates of your ship and the ship type");
	static JLabel front = new JLabel("Front");
	static JLabel rear = new JLabel("Rear");
	
	//construct preComponents
    static String[] shipSelItems = {"  ", "Carrier", "Battleship", "Cruiser", "Submarine", "Patrol Boat"};

    //construct components
    
    static JComboBox  shipSel = new JComboBox (shipSelItems);
    
    static JButton strtBtn = new JButton ("Start Game");
    static JButton placeBtn = new JButton ("Place");
    
    static JLabel Player1Fire = new JLabel("PLAYER ONE PICK A COORDINATE");
    
    static JTextField frontCo = new JTextField (1);
    static JTextField rearCo = new JTextField (1);
    
    static JTextField fireCoP2 = new JTextField (1);
    static JButton fireBtnP2 = new JButton ("Fire");
    
    JLabel[] colLabels = new JLabel[10];
	JLabel[] rowLabels = new JLabel[10]; 
	
	String[] rowLbl =  {"A","B","C","D","E","F","G","H","I","J"};
	String[] colLbl =  {"1","2","3","4","5","6","7","8","9","10"};
    
    private JButton[][] grid = new JButton[10][10];
	
    private int ship = 0;
    private int player2 = 2;
	BshipPlaceP2(){
		

        //adjust size and set layout
        frame.setPreferredSize (new Dimension (944, 574));
        frame.setLayout (null);

        //add components
        frame.add (strtBtn);
        frame.add (placeBtn);
        frame.add (shipSel);
        frame.add (front);
        frame.add (rear);
        frame.add (frontCo);
        frame.add (rearCo);
        frame.add (p2Place);
        frame.add (directions);
        
     
        strtBtn.addActionListener(this);
        placeBtn.addActionListener(this);
        shipSel.addActionListener(this);
        fireBtnP2.addActionListener(this);
     

        //set component bounds (only needed by Absolute Positioning)
        strtBtn.setBounds (10, 450, 115, 70);
        placeBtn.setBounds (10, 330, 100, 50);
        shipSel.setBounds (30, 160, 100, 25);
        front.setBounds (30, 225, 100, 25);
        rear.setBounds (130, 225, 100, 25);
        frontCo.setBounds (10, 275, 100, 25);
        rearCo.setBounds (125, 275, 100, 25);
        p2Place.setBounds (370, 35, 165, 45);
        directions.setBounds (5, 65, 460, 110);
        
        Player1Fire.setBounds(370,35,165,45);
        fireCoP2.setBounds(100, 250, 100, 50);
        fireBtnP2.setBounds(100,330, 100, 50);
        
        for(int i = 0; i < rowLbl.length; i++) {
			rowLabels[i] = new JLabel(rowLbl[i]);
			rowLabels[i].setBounds(575 , 200 + (25*i), 25, 25);
			frame.add(rowLabels[i]);
		}
		
		for(int i = 0; i < colLbl.length; i++) {	
			colLabels[i] = new JLabel(colLbl[i]);
			colLabels[i].setBounds(600 + (25*i), 175, 25, 25);
			frame.add(colLabels[i]);
		}
        
        for(int row = 0; row < 10; row++)
        	for(int col = 0; col < 10; col++){

        		grid[row][col] = new JButton("");
        		grid[row][col].setBounds(600 + (25*row),200 + (25*col),25,25);
        		grid[row][col].addActionListener(this);
        		frame.add(grid[row][col]);
        	}

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500,1500);
		frame.setLayout(null);
		frame.setVisible(true); 

	
	}
	


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == strtBtn) {
			this.frame.setVisible(false);
			//BshipMainP1 BshipMainP1 = new BshipMainP1();
			BshipPlaceP1.frame.setVisible(true);
			
			
			
			BshipPlaceP1.donBtn.setVisible(false);
			BshipPlaceP1.placeBtn.setVisible(false);
			BshipPlaceP1.frontCo.setVisible(false);
			BshipPlaceP1.rearCo.setVisible(false);
			BshipPlaceP1.p1Place.setVisible(false);
			BshipPlaceP1.front.setVisible(false);
			BshipPlaceP1.rear.setVisible(false);
			BshipPlaceP1.directions.setVisible(false);
			BshipPlaceP1.shipSel.setVisible(false);
			
			BshipPlaceP1.frame.add(BshipPlaceP1.Player2Fire);
			BshipPlaceP1.frame.add(BshipPlaceP1.fireBtn);
			BshipPlaceP1.frame.add(BshipPlaceP1.fireCo);
			
			
		}
		
		if(e.getSource() == shipSel) {

			int ship = 0;

			if(shipSel.getSelectedItem() == "Carrier") {
				ship = 5;

			}
			if(shipSel.getSelectedItem() == "Battleship") {
				ship = 4;
				
			}
			if(shipSel.getSelectedItem() == "Cruiser") {
				ship = 3;

			}
			if(shipSel.getSelectedItem() == "Submarine") {
				ship = 3;

			}
			if(shipSel.getSelectedItem() == "Patrol Boat") {
				ship = 2;
			}

			if(ship == 0) {
				//throw some shit I dont know
			}
			
		}
		
		
		if(e.getSource() == placeBtn) {
			int player2 = 2;
		
			
			String front = frontCo.getText();
			String rear = rearCo.getText();
			
			
			BshipPlaceP1.bsl.placeShip( player2,  front,  rear,  ship);
			shipSel.removeItem(shipSel.getSelectedItem());
		}
		
		if(e.getSource() == fireBtnP2) {
			BshipPlaceP1.bsl.placeHit(fireCoP2.getText(), player2);
			
			//bsl.placeHit(, player);
			
			if(BshipPlaceP1.bsl.isGameOver() == true) {
				if(BshipPlaceP1.bsl.getLives(1) == 0) {
					System.out.println("Player Two Won");
					frame.dispose();
					bShipGOScreen gameOver = new bShipGOScreen();
				}


				
				//BshipMainP1 BshipMainP1 = new BshipMainP1();
				//BshipPlaceP1.frame.setVisible(true);

				BshipPlaceP2.frame.add(BshipPlaceP2.fireBtnP2);
				BshipPlaceP2.frame.add(BshipPlaceP2.fireCoP2);
				BshipPlaceP2.frame.add(BshipPlaceP2.Player1Fire);
			}
			this.frame.setVisible(false);
			BshipPlaceP1.frame.setVisible(true);
		}

	}
}
