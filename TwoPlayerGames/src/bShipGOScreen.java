import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/****************************************************************************
*
*Game over screen for Battleship
*Allows user to go back to hub and play a different game
*or play another round of Battleship
*Class Implements Action Listener
*
*@author Christopher Polewarczyk
*@version January 25, 2022
*
*
*****************************************************************************/
public class bShipGOScreen implements ActionListener{
	
	/**Instantiates frame*/
	JFrame frame = new JFrame();
	
	/**Instantiates game over label*/
	JLabel label = new JLabel("Game Over!");
	
	/**Instantiates play again button*/
	JButton bShipEnd= new JButton("Play again");
	
	/**Instantiates back to hub button*/
	JButton backToHub = new JButton("Back to Hub");
	
	/**Constructs Game over Screen*/
	bShipGOScreen(){
		
		/**Set Placement of items*/
		label.setBounds(75,160,100,50);
		bShipEnd.setBounds(50, 210, 300, 50);
		backToHub.setBounds(50, 260, 300, 50);
		
		/**Set properties of frame*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
		
		/**Add Items to Frame*/
		frame.add(label);
		frame.add(bShipEnd);
		frame.add(backToHub);
		
		/**Add Action listener to buttons*/
		backToHub.addActionListener(this);
		bShipEnd.addActionListener(this); 
	
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		/**Go back to the hub*/
		if(e.getSource() == backToHub) {
			frame.dispose();
			new HubGUI();
		}
		
		/**Start a new Battleship game*/
		if(e.getSource() == bShipEnd) {
			frame.dispose();
			new BshipStart();
			
		}
		
	}
}
