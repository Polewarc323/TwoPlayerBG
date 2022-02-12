import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BshipMainP1 implements ActionListener {
	
	JFrame frame = new JFrame();
		
	JButton[][] grid = new JButton[10][10];
	
	
	BshipMainP1(){
		
		frame.setPreferredSize (new Dimension (944, 574));
        frame.setLayout (null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
		
		 for(int row = 0; row < 10; row++)
	        	for(int col = 0; col < 10; col++){

	        		grid[row][col] = new JButton("");
	        		grid[row][col].setBounds(600 + (25*row),200 + (25*col),25,25);
	        		grid[row][col].addActionListener(this);
	        		frame.add(grid[row][col]);
	        	}
		
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
