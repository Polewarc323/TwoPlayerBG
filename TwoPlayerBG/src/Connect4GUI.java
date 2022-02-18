import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Connect4GUI implements ActionListener {
	
	String curPlayer = ("Red");
	String red = ("Red");
	String yellow = ("Yellow");
	
	int turn = 0;
	
	
	JFrame frame = new JFrame();
	
	JLabel c4Lbl = new JLabel();
	
	JButton[][] grid = new JButton[7][6];
	
	Connect4Logic ConnectFour = new Connect4Logic(red, yellow, 7, 6);
	
	Connect4GUI() {
		
		c4Lbl.setText("Connect Four");
		c4Lbl.setBounds(10, 10, 100, 100);
		frame.add(c4Lbl);
		
		
		for(int row = 0; row < 7; row++)
        	for(int col = 0; col< 6; col++){

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
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6; j++) {
				if(e.getSource() == grid[i][j]) {
					turn++;
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
					ConnectFour.checkForWinner(j, curPlayer);
					if(ConnectFour.checkForWinner(i, curPlayer) == true) {
						System.out.println(curPlayer + " Wins!!");
						ConnectFour.reset(7,6);
						frame.dispose();
						cFourGOscreen gameOver = new cFourGOscreen();
					}else {

						if((turn % 2) == 1) {
							curPlayer = yellow;
						}else {
							curPlayer = red; //this is unnecessary
						}

				
					}
				}
			}
		}

	}
}
