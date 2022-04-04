import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/****************************************************************************
*
*This Class is for the GUI of Connect Four
*Uses methods from Connect4Logic
*Implements Action Listener
*@author Christopher Polewarczyk
*
*@version February 7, 2022
*
*
*****************************************************************************/

public class Connect4GUI implements ActionListener {
	
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
	

	
	/*GUI Constructor*/
	Connect4GUI() {
		
		/*Adds Labels*/
		frame.add(c4Lbl);
		frame.add(CurrentPlayer);
		
		/*Sets properties for labels*/
		c4Lbl.setBounds(10, 10, 100, 100);
		CurrentPlayer.setBounds(30, 30, 100, 100);
		
		/*Set's text of labels*/
		CurrentPlayer.setText(curPlayer + "'s turn");
		c4Lbl.setText("Connect Four");
		
		/*Adds 6x7 grid of buttons*/
		for(int row = 0; row < 6; row++)
        	for(int col = 0; col< 7; col++){

        		grid[row][col] = new JButton("");
        		grid[row][col].setBounds(10 + (40*col),100 + (40*row),40,40);
        		grid[row][col].addActionListener(this);
        		frame.add(grid[row][col]);
        	}
		
		
		/*Sets frame properties*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*Checks grid for which button is pressed*/
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				if(e.getSource() == grid[i][j]) {
					
					/*Adds piece*/
					ConnectFour.board.addPiece(j, curPlayer);
					
					/*Checks which color to make button after click*/
					if(curPlayer == "Red") {
		
						grid[i][j].setBackground(Color.RED);
						grid[i][j].setBorder(null);
					}else{
						
						grid[i][j].setBackground(Color.YELLOW);
						grid[i][j].setBorder(null);
					}
					
					/*Checks for winner*/
					if(ConnectFour.checkForWinner(j, curPlayer) == true) {
						
						/*Shows which player won*/
						JOptionPane.showMessageDialog(frame, curPlayer + " wins!", null, JOptionPane.PLAIN_MESSAGE, null);
						System.out.println(curPlayer + " Wins!!");
						ConnectFour.reset(6,7);
						frame.dispose();
						new C4GOScreen();
					}else {
						
						/*Turn counter increments to determine what the current player is
						 * and updates accordingly*/
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
