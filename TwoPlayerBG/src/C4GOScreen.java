import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/****************************************************************************
*
*Game over screen for Connect Four
*Allows user to go back to hub and play a different game
*or play another round of Connect Four
*Class Implements Action Listener
*
*@author Christopher Polewarczyk
*@version January 25, 2022
*
*
*****************************************************************************/

public class C4GOScreen implements ActionListener {
	
	/**Instantiates frame*/
	JFrame frame = new JFrame();
	
	/**Instantiates game over label*/
	JLabel label = new JLabel("Game Over!");
	
	/**Instantiates play again button*/
	JButton newC4 = new JButton("Play again");
	
	/**Instantiates back to hub button*/
	JButton backToHub = new JButton("Back to Hub");
	
	/**Constructs Game over Screen*/
	C4GOScreen(){
		
		/**Set Placement of items*/
		label.setBounds(75, 160, 100, 50);
		newC4.setBounds(50, 210, 300, 50);
		backToHub.setBounds(50, 260, 300, 50);
		
		/**Set properties of frame*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
		
		/**Add Items to Frame*/
		frame.add(label);
		frame.add(newC4);
		frame.add(backToHub);
		
		/**Add Action listener to buttons*/
		backToHub.addActionListener(this);
		newC4.addActionListener(this); 
	
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		/**Go back to the hub*/
		if(e.getSource() == backToHub) {
			frame.dispose();
			new HubGUI();
		}
		
		/**Start a new Connect Four game*/
		if(e.getSource() == newC4) {
			frame.dispose();
			new C4Start();
			
		}
		
	}
}