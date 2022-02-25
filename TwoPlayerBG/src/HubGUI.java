import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/****************************************************************************
*
*The HubGUI class is the class that creates the frame for the selection of 
*games. 
*HubGUI uses buttons for the selection of the games and when the button is 
*clicked the user is brought to the games start screen
*Class Implements Action Listener
*
*@author Christopher Polewarczyk
*@version January 25, 2022
*
*
*****************************************************************************/
public class HubGUI implements ActionListener {
	
	/**Instantiates frame JFrame*/
	JFrame frame = new JFrame();

	/**Instantiates bShip button*/
	JButton bShip = new JButton("BattleShip");
	
	/**Instantiates c4 button*/
	JButton c4 = new JButton("Connect Four");

	/**Instantiates welcome label*/
	JLabel welcome = new JLabel("Welcome to the Hub");
	
	/**Instantiates info label*/
	JLabel info = new JLabel("Choose a game to start playing");
	
	
	/**Constructor class for HubGUI*/
	HubGUI(){
		
		/**Set properties of bShip button*/
		bShip.setBounds(100,200,200,25);
		bShip.setFocusable(false);
		bShip.addActionListener(this);

		/**Set properties of c4 button*/
		c4.setBounds(100,160,200,25);
		c4.setFocusable(false);
		c4.addActionListener(this);
		
		/**Set bounds of labels welcome and info*/
		welcome.setBounds(100, 80, 300, 50);
		info.setBounds(100, 100, 300, 50);
		
		/** Adds buttons and labels to the frame*/
		frame.add(welcome);
		frame.add(info);
		frame.add(bShip);
		frame.add(c4);

		/**Set properties of frame itself*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**Actions performed when bShip button is clicked, disposing
		 * of the HubGUI frame and creating the BshipStart frame*/
		if(e.getSource() == bShip) {
			frame.dispose();
			new BshipStart();

		}
		/**Actions performed when bShip button is clicked, disposing
		 * of the HubGUI frame and creating the c4Start frame*/
		if(e.getSource()== c4) {
			frame.dispose();
			new C4Start();

		}

	}




}
