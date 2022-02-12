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

	

	JFrame frame = new JFrame();


	JLabel p1Place = new JLabel("Player One Place your ships");
	JLabel directions = new JLabel ("Player One, set the coordinates of your ship and the ship type");
	JLabel front = new JLabel("Front");
	JLabel rear = new JLabel("Rear");

	//construct preComponents
	String[] shipSelItems = {"Carrier", "Battleship", "Cruiser", "Submarine", "Patrol Boat"};

	//construct components

	JComboBox  shipSel = new JComboBox (shipSelItems);

	JButton donBtn = new JButton ("Done");
	JButton placeBtn = new JButton ("Place");

	JTextField frontCo = new JTextField (1);
	JTextField rearCo = new JTextField (1);


	JButton[][] grid = new JButton[10][10];
	

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
		
		

		donBtn.addActionListener(this);

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
		

		for(int row = 0; row < 10; row++)
		     for(int col = 0; col < 10; col++){
		    	 
		    	 grid[row][col] = new JButton("");
		    	 grid[row][col].setBounds(600 + (25*row),200 + (25*col),25,25);
		    	 grid[row][col].addActionListener(this);
		    	 frame.add(grid[row][col]);
		    }

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 


	}



	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == donBtn) {
			frame.dispose();
			BshipPlaceP2 BshipPlaceP2 = new BshipPlaceP2();
		}
		
		if(e.getSource() == placeBtn) {
			
		}

	}
}