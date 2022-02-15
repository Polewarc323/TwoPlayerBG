import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BshipPlaceP1 implements ActionListener{

	
	
	static JFrame frame = new JFrame();


	static JLabel p1Place = new JLabel("Player One Place your ships");
	static JLabel directions = new JLabel ("Player One, set the coordinates of your ship and the ship type");
	static JLabel front = new JLabel("Front");
	static JLabel rear = new JLabel("Rear");

	//construct preComponents
	static String[] shipSelItems = {"Carrier", "Battleship", "Cruiser", "Submarine", "Patrol Boat"};

	//construct components

	static JComboBox  shipSel = new JComboBox (shipSelItems);

	static JButton donBtn = new JButton ("Done");
	static JButton placeBtn = new JButton ("Place");
	
	static JLabel Player2Fire = new JLabel("PLAYER TWO PICK A COORDINATE");

	static JTextField frontCo = new JTextField (1);
	static JTextField rearCo = new JTextField (1);
	
	static JTextField fireCo = new JTextField (1);
	static JButton fireBtn = new JButton ("Fire");
	
	JLabel[] colLabels = new JLabel[10];
	JLabel[] rowLabels = new JLabel[10]; 
	
	String[] rowLbl =  {"A","B","C","D","E","F","G","H","I","J"};
	String[] colLbl =  {"1","2","3","4","5","6","7","8","9","10"};
	
	private JButton[][] grid = new JButton[10][10];
	
	public static BattleshipLogic bsl = new BattleshipLogic();
	
	private static int lives = bsl.getLives(1 );
	
	static JLabel Player1Lives = new JLabel("Player One Lives Left: " + lives);
	
	private int ship;
	private int player = 1;
	
	BshipPlaceP1(){

		
		
		//adjust size and set layout
		frame.setPreferredSize (new Dimension (944, 574));
		frame.setLayout (new FlowLayout(FlowLayout.CENTER, 100, 100));

		//add components
		frame.add (donBtn);
		frame.add (placeBtn);
		frame.add (shipSel);
		frame.add (front);
		frame.add (rear);
		frame.add (frontCo);
		frame.add (rearCo);
		frame.add (p1Place);
		frame.add (directions);
		
		donBtn.setVisible(true);
		placeBtn.setVisible(true);
		frontCo.setVisible(true);
		rearCo.setVisible(true);
		p1Place.setVisible(true);
		front.setVisible(true);
		rear.setVisible(true);
		directions.setVisible(true);
		shipSel.setVisible(true);
		
		placeBtn.addActionListener(this);
		donBtn.addActionListener(this);
		shipSel.addActionListener(this);
		fireBtn.addActionListener(this);

		// x, y, length, height
		//set component bounds (only needed by Absolute Positioning)
		donBtn.setBounds (10, 450, 115, 70);
		placeBtn.setBounds (10, 330, 100, 50);
		shipSel.setBounds (30, 160, 100, 25);
		front.setBounds (30, 225, 100, 25);
		rear.setBounds (130, 225, 100, 25);
		frontCo.setBounds (10, 275, 100, 25);
		rearCo.setBounds (125, 275, 100, 25);
		p1Place.setBounds (370, 35, 165, 45);
		directions.setBounds (5, 65, 460, 110);
		
		Player2Fire.setVisible(false);
		fireBtn.setVisible(false);
		fireCo.setVisible(false);
		Player1Lives.setVisible(false);
		
		Player2Fire.setBounds(370,35,300,45);
		fireBtn.setBounds(100, 330, 100, 50);
		fireCo.setBounds(100, 250, 100, 50);
		Player1Lives.setBounds (100, 200, 250, 50);
		
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

		if(e.getSource() == donBtn) {
			frame.setVisible(false);
			BshipPlaceP2 BshipPlaceP2 = new BshipPlaceP2();
			frame.add(Player1Lives);
		}
		

		if(e.getSource() == placeBtn) {
			
			if(shipSel.getSelectedItem() == "Carrier") {
				ship = 5;

			}else if(shipSel.getSelectedItem() == "Battleship") {
				ship = 4;
				
			}else if(shipSel.getSelectedItem() == "Cruiser") {
				ship = 3;

			}else if(shipSel.getSelectedItem() == "Submarine") {
				ship = 3;

			}else if(shipSel.getSelectedItem() == "Patrol Boat") {
				ship = 2;
			}
	
			String front = frontCo.getText();
			String rear = rearCo.getText();

			bsl.placeShip( player,  front,  rear,  ship);
			shipSel.removeItem(shipSel.getSelectedItem());
			lives = BshipPlaceP1.bsl.getLives(2);
			Player1Lives.setText("Player One Lives Left: " + lives);
			
			
			
			
		}
		
		if(e.getSource() == fireBtn) {
			bsl.placeHit(fireCo.getText(), player);
			lives = BshipPlaceP1.bsl.getLives(2);
			Player1Lives.setText("Player One Lives Left: " + lives);

			frame.setVisible(false);
//			BshipPlaceP2.frame.setVisible(true);
			BshipPlaceP2.strtBtn.setVisible(false);
			BshipPlaceP2.placeBtn.setVisible(false);
			BshipPlaceP2.frontCo.setVisible(false);
			BshipPlaceP2.rearCo.setVisible(false);
			BshipPlaceP2.p2Place.setVisible(false);
			BshipPlaceP2.front.setVisible(false);
			BshipPlaceP2.rear.setVisible(false);
			BshipPlaceP2.directions.setVisible(false);
			BshipPlaceP2.shipSel.setVisible(false);


			
			if(bsl.isGameOver() == true) {
				if(bsl.getLives(1) == 0) {
					System.out.println("Player Two Won");
					this.frame.dispose();
					BshipPlaceP2.frame.dispose();
					bShipGOScreen bShipGOScreen = new bShipGOScreen();
				}else {
					System.out.println("Player One Won");
					bShipGOScreen bShipGOScreen = new bShipGOScreen();
					frame.dispose();
					
				}
	
			}else {
				
				BshipPlaceP2.Player1Fire.setVisible(true);
				BshipPlaceP2.fireCoP2.setVisible(true);
				BshipPlaceP2.fireBtnP2.setVisible(true);
				BshipPlaceP2.Player2Lives.setVisible(true);
				
				BshipPlaceP2.frame.setVisible(true);
				BshipPlaceP2.frame.add(BshipPlaceP2.fireBtnP2);
				BshipPlaceP2.frame.add(BshipPlaceP2.fireCoP2);
				BshipPlaceP2.frame.add(BshipPlaceP2.Player1Fire);
			}
		}
	}
}