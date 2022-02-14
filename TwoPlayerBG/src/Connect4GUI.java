import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Connect4GUI implements ActionListener {
	
	JFrame frame = new JFrame();
	
	JLabel JOEY = new JLabel();
	
	JButton[][] grid = new JButton[7][6];
	
	Board Board = new Board(6,7);
	
	Connect4GUI() {
		
		JOEY.setText("Connect Four");
		JOEY.setBounds(10, 10, 100, 100);
		frame.add(JOEY);
		
		
		for(int row = 0; row < 7; row++)
        	for(int col = 0; col < 6; col++){

        		grid[row][col] = new JButton("");
        		grid[row][col].setBounds(10 + (40*row),100 + (40*col),40,40);
        		grid[row][col].addActionListener(this);
        		frame.add(grid[row][col]);
        	}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
