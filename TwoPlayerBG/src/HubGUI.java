import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HubGUI implements ActionListener {

	JFrame frame = new JFrame();


	JButton bShip = new JButton("BattleShip");
	JButton c4 = new JButton("Connect Four");


	JLabel welcome = new JLabel("Welcome to the Hub");
	JLabel info = new JLabel("Choose a game to start playing");
	
	
	
	HubGUI(){
		// x, y, length, height
		bShip.setBounds(100,200,200,25);
		bShip.setFocusable(false);
		bShip.addActionListener(this);

		
		c4.setBounds(100,160,200,25);
		c4.setFocusable(false);
		c4.addActionListener(this);
		
		welcome.setBounds(100, 80, 300, 50);
		info.setBounds(100, 100, 300, 50);
		
		frame.add(welcome);
		frame.add(info);
		frame.add(bShip);
		frame.add(c4);

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == bShip) {
			frame.dispose();
			BshipStart BshipStart = new BshipStart();

		}
		
		if(e.getSource()== c4) {
			frame.dispose();
			C4Start C4Start= new C4Start();

		}

	}




}
