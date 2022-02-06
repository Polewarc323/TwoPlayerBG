import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class bShipGOScreen implements ActionListener{

	JFrame frame = new JFrame();
	JLabel label = new JLabel("Game Over!");
	
	JButton bShipEnd= new JButton("Play again");
	JButton backToHub = new JButton("Back to Hub");
	
	bShipGOScreen(){
		
		label.setBounds(75,160,100,50);
		
		bShipEnd.setBounds(50, 210, 300, 50);
		backToHub.setBounds(50, 260, 300, 50);
		
		frame.add(label);
		frame.add(bShipEnd);
		frame.add(backToHub);
		
		backToHub.addActionListener(this);
		bShipEnd.addActionListener(this); 
	
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
		
		if(e.getSource() == bShipEnd) {
			frame.dispose();
			BshipStart BshipStart = new BshipStart();
		}
		
	}
}
