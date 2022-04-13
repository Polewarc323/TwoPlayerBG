import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/****************************************************************************
*
*BshiStart is the starting screen for Battleship
*Allows the user to continue with playing battleship or go back to the hub
*to play a different game
*Class Implements Action Listener
*
*@author Christopher Polewarczyk
*@version January 25, 2022
*
*
*****************************************************************************/
public class BshipStart implements ActionListener {
	
	/**Instantiates frame JFrame*/
	JFrame frame = new JFrame();
	
	/**Instantiates Label for Battleship title*/
	JLabel label = new JLabel("Battleship");
	
	/**Instantiates Label for Battleship title*/
	JButton AIShip = new JButton("Battleship vs. Computer");
	
	/**Instantiates start button*/
	JButton bShipStrt= new JButton("Start");
	
	/**Instantiates backToHub button*/
	JButton backToHub = new JButton("Back to Hub");
	
	/**Creates Battleship start frame*/
	BshipStart(){
		
		/**Set placement of items*/
		label.setBounds(75,160,100,50);
		bShipStrt.setBounds(50, 210, 300, 50);
		AIShip.setBounds(50, 260, 300, 50);
		backToHub.setBounds(50, 310, 300, 50);
		
		/**Add items*/
		frame.add(label);
		frame.add(bShipStrt);
		frame.add(AIShip);
		frame.add(backToHub);
		
		/**Add action listeners to buttons*/
		backToHub.addActionListener(this);
		bShipStrt.addActionListener(this); 
		AIShip.addActionListener(this);
	
		/*Set frame Properties*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		/**Goes back to the hub*/
		if(e.getSource() == backToHub) {
			frame.dispose();
			new HubGUI();
		}
		/**Starts the game*/
		if(e.getSource() == bShipStrt) {
			frame.dispose();
			new BshipPlaceP1();
		}
		if(e.getSource() == AIShip) {
			frame.dispose();
			new BshipAI();
		}
		
	}
}
