import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Connect4GUI implements ActionListener {
	
	String curPlayer = ("Red");
	String red = ("Red");
	String yellow = ("Yellow");
	
	int turn = 0;
	
	
	JFrame frame = new JFrame();
	
	JLabel c4Lbl = new JLabel();
	JLabel CurrentPlayer = new JLabel();
	
	JButton[][] grid = new JButton[6][7];
	
	Connect4Logic ConnectFour = new Connect4Logic(red, yellow, 6, 7);
	
	Connect4GUI() {
		
		c4Lbl.setText("Connect Four");
		c4Lbl.setBounds(10, 10, 100, 100);
		frame.add(c4Lbl);
		CurrentPlayer.setText(curPlayer + "'s turn");
		CurrentPlayer.setBounds(30, 30, 100, 100);
		frame.add(CurrentPlayer);
		
		
		for(int row = 0; row < 6; row++)
        	for(int col = 0; col< 7; col++){

        		grid[row][col] = new JButton("");
        		grid[row][col].setBounds(10 + (40*col),100 + (40*row),40,40);
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
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if(e.getSource() == grid[i][j]) {
					
					System.out.println("i, j " + i  + ", " + j);
					System.out.println("Clicked");
					ConnectFour.board.addPiece(j, curPlayer);
					
					if(curPlayer == "Red") {
						grid[i][j].setBackground(Color.RED);
						grid[i][j].setBorder(null);
					}else{
						grid[i][j].setBackground(Color.YELLOW);
						grid[i][j].setBorder(null);
					}
					if(ConnectFour.checkForWinner(j, curPlayer) == true) {
						JOptionPane.showMessageDialog(frame, curPlayer + " wins!", null, JOptionPane.PLAIN_MESSAGE, null);
						System.out.println(curPlayer + " Wins!!");
						ConnectFour.reset(6,7);
						frame.dispose();
						new cFourGOscreen();
					}else {
						turn++;
						if((turn % 2) == 1) {
							curPlayer = yellow;
						}else {
							curPlayer = red; //this is unnecessary
						}
						CurrentPlayer.setText(curPlayer + "'s turn");



					}
				}
			}
		}

	}
}
