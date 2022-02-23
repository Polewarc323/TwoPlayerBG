import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class cFourGOscreen implements ActionListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Game Over!");
	
	JButton newC4 = new JButton("Play again");
	JButton backToHub = new JButton("Back to Hub");
	
	cFourGOscreen(){
		
		label.setBounds(75,160,100,50);
		
		newC4.setBounds(50, 210, 300, 50);
		backToHub.setBounds(50, 260, 300, 50);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
		
		frame.add(label);
		frame.add(newC4);
		frame.add(backToHub);
		
		backToHub.addActionListener(this);
		newC4.addActionListener(this); 
	
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backToHub) {
			frame.dispose();
			HubGUI HubGUI = new HubGUI();
		}
		
		if(e.getSource() == newC4) {
			frame.dispose();
			C4Start C4Start = new C4Start();
			
		}
		
	}
}
