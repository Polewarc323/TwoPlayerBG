import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/****************************************************************************
*
*C4Start is the start screen for Connect Four
*Allows the user to continue with playing Connect Four or go back to the hub
*to play a different game
*Class Implements Action Listener
*
*@author Christopher Polewarczyk
*@version January 25, 2022
*
*
*****************************************************************************/
public class C4Start implements ActionListener{
	
	/**Instantiates frame JFrame*/
	JFrame frame = new JFrame();
	
	/**Instantiates Label for Battleship title*/
	JLabel label = new JLabel("Connect Four");
	
	/**Instantiates Two Player button*/
	JButton c4Start = new JButton("Two Player");
	
	/**Instantiates c4Bot button*/
	JButton c4Bot = new JButton("Connect Four w/ AI");
	
	/**Instantiates backToHub button*/
	JButton backToHub = new JButton("Back to Hub");

	/**Creates Connect Four start frame*/
	C4Start(){
		
		/**Set placement of items*/
		label.setBounds(75,100,100,50);
		c4Start.setBounds(50, 160, 300, 50);
		c4Bot.setBounds(50, 210, 300, 50);
		backToHub.setBounds(50, 260, 300, 50);
		
		/**Add items*/
		frame.add(label);
		frame.add(c4Start);
		frame.add(c4Bot);
		frame.add(backToHub);
		
		/**Add action listeners to buttons*/
		backToHub.addActionListener(this);
		c4Start.addActionListener(this); 
		c4Bot.addActionListener(this);
		
		/*Set frame Properties*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
		frame.getContentPane().setBackground(Color.BLUE);
		
		label.setForeground(Color.WHITE);
		c4Bot.setBackground(Color.CYAN);
		backToHub.setBackground(Color.CYAN);
		c4Start.setBackground(Color.CYAN);
		c4Bot.setForeground(Color.BLUE);
		backToHub.setForeground(Color.BLUE);
		c4Start.setForeground(Color.BLUE);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		/**Goes back to the hub*/
		if(e.getSource() == backToHub) {
			frame.dispose();
			new HubGUI();
		}
		
		/**Starts the game*/
		if(e.getSource() == c4Start) {
			frame.dispose();
			new Connect4GUI();
		}
		
		if(e.getSource() ==  c4Bot) {
			frame.dispose();
			new C4AI();
		}
	}
}
