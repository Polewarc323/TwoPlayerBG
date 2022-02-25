import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/****************************************************************************
*This Class is one of two frames for the battleship game
*contains two phases the placement phase player one and the firing phase for 
*Player two 
*Class Implements Action Listener
*
*@author Christopher Polewarczyk
*@version January 25, 2022
*
*
*****************************************************************************/
public class BshipPlaceP1 implements ActionListener{

	
	/**Instantiates frame JFrame*/
	static JFrame frame = new JFrame();

	/**Instantiates p1Place label*/
	static JLabel p1Place = new JLabel("Player One Place your ships");
	
	/**Instantiates directions label*/
	static JLabel directions = new JLabel ("Player One, set the coordinates"
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

	/**Instantiates the JCombo box that allows the user to select which 
	 * ship they would like to place*/
	static JComboBox  shipSel = new JComboBox (shipSelItems);
	
	/**Instantiates donBtn*/
	static JButton donBtn = new JButton ("Done");
	
	/**Instantiates placeBtn*/
	static JButton placeBtn = new JButton ("Place");
	
	/**Instantiates Player2Fire button that will be shown 
	 * after placement phase*/
	static JLabel Player2Fire = new JLabel("PLAYER TWO PICK A COORDINATE");

	/**Instantiates frontCo text field*/
	static JTextField frontCo = new JTextField (1);
	
	/**Instantiates rearCo text field*/
	static JTextField rearCo = new JTextField (1);
	
	/**Instantiates fireCo text field that will be shown
	 * during firing phase of the game*/
	static JTextField fireCo = new JTextField (1);
	
	/**Instantiates fireBrn for the firing phase of the game*/
	static JButton fireBtn = new JButton ("Fire");
	
	/**Creates an array of labels for the side of the grid
	 * to show the user the coordinates of each button on the grid*/
	JLabel[] colLabels = new JLabel[10];
	JLabel[] rowLabels = new JLabel[10]; 
	
	/**Sets the row and col label arrays to display desired x, y */
	String[] colLbl =  {"A","B","C","D","E","F","G","H","I","J"};
	String[] rowLbl =  {"1","2","3","4","5","6","7","8","9","10"};
	
	/**Instantiates 2d array of buttons for the grid*/
	private JButton[][] grid = new JButton[10][10];
	
	/**Creates a Battleship logic object to call methods*/
	public static BattleshipLogic bsl = new BattleshipLogic();
	
	/**Lives int for calculating current players lives*/
	private static int lives = bsl.getLives(1);
	
	/**Creates lives Label for Player One*/
	static JLabel Player1Lives = new JLabel("Player One Lives Left: " + lives);
	
	
	/**Used to make sure all ships are placed before the done button can work as intended*/
	private static int shipsToBePlaced = 5;
	private int ship;
	private int player = 1;
	
	/**Constructor for the frame and class*/
	BshipPlaceP1(){

		
		
		/**setting properties of the overall frame*/
		frame.setPreferredSize (new Dimension (944, 574));
		frame.setLayout (new FlowLayout(FlowLayout.CENTER, 100, 100));

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
		fireBtn.addActionListener(this);

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
		
		/**Phase two items or 
		 * firing phase items, hidden*/
		Player2Fire.setVisible(false);
		fireBtn.setVisible(false);
		fireCo.setVisible(false);
		Player1Lives.setVisible(false);
		
		/**Setting properties of firing phase*/
		Player2Fire.setBounds(370,35,300,45);
		fireBtn.setBounds(100, 330, 100, 50);
		fireCo.setBounds(100, 250, 100, 50);
		Player1Lives.setBounds (100, 200, 250, 50);
		
		/**Adding row labels to display on frame*/
		for(int i = 0; i < rowLbl.length; i++) {
			rowLabels[i] = new JLabel(rowLbl[i]);
			rowLabels[i].setBounds(575 , 200 + (25*i), 25, 25);
			frame.add(rowLabels[i]);
		}
		
		/**Adding column labels to display on frame*/
		for(int i = 0; i < colLbl.length; i++) {	
			colLabels[i] = new JLabel(colLbl[i]);
			colLabels[i].setBounds(600 + (25*i), 175, 25, 25);
			frame.add(colLabels[i]);
		}
		
		/**Adds grid of buttons*/
		for(int row = 0; row < 10; row++)
		     for(int col = 0; col < 10; col++){
		    	 
		    	 grid[row][col] = new JButton("");
		    	 grid[row][col].setBounds(600 + (25*row),200 + (25*col),25,25);
		    	 grid[row][col].addActionListener(this);
		    	 frame.add(grid[row][col]);
		    }
		
		/**Sets more properties of frame*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500,1500);
		frame.setLayout(null);
		frame.setVisible(true); 


	}



	public void actionPerformed(ActionEvent e) {
		
		/**When donBtn is clicked, checks if ships are
		 * all placed then proceeds to make the visibility of
		 * frame to be false 
		 * calls BshipPlace2 constructor
		 * sets ships placed from being shown on grid to be default color 
		 * If the ships are not all placed shows an error message*/
		if(e.getSource() == donBtn) {
			if(0 == shipsToBePlaced) {
				for(int row = 0; row < 10; row++)
					for(int col = 0; col < 10; col++){
						grid[row][col].setBackground(Color.WHITE);
					}
				
				frame.setVisible(false);
				new BshipPlaceP2();
				/**Adds Player One's lives for the firing phase*/
				frame.add(Player1Lives);
			}
			else {
				/**Error pop-up shown if placement is invalid*/
				JOptionPane.showMessageDialog(frame, "Player 1, Place all ships before proceeding", 
						null, JOptionPane.ERROR_MESSAGE, null);
			}
		}
		

		/**When  placeBtn is clicked by player one during the placement phase, 
		 * the ship selected in the drop down box
		 * is check then set to the corresponding ship size, The placeShip 
		 * function is called from the BattleshipLogic object and if true
		 * places a ship in the desired coordinates 
		 * if false a pop-up error message will be shown and the user will have 
		 * to try again*/
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
				Player1Lives.setText("Player One Lives Left: " + lives);
				String coord;
				int id;
				/**Displays placed ship on grid*/
				for (int row = 0; row < rowLbl.length; row++) {
					for (int col = 0; col < colLbl.length; col++) {
						coord = colLbl[row] + rowLbl[col];
						id = bsl.getCoordinateData(coord, player);
						if (1 == id) {
							grid[row][col].setBackground(Color.BLACK);
						} 
						
				    	grid[row][col].setBounds(600 + (25*row),200 + (25*col),25,25);
				    	grid[row][col].addActionListener(this);
				    	frame.add(grid[row][col]);	
					}
				}
			}
			else {
				/**Throws error message if placement is invalid*/
				JOptionPane.showMessageDialog(frame, "Player 1, invalid ship placement, try again.", 
						null, JOptionPane.ERROR_MESSAGE, null);
			}
				
		}
		
		/**This button is shown during the firing phase of the game,
		 * player 2 will be setting a coordinate to be fired upon
		 * Calls placeHit function to determine hit
		 * An error will pop-up if the coordinate is either chosen already
		 * or if the coordinate is invalid*/
		if(e.getSource() == fireBtn) {
			
			int hitResult;
			
			/**Updates lives then sets text box for player one lives*/
			lives = BshipPlaceP1.bsl.getLives(1);
			Player1Lives.setText("Player One Lives Left: " + lives);
			
			/**Calls placeHit function */
			hitResult = bsl.placeHit(fireCo.getText(), 2);

			if(2 == hitResult) {
				/**Error message for invalid coordinates*/
				JOptionPane.showMessageDialog(frame, "Player 2, invalid coordinate, try again.",
						null, JOptionPane.ERROR_MESSAGE, null);
			}
			else {
				/**Checks for if the ships is hit or not
				 * Prompts will inform Player Two if the did or did not hit a ship*/
				if(0 == hitResult) {
					grid[bsl.getRowIndex(fireCo.getText())][bsl.getColIndex(fireCo.getText())].setBackground(Color.RED);
					
					JOptionPane.showMessageDialog(frame, " Player 2, you did not hit a ship.", 
							null, JOptionPane.PLAIN_MESSAGE, null);
				}
				if(1 == hitResult) {
					grid[bsl.getRowIndex(fireCo.getText())][bsl.getColIndex(fireCo.getText())].setBackground(Color.GREEN);
				
					JOptionPane.showMessageDialog(frame, "Player 2, you hit a ship!", 
							null, JOptionPane.PLAIN_MESSAGE, null);
				}

				/**sets Placement Phase items for the BshipPlaceP2 frame to be non visible */
				frame.setVisible(false);
				BshipPlaceP2.strtBtn.setVisible(false);
				BshipPlaceP2.placeBtn.setVisible(false);
				BshipPlaceP2.frontCo.setVisible(false);
				BshipPlaceP2.rearCo.setVisible(false);
				BshipPlaceP2.p2Place.setVisible(false);
				BshipPlaceP2.front.setVisible(false);
				BshipPlaceP2.rear.setVisible(false);
				BshipPlaceP2.directions.setVisible(false);
				BshipPlaceP2.shipSel.setVisible(false);


				/**Checks lives to see if the game is over, otherwise the game continues
				 * If the game is over there will be a prompt that pops up to tell which player won*/
				if(bsl.isGameOver() == true) {
					if(bsl.getLives(1) == 0) {
						JOptionPane.showMessageDialog(frame, "Player 2 Wins!", null, JOptionPane.PLAIN_MESSAGE, null);
						System.out.println("Player Two Won");
						this.frame.dispose();
						BshipPlaceP2.frame.dispose();
						new bShipGOScreen();
					}else {
						JOptionPane.showMessageDialog(frame, "Player 1 Wins!", null, JOptionPane.PLAIN_MESSAGE, null);
						System.out.println("Player One Won");
						new bShipGOScreen();
						frame.dispose();

					}

				}else {
					/**If the game continues then visibility for firing phase items
					 * will be true, other needed frame items for firing phase will be
					 * be added as well*/
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
}