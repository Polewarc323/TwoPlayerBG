import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BshipStart implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Battleship");
	
	JButton bShipStrt= new JButton("Start");
	JButton backToHub = new JButton("Back to Hub");
	
	BshipStart(){
		
		label.setBounds(75,160,100,50);
		
		bShipStrt.setBounds(50, 210, 300, 50);
		backToHub.setBounds(50, 260, 300, 50);
		
		frame.add(label);
		frame.add(bShipStrt);
		frame.add(backToHub);
		
		backToHub.addActionListener(this);
		bShipStrt.addActionListener(this); 
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backToHub) {
			frame.dispose();
			HubGUI HubGUI = new HubGUI();
		}
		
		if(e.getSource() == bShipStrt) {
			frame.dispose();
			BshipPlaceP1 BshipPlaceP1 = new BshipPlaceP1();
		}
		
	}
}
