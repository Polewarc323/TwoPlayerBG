import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class BshipPlaceP2 implements ActionListener{

	/**Instantiates frame JFrame*/
	static JFrame frame = new JFrame();

	/**Instantiates p2Place label*/
	static JLabel p2Place = new JLabel("Player Two Place your ships");

	/**Instantiates directions label*/
	static JLabel directions = new JLabel ("Player Two, set the coordinates "
			+ "							of your ship and the ship type");

	/**Instantiates front coordinate label*/
	static JLabel front = new JLabel("Front");

	/**Instantiates rear coordinate label*/
	static JLabel rear = new JLabel("Rear");

	/**Instantiates array containing ship names that will be included in
	 *the drop down menu of the J Combo box shipSel which is 
	 *created down below*/
	static String[] shipSelItems = {"Carrier", "Battleship", "Cruiser", "Submarine", "Patrol Boat"};

	/**Instantiates the JCombo box that allows the user to select which 
	 * ship they would like to place*/
	static JComboBox  shipSel = new JComboBox (shipSelItems);

	/**Instantiates donBtn*/
	static JButton strtBtn = new JButton ("Start Game");

	/**Instantiates placeBtn*/
	static JButton placeBtn = new JButton ("Place");

	/**Instantiates Player1Fire button that will be shown 
	 * after placement phase*/
	static JLabel Player1Fire = new JLabel("PLAYER ONE PICK A COORDINATE");

	/**Instantiates frontCo text field*/
	static JTextField frontCo = new JTextField (1);

	/**Instantiates rearCo text field*/
	static JTextField rearCo = new JTextField (1);

	/**Instantiates fireCo text field that will be shown
	 * during firing phase of the game*/
	static JTextField fireCoP2 = new JTextField (1);

	/**Instantiates fireBrn for the firing phase of the game*/
	static JButton fireBtnP2 = new JButton ("Fire");

	/**Creates an array of labels for the side of the grid
	 * to show the user the coordinates of each button on the grid*/
	JLabel[] colLabels = new JLabel[10];
	JLabel[] rowLabels = new JLabel[10]; 

	/**Sets the row and col label arrays to display desired x, y */
	String[] colLbl =  {"A","B","C","D","E","F","G","H","I","J"};
	String[] rowLbl =  {"1","2","3","4","5","6","7","8","9","10"};

	/**Instantiates 2d array of buttons for the grid*/
	private JButton[][] grid = new JButton[10][10];

	/**Lives int for calculating current players lives*/
	private static int lives = BshipPlaceP1.bsl.getLives(2);

	/**Creates lives Label for Player Two*/
	static JLabel Player2Lives = new JLabel("Player Two Lives Left: " + lives);

	//FIXME: ADDED
	/**Can't start game until All of Player's 2 ships are placed */
	private static int shipsToBePlaced = 5;

	/**Used to make sure all ships are placed before the done button can work as intended*/
	int ship;
	private int player2 = 2;

	/**Constructor for the frame and class*/
	BshipPlaceP2(){


		/**setting properties of the overall frame*/
		frame.setPreferredSize (new Dimension (944, 574));
		frame.setLayout (null);

		/**Adding Phase One items*/
		frame.add (strtBtn);
		frame.add (placeBtn);
		frame.add (shipSel);
		frame.add (front);
		frame.add (rear);
		frame.add (frontCo);
		frame.add (rearCo);
		frame.add (p2Place);
		frame.add (directions);

		/**Setting visibility of Phase One items*/
		BshipPlaceP2.strtBtn.setVisible(true);
		BshipPlaceP2.placeBtn.setVisible(true);
		BshipPlaceP2.frontCo.setVisible(true);
		BshipPlaceP2.rearCo.setVisible(true);
		BshipPlaceP2.p2Place.setVisible(true);
		BshipPlaceP2.front.setVisible(true);
		BshipPlaceP2.rear.setVisible(true);
		BshipPlaceP2.directions.setVisible(true);
		BshipPlaceP2.shipSel.setVisible(true);


		/**Adding Action listener for all buttons
		 * and intractable objects*/
		strtBtn.addActionListener(this);
		placeBtn.addActionListener(this);
		shipSel.addActionListener(this);
		fireBtnP2.addActionListener(this);



		// x, y, length, height
		/**Setting properties of items*/
		strtBtn.setBounds (10, 450, 115, 70);
		placeBtn.setBounds (10, 330, 100, 50);
		shipSel.setBounds (30, 160, 100, 25);
		front.setBounds (30, 225, 100, 25);
		rear.setBounds (130, 225, 100, 25);
		frontCo.setBounds (10, 275, 100, 25);
		rearCo.setBounds (125, 275, 100, 25);
		p2Place.setBounds (370, 35, 165, 45);
		directions.setBounds (5, 65, 460, 110);


		/**Phase two items or 
		 * firing phase items, hidden*/
		Player1Fire.setVisible(false);
		fireCoP2.setVisible(false);
		fireBtnP2.setVisible(false);
		Player2Lives.setVisible(false);

		/**Setting properties of firing phase*/
		Player1Fire.setBounds(370,35,300,45);
		fireCoP2.setBounds(100, 250, 100, 50);
		fireBtnP2.setBounds(100, 330, 100, 50);
		Player2Lives.setBounds (100, 200, 250, 50);

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
		 * Makes Player one place frame visible again
		 * sets ships placed from being shown on grid to be default color 
		 * If the ships are not all placed shows an error message*/
		if(e.getSource() == strtBtn) {

			if(0 == shipsToBePlaced) {
				for (int row = 0; row < rowLbl.length; row++) {
					for (int col = 0; col < colLbl.length; col++) {
						grid[row][col].setBackground(Color.WHITE);
					}
				}

				this.frame.setVisible(false);
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
				frame.add(Player2Lives);

				Player1Fire.setVisible(true);
				fireCoP2.setVisible(true);
				fireBtnP2.setVisible(true);
				Player2Lives.setVisible(true);

				BshipPlaceP1.Player2Fire.setVisible(true);
				BshipPlaceP1.fireBtn.setVisible(true);
				BshipPlaceP1.fireCo.setVisible(true);
				BshipPlaceP1.Player1Lives.setVisible(true);


			} else {
				//Prompt Error message.
				JOptionPane.showMessageDialog(frame, "Player 2, place all ships before proceeding", null, JOptionPane.ERROR_MESSAGE, null);
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
			int player2 = 2;

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

			String coord;
			int id;

			/**Checks if placeShip boolean is true, called from the
			 * battleshipLogic object*/
			if(BshipPlaceP1.bsl.placeShip( player2,  front,  rear,  ship)) {
				shipsToBePlaced--;

				for (int row = 0; row < rowLbl.length; row++) {
					for (int col = 0; col < colLbl.length; col++) {
						coord = colLbl[row] + rowLbl[col];
						id = BshipPlaceP1.bsl.getCoordinateData(coord, player2);
						/**Displays placed ship on grid*/
						if (1 == id) {
							grid[row][col].setBackground(Color.BLUE);
						}

						grid[row][col].setBounds(600 + (25*row),200 + (25*col),25,25);
						grid[row][col].addActionListener(this);
						frame.add(grid[row][col]);	
					}
				}

				shipSel.removeItem(shipSel.getSelectedItem());
			} else {
				/**Throws error message if placement is invalid*/
				JOptionPane.showMessageDialog(frame, "Player 2, invalid ship placement, try again.", null, JOptionPane.ERROR_MESSAGE, null);
			}
		}

		/**This button is shown during the firing phase of the game,
		 * player 1 will be setting a coordinate to be fired upon
		 * Calls placeHit function to determine hit
		 * An error will pop-up if the coordinate is either chosen already
		 * or if the coordinate is invalid*/
		if(e.getSource() == fireBtnP2) {


			/**Calls placeHit function */
			int hitResult = BshipPlaceP1.bsl.placeHit(fireCoP2.getText(), 1);

			/**Updates lives then sets text box for player one lives*/
			lives = BshipPlaceP1.bsl.getLives(2);
			Player2Lives.setText("Player Two Lives Left: " + lives);

			if(2 == hitResult) {
				/**Error message for invalid coordinates*/
				JOptionPane.showMessageDialog(frame, "Player 1, invalid coordinate, try again.", null, JOptionPane.ERROR_MESSAGE, null);
			}
			else {
				/**Checks for if the ships is hit or not
				 * Prompts will inform Player Two if the did or did not hit a ship*/
				if(0 == hitResult) {
					grid[BshipPlaceP1.bsl.getRowIndex(fireCoP2.getText())][BshipPlaceP1.bsl.getColIndex(fireCoP2.getText())].setBackground(Color.RED);	
					JOptionPane.showMessageDialog(frame, "Player 1, you did not hit a ship.", null, JOptionPane.PLAIN_MESSAGE, null);
				}
				if(1 == hitResult) {
					grid[BshipPlaceP1.bsl.getRowIndex(fireCoP2.getText())][BshipPlaceP1.bsl.getColIndex(fireCoP2.getText())].setBackground(Color.GREEN);
					//Prompt message that they hit a ship.
					JOptionPane.showMessageDialog(frame, "Player 1, you hit a ship!", null, JOptionPane.PLAIN_MESSAGE, null);
				}
				this.frame.setVisible(false);

				/**Checks lives to see if the game is over, otherwise the game continues
				 * If the game is over there will be a prompt that pops up to tell which player won*/
				if(BshipPlaceP1.bsl.isGameOver() == true) {
					if(BshipPlaceP1.bsl.getLives(1) == 0) {
						JOptionPane.showMessageDialog(frame, "Player 2 Wins!", null, JOptionPane.PLAIN_MESSAGE, null);
						System.out.println("Player Two Won");
						this.frame.dispose();
						BshipPlaceP2.frame.dispose();
						BshipPlaceP1.frame.removeAll();
						BshipPlaceP2.frame.removeAll();
						new BShipGOScreen();
					}else {
						JOptionPane.showMessageDialog(frame, "Player 1 Wins!", null, JOptionPane.PLAIN_MESSAGE, null);
						System.out.println("Player One Won");
						new BShipGOScreen();
						frame.dispose();
						BshipPlaceP1.frame.removeAll();
						BshipPlaceP2.frame.removeAll();

					}

				}else {

					Player1Fire.setVisible(true);
					fireCoP2.setVisible(true);
					fireBtnP2.setVisible(true);
					Player2Lives.setVisible(true);

					BshipPlaceP1.frame.setVisible(true);
					BshipPlaceP2.frame.add(BshipPlaceP2.fireBtnP2);
					BshipPlaceP2.frame.add(BshipPlaceP2.fireCoP2);
					BshipPlaceP2.frame.add(BshipPlaceP2.Player1Fire);
				}
			}
		}
	}
}
