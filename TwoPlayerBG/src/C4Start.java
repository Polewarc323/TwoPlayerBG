import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class C4Start implements ActionListener{
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Connect Four");
	
	JButton c4Start = new JButton("Start");
	JButton backToHub = new JButton("Back to Hub");

	
	C4Start(){
		
		label.setBounds(75,160,100,50);
		//label.setFont(new Font(null,Font.PLAIN,25));
		
		c4Start.setBounds(50, 210, 300, 50);
		backToHub.setBounds(50, 260, 300, 50);
		
		
		frame.add(label);
		frame.add(c4Start);
		frame.add(backToHub);
		
		backToHub.addActionListener(this);
		c4Start.addActionListener(this); 
	
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
		
		if(e.getSource() == c4Start) {
			frame.dispose();
			Connect4GUI Connect4GUI = new Connect4GUI();
		}
	}
}
