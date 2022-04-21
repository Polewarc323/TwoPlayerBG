import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class C4AI implements ActionListener {
	
	/*used to determine player*/
	String curPlayer = ("Red");
	String red = ("Red");
	String yellow = ("Yellow");
	
	/*Turn Counter to determine Player*/
	int turn = 0;
	
	/*Creates Frame*/
	JFrame frame = new JFrame();
	
	/*Creates Game Title*/
	JLabel c4Lbl = new JLabel();
	
	/*Creates Current Player Label*/
	JLabel CurrentPlayer = new JLabel();
	
	/*Creates a 6x7 2d array of buttons*/
	JButton[][] grid = new JButton[6][7];
	
	/*Creates a Connect4Logic object to call methods from*/
	Connect4Logic ConnectFour = new Connect4Logic(red, yellow, 6, 7);
	
	C4AI(){
		
		/*Sets frame properties*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,750);
		frame.setLayout(null);
		frame.setVisible(true); 
		frame.getContentPane().setBackground(Color.MAGENTA);
		frame.add(c4Lbl);
		c4Lbl.setBounds(10, 10, 100, 100);
		
		/*Adds 6x7 grid of buttons*/
		for(int row = 0; row < 6; row++)
        	for(int col = 0; col< 7; col++){

        		grid[row][col] = new JButton("");
        		grid[row][col].setBounds(50 + (75*col),100 + (75*row),75,75);
        		grid[row][col].addActionListener(this);
        		frame.add(grid[row][col]);
        		grid[row][col].setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
        	}
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*Checks grid for which button is pressed*/
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if(e.getSource() == grid[i][j]) {
						int AIt;
					curPlayer = red;
					ConnectFour.board.addPiece(j, red);
					grid[i][j].setBackground(Color.RED);
					grid[i][j].setBorder(null);
					/*Checks for winner*/
					if(ConnectFour.checkForWinner(j, curPlayer) == true) {
						
						/*Shows which player won*/
						JOptionPane.showMessageDialog(frame, curPlayer + " wins!", null, JOptionPane.PLAIN_MESSAGE, null);
						System.out.println(curPlayer + " Wins!!");
						ConnectFour.reset(6,7);
						frame.dispose();
						new C4GOScreen();
					}
					
					curPlayer = yellow;
					AIt = ConnectFour.board.AIadd(yellow);
					grid[i][AIt].setBackground(Color.YELLOW);
					grid[i][AIt].setBorder(null);
					
				
					
					/*Checks for winner*/
					if(ConnectFour.checkForWinner(j, curPlayer) == true) {
						
						/*Shows which player won*/
						JOptionPane.showMessageDialog(frame, curPlayer + " wins!", null, JOptionPane.PLAIN_MESSAGE, null);
						System.out.println(curPlayer + " Wins!!");
						ConnectFour.reset(6,7);
						frame.dispose();
						new C4GOScreen();
					}

				}
			}
		}
	}

}


