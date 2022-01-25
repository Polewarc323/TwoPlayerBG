import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HubGUI  {
	
	
	public static void HUB() {
		
		 JFrame frame = new JFrame();
		 
		 JButton bShip = new JButton("BattleShip"); 
		 
		 JButton c4 = new JButton("Connect Four");
		 
		 
		 JLabel welcome = new JLabel("Welcome to the Hub");
		 JLabel info = new JLabel("Choose a game to start playing");
		 JPanel panel = new JPanel();
		 
		 
		 
		 
		 
		// Parameters for width of Top, Bottom, Left, Right
		 panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,300));
		 panel.setLayout(new GridLayout(0, 1));
		 panel.add(welcome);
		 panel.add(info);
		 panel.add(bShip);
		 panel.add(c4);
		 
		 frame.add(panel, BorderLayout.CENTER);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setTitle("HUB");
		 frame.pack();
		 frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {	
		HUB();
	}
	//Start Screen
	//BattleShip Button
	//Connect 4 Button
	//Close


	
}
