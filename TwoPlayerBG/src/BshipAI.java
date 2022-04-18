import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class BshipAI extends JFrame implements ActionListener, KeyListener{
	
	JFrame frame = new JFrame();
	
	/**Instantiates p1Place label*/
	static JLabel p1Place = new JLabel("Place your ships");
	
	/**Instantiates directions label*/
	static JLabel directions = new JLabel ("Set the coordinates"
									+ " of your ship and the ship type");
	
	/**Instantiates front coordinate label*/
	static JLabel front = new JLabel("Front");
	
	/**Instantiates rear coordinate label*/
	static JLabel rear = new JLabel("Rear");

	/**Instantiates array containing ship names that will be included in
	 *the drop down menu of the J Combo box shipSel which is 
	 *created down below*/
	static String[] shipSelItems = {"Carrier", "Battleship", "Cruiser"
								, "Submarine", "Patrol Boat"};
	
	static JComboBox  shipSel = new JComboBox (shipSelItems);
	
	/**Instantiates donBtn*/
	static JButton donBtn = new JButton ("Done");
	
	/**Instantiates placeBtn*/
	static JButton placeBtn = new JButton ("Place");
	
	/**Creates an array of labels for the side of the grid
	 * to show the user the coordinates of each button on the grid*/
	JLabel[] colLabels = new JLabel[10];
	JLabel[] rowLabels = new JLabel[10]; 
	
	
	JLabel shipPlaceLbl = new JLabel("Player Place Ships");
	JLabel shipFireLbl = new JLabel("Click to Fire Here");
	
	/**Sets the row and col label arrays to display desired x, y */
	String[] colLbl =  {"A","B","C","D","E","F","G","H","I","J"};
	String[] rowLbl =  {"1","2","3","4","5","6","7","8","9","10"};
	
	String[] colLblHit =  {"A","B","C","D","E","F","G","H","I","J"};
	String[] rowLblHit =  {"1","2","3","4","5","6","7","8","9","10"};
	
	/**Instantiates 2d array of buttons for the grid*/
	private JButton[][] placeGrid = new JButton[10][10];
	private JButton[][] hitGrid = new JButton[10][10];
	
	/**Creates a Battleship logic object to call methods*/
	public static BattleshipLogic bsl = new BattleshipLogic();
	
	/**Lives int for calculating current players lives*/
	private static int lives = bsl.getLives(1);
	
	/**Creates lives Label for Player One*/
	static JLabel Player1Lives = new JLabel("Lives Left: " + lives);
	
	/**Instantiates frontCo text field*/
	static JTextField frontCo = new JTextField (1);
	
	/**Instantiates rearCo text field*/
	static JTextField rearCo = new JTextField (1);
	
	
	/**Used to make sure all ships are placed before the done button can work as intended*/
	private static int shipsToBePlaced = 5;
	private int ship;
	private int player = 1;
	
	BshipAI(){
		
		/**setting properties of the overall frame*/
		frame.setPreferredSize (new Dimension (944, 574));
		frame.setLayout (new FlowLayout(FlowLayout.CENTER, 100, 100));
		
		this.addKeyListener(this);

		/**Adding Phase One items*/
		frame.add (donBtn);
		frame.add (placeBtn);
		frame.add (shipSel);
		frame.add (front);
		frame.add (rear);
		frame.add (frontCo);
		frame.add (rearCo);
		frame.add (p1Place);
		frame.add (directions);
		
		/**Setting visibility of Phase One items*/
		donBtn.setVisible(true);
		placeBtn.setVisible(true);
		frontCo.setVisible(true);
		rearCo.setVisible(true);
		p1Place.setVisible(true);
		front.setVisible(true);
		rear.setVisible(true);
		directions.setVisible(true);
		shipSel.setVisible(true);
		
		/**Adding Action listener for all buttons
		 * and intractable objects*/
		placeBtn.addActionListener(this);
		donBtn.addActionListener(this);
		shipSel.addActionListener(this);
		

		// x, y, length, height
		/**Setting properties of items*/
		donBtn.setBounds (10, 450, 115, 70);
		placeBtn.setBounds (10, 330, 100, 50);
		shipSel.setBounds (30, 160, 100, 25);
		front.setBounds (30, 225, 100, 25);
		rear.setBounds (130, 225, 100, 25);
		frontCo.setBounds (10, 275, 100, 25);
		rearCo.setBounds (125, 275, 100, 25);
		p1Place.setBounds (370, 35, 165, 45);
		directions.setBounds (5, 65, 460, 110);
		
		frame.add(shipPlaceLbl);
		frame.add(shipFireLbl);
		
		shipPlaceLbl.setBounds(500, 50, 150 ,150);
		shipFireLbl.setBounds(500, 600, 150, 150);
		
		/**Adding row labels to display on frame*/
		for(int i = 0; i < rowLbl.length; i++) {
			rowLabels[i] = new JLabel(rowLbl[i]);
			rowLabels[i].setBounds(710 , 50 + (40*i), 40, 40);
			frame.add(rowLabels[i]);
		}
		
		/**Adding column labels to display on frame*/
		for(int i = 0; i < colLbl.length; i++) {	
			colLabels[i] = new JLabel(colLbl[i]);
			colLabels[i].setBounds(750 + (40*i), 10, 40, 40);
			frame.add(colLabels[i]);
		}
		
		/**Adds grid of buttons*/
		for(int row = 0; row < 10; row++)
		     for(int col = 0; col < 10; col++){
		    	 
		    	 placeGrid[row][col] = new JButton("");
		    	 placeGrid[row][col].setBounds(750 + (40*col),50 + (40*row),40,40);
		    	 placeGrid[row][col].addActionListener(this);
		    	 frame.add(placeGrid[row][col]);
		    }
		
		/**Adding row labels to display on frame*/
		for(int i = 0; i < rowLblHit.length; i++) {
			rowLabels[i] = new JLabel(rowLblHit[i]);
			rowLabels[i].setBounds(710 , 600 + (40*i), 40, 40);
			frame.add(rowLabels[i]);
		}
		
		/**Adding column labels to display on frame*/
		for(int i = 0; i < colLblHit.length; i++) {	
			colLabels[i] = new JLabel(colLblHit[i]);
			colLabels[i].setBounds(750 + (40*i), 560, 40, 40);
			frame.add(colLabels[i]);
		}
		
		for(int row = 0; row < 10; row++)
        	for(int col = 0; col < 10; col++){

        		hitGrid[row][col] = new JButton("");
        		hitGrid[row][col].setBounds(750 + (40*col),600 + (40*row),40,40);
        		hitGrid[row][col].addActionListener(this);
        		frame.add(hitGrid[row][col]);
        		
        	}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500,1500);
		frame.setLayout(null);
		frame.setVisible(true); 
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == donBtn) {
			shipsToBePlaced = 0;
			if(0 == shipsToBePlaced) {

				frame.add(Player1Lives);
				directions.setVisible(false);
				donBtn.setVisible(false);
				donBtn.setVisible(false);
				placeBtn.setVisible(false);
				shipSel.setVisible(false);
				front.setVisible(false);
				rear.setVisible(false);
				frontCo.setVisible(false);
				rearCo.setVisible(false);;
				p1Place.setVisible(false);
				
				bsl.computerPlaceShips();
			}
			else {
				/**Error pop-up shown if placement is invalid*/
				JOptionPane.showMessageDialog(frame, "Player 1, Place all ships before proceeding", 
						null, JOptionPane.ERROR_MESSAGE, null);
			}
		}
		
		
	if(e.getSource() == placeBtn) {
				
				/**ship selected in the drop down box is check then set to 
				 * the corresponding ship size*/
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
				
				/**Front and Rear coordinate are set to the text that is
				 * input in the fronCo and rearCo text fields*/
				String front = frontCo.getText();
				String rear = rearCo.getText();
	
				/**Checks if placeShip boolean is true, called from the
				 * battleshipLogic object*/
				if(bsl.placeShip( player,  front,  rear,  ship)) {
					//
					shipsToBePlaced--;
					shipSel.removeItem(shipSel.getSelectedItem());
					//Get the lives of player 1, not player 2.
					lives = BshipPlaceP1.bsl.getLives(1);

					String coord;
					int id;
					/**Displays placed ship on grid*/
					for (int row = 0; row < rowLbl.length; row++) {
						for (int col = 0; col < colLbl.length; col++) {
							coord = colLbl[col] + rowLbl[row];
							id = bsl.getCoordinateData(coord, player);
							if (1 == id) {
								placeGrid[row][col].setBackground(Color.GREEN);
							} 
							
							//placeGrid[row][col].setBounds(600 + (25*row),200 + (25*col),25,25);
							placeGrid[row][col].addActionListener(this);
					    	frame.add(placeGrid[row][col]);	
						}
					}
				}
				else {
					/**Throws error message if placement is invalid*/
					JOptionPane.showMessageDialog(frame, "Player 1, invalid ship placement, try again.", 
							null, JOptionPane.ERROR_MESSAGE, null);
				}
					
			}
			
	/*Checks grid for which button is pressed*/
	for(int i = 0; i < 10; i++) {
		for(int j = 0; j < 10; j++) {
			if(e.getSource() == hitGrid[i][j]) {
				
					bsl.placeHit(i, j, 1);
					
					try        
					{
					    Thread.sleep(500);
					} 
					catch(InterruptedException ex) 
					{
					    Thread.currentThread().interrupt();
					}
					
					bsl.computerPlaceHit();
					 // tomorrow, throw in error checking from twoplayer shits
					
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
