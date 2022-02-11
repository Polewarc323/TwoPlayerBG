import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BshipPlaceP1 implements ActionListener{

	

	JFrame frame = new JFrame();


	JLabel p1Place = new JLabel("Player One Place your ships");
	JLabel directions = new JLabel ("Player One, set the coordinates of your ship and the ship type");
	JLabel front = new JLabel("Front");
	JLabel rear = new JLabel("Rear");

	//construct preComponents
	String[] shipSelItems = {"Carrier", "Battleship", "Cruiser", "Submarine", "Patrol Boat"};

	//construct components

	JComboBox  shipSel = new JComboBox (shipSelItems);

	JButton donBtn = new JButton ("Done");
	JButton placeBtn = new JButton ("Place");

	JTextField frontCo = new JTextField (1);
	JTextField rearCo = new JTextField (1);


	JButton a1 = new JButton();
	JButton a2 = new JButton();
	JButton a3 = new JButton();
	JButton a4 = new JButton();
	JButton a5 = new JButton();
	JButton a6 = new JButton();
	JButton a7 = new JButton();
	JButton a8 = new JButton();
	JButton a9 = new JButton();
	JButton a10 = new JButton();
	
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();
	JButton b7 = new JButton();
	JButton b8 = new JButton();
	JButton b9 = new JButton();
	JButton b10 = new JButton();

	JButton c1 = new JButton();
	JButton c2 = new JButton();
	JButton c3 = new JButton();
	JButton c4 = new JButton();
	JButton c5 = new JButton();
	JButton c6 = new JButton();
	JButton c7 = new JButton();
	JButton c8 = new JButton();
	JButton c9 = new JButton();
	JButton c10 = new JButton();
	
	JButton d1 = new JButton();
	JButton d2 = new JButton();
	JButton d3 = new JButton();
	JButton d4 = new JButton();
	JButton d5 = new JButton();
	JButton d6 = new JButton();
	JButton d7 = new JButton();
	JButton d8 = new JButton();
	JButton d9 = new JButton();
	JButton d10 = new JButton();
	
	JButton e1 = new JButton();
	JButton e2 = new JButton();
	JButton e3 = new JButton();
	JButton e4 = new JButton();
	JButton e5 = new JButton();
	JButton e6 = new JButton();
	JButton e7 = new JButton();
	JButton e8 = new JButton();
	JButton e9 = new JButton();
	JButton e10 = new JButton();
	
	JButton f1 = new JButton();
	JButton f2 = new JButton();
	JButton f3 = new JButton();
	JButton f4 = new JButton();
	JButton f5 = new JButton();
	JButton f6 = new JButton();
	JButton f7 = new JButton();
	JButton f8 = new JButton();
	JButton f9 = new JButton();
	JButton f10 = new JButton();
	
	JButton g1 = new JButton();
	JButton g2 = new JButton();
	JButton g3 = new JButton();
	JButton g4 = new JButton();
	JButton g5= new JButton();
	JButton g6 = new JButton();
	JButton g7 = new JButton();
	JButton g8 = new JButton();
	JButton g9 = new JButton();
	JButton g10 = new JButton();
	
	JButton h1 = new JButton();
	JButton h2 = new JButton();
	JButton h3 = new JButton();
	JButton h4 = new JButton();
	JButton h5 = new JButton();
	JButton h6 = new JButton();
	JButton h7 = new JButton();
	JButton h8 = new JButton();
	JButton h9 = new JButton();
	JButton h10 = new JButton();
	
	JButton i1 = new JButton();
	JButton i2 = new JButton();
	JButton i3 = new JButton();
	JButton i4 = new JButton();
	JButton i5 = new JButton();
	JButton i6 = new JButton();
	JButton i7 = new JButton();
	JButton i8 = new JButton();
	JButton i9 = new JButton();
	JButton i10 = new JButton();
	
	JButton j1 = new JButton();
	JButton j2 = new JButton();
	JButton j3 = new JButton();
	JButton j4 = new JButton();
	JButton j5 = new JButton();
	JButton j6 = new JButton();
	JButton j7 = new JButton();
	JButton j8 = new JButton();
	JButton j9 = new JButton();
	JButton j10 = new JButton();
	
	

	BshipPlaceP1(){

	
		
		//adjust size and set layout
		frame.setPreferredSize (new Dimension (944, 574));
		frame.setLayout (new FlowLayout(FlowLayout.CENTER, 100, 100));

		//add components
		frame.add (donBtn);
		frame.add (placeBtn);
		frame.add (shipSel);
		frame.add (front);
		frame.add (rear);
		frame.add (frontCo);
		frame.add (rearCo);
		frame.add (p1Place);
		frame.add (directions);
		
		frame.add (a1);
		frame.add (a2);
		frame.add (a3);
		frame.add (a4);
		frame.add (a5);
		frame.add (a6);
		frame.add (a7);
		frame.add (a8);
		frame.add (a9);
		frame.add (a10);
		
		frame.add (b1);
		frame.add (b2);
		frame.add (b3);
		frame.add (b4);
		frame.add (b5);
		frame.add (b6);
		frame.add (b7);
		frame.add (b8);
		frame.add (b9);
		frame.add (b10);
		
		frame.add (c1);
		frame.add (c2);
		frame.add (c3);
		frame.add (c4);
		frame.add (c5);
		frame.add (c6);
		frame.add (c7);
		frame.add (c8);
		frame.add (c9);
		frame.add (c10);
		
		frame.add (d1);
		frame.add (d2);
		frame.add (d3);
		frame.add (d4);
		frame.add (d5);
		frame.add (d6);
		frame.add (d7);
		frame.add (d8);
		frame.add (d9);
		frame.add (d10);
		
		frame.add (e1);
		frame.add (e2);
		frame.add (e3);
		frame.add (e4);
		frame.add (e5);
		frame.add (e6);
		frame.add (e7);
		frame.add (e8);
		frame.add (e9);
		frame.add (e10);
		
		frame.add (f1);
		frame.add (f2);
		frame.add (f3);
		frame.add (f4);
		frame.add (f5);
		frame.add (f6);
		frame.add (f7);
		frame.add (f8);
		frame.add (f9);
		frame.add (f10);
	
		frame.add (g1);
		frame.add (g2);
		frame.add (g3);
		frame.add (g4);
		frame.add (g5);
		frame.add (g6);
		frame.add (g7);
		frame.add (g8);
		frame.add (g9);
		frame.add (g10);
		
		frame.add (h1);
		frame.add (h2);
		frame.add (h3);
		frame.add (h4);
		frame.add (h5);
		frame.add (h6);
		frame.add (h7);
		frame.add (h8);
		frame.add (h9);
		frame.add (h10);
		
		frame.add (i1);
		frame.add (i2);
		frame.add (i3);
		frame.add (i4);
		frame.add (i5);
		frame.add (i6);
		frame.add (i7);
		frame.add (i8);
		frame.add (i9);
		frame.add (i10);
		
		frame.add (j1);
		frame.add (j2);
		frame.add (j3);
		frame.add (j4);
		frame.add (j5);
		frame.add (j6);
		frame.add (j7);
		frame.add (j8);
		frame.add (j9);
		frame.add (j10);
		

		donBtn.addActionListener(this);

		// x, y, length, height
		//set component bounds (only needed by Absolute Positioning)
		donBtn.setBounds (10, 450, 115, 70);
		placeBtn.setBounds (10, 330, 100, 50);
		shipSel.setBounds (30, 160, 100, 25);
		front.setBounds (30, 225, 100, 25);
		rear.setBounds (130, 225, 100, 25);
		frontCo.setBounds (10, 275, 100, 25);
		rearCo.setBounds (125, 275, 100, 25);
		p1Place.setBounds (370, 35, 165, 45);
		directions.setBounds (5, 65, 460, 110);
		
		a1.setBounds(600,200,25,25);
		a2.setBounds(625,200,25,25);
		a3.setBounds(650,200,25,25);
		a4.setBounds(675,200,25,25);
		a5.setBounds(700,200,25,25);
		a6.setBounds(725,200,25,25);
		a7.setBounds(750,200,25,25);
		a8.setBounds(775,200,25,25);
		a9.setBounds(800,200,25,25);
		a10.setBounds(825,200,25,25);
		
		b1.setBounds(600,225,25,25);
		b2.setBounds(625,225,25,25);
		b3.setBounds(650,225,25,25);
		b4.setBounds(675,225,25,25);
		b5.setBounds(700,225,25,25);
		b6.setBounds(725,225,25,25);
		b7.setBounds(750,225,25,25);
		b8.setBounds(775,225,25,25);
		b9.setBounds(800,225,25,25);
		b10.setBounds(825,225,25,25);
		
		c1.setBounds(600,250,25,25);
		c2.setBounds(625,250,25,25);
		c3.setBounds(650,250,25,25);
		c4.setBounds(675,250,25,25);
		c5.setBounds(700,250,25,25);
		c6.setBounds(725,250,25,25);
		c7.setBounds(750,250,25,25);
		c8.setBounds(775,250,25,25);
		c9.setBounds(800,250,25,25);
		c10.setBounds(825,250,25,25);
		
		d1.setBounds(600,275,25,25);
		d2.setBounds(625,275,25,25);
		d3.setBounds(650,275,25,25);
		d4.setBounds(675,275,25,25);
		d5.setBounds(700,275,25,25);
		d6.setBounds(725,275,25,25);
		d7.setBounds(750,275,25,25);
		d8.setBounds(775,275,25,25);
		d9.setBounds(800,275,25,25);
		d10.setBounds(825,275,25,25);
		
		e1.setBounds(600,300,25,25);
		e2.setBounds(625,300,25,25);
		e3.setBounds(650,300,25,25);
		e4.setBounds(675,300,25,25);
		e5.setBounds(700,300,25,25);
		e6.setBounds(725,300,25,25);
		e7.setBounds(750,300,25,25);
		e8.setBounds(775,300,25,25);
		e9.setBounds(800,300,25,25);
		e10.setBounds(825,300,25,25);
		
		f1.setBounds(600,325,25,25);
		f2.setBounds(625,325,25,25);
		f3.setBounds(650,325,25,25);
		f4.setBounds(675,325,25,25);
		f5.setBounds(700,325,25,25);
		f6.setBounds(725,325,25,25);
		f7.setBounds(750,325,25,25);
		f8.setBounds(775,325,25,25);
		f9.setBounds(800,325,25,25);
		f10.setBounds(825,325,25,25);
	
		g1.setBounds(600,350,25,25);
		g2.setBounds(625,350,25,25);
		g3.setBounds(650,350,25,25);
		g4.setBounds(675,350,25,25);
		g5.setBounds(700,350,25,25);
		g6.setBounds(725,350,25,25);
		g7.setBounds(750,350,25,25);
		g8.setBounds(775,350,25,25);
		g9.setBounds(800,350,25,25);
		g10.setBounds(825,350,25,25);
		
		h1.setBounds(600,350,25,25);
		h2.setBounds(625,350,25,25);
		h3.setBounds(650,350,25,25);
		h4.setBounds(675,350,25,25);
		h5.setBounds(700,350,25,25);
		h6.setBounds(725,350,25,25);
		h7.setBounds(750,350,25,25);
		h8.setBounds(775,350,25,25);
		h9.setBounds(800,350,25,25);
		h10.setBounds(825,350,25,25);
		
		i1.setBounds(600,375,25,25);
		i2.setBounds(625,375,25,25);
		i3.setBounds(650,375,25,25);
		i4.setBounds(675,375,25,25);
		i5.setBounds(700,375,25,25);
		i6.setBounds(725,375,25,25);
		i7.setBounds(750,375,25,25);
		i8.setBounds(775,375,25,25);
		i9.setBounds(800,375,25,25);
		i10.setBounds(825,375,25,25);
		
		j1.setBounds(600,400,25,25);
		j2.setBounds(625,400,25,25);
		j3.setBounds(650,400,25,25);
		j4.setBounds(675,400,25,25);
		j5.setBounds(700,400,25,25);
		j6.setBounds(725,400,25,25);
		j7.setBounds(750,400,25,25);
		j8.setBounds(775,400,25,25);
		j9.setBounds(800,400,25,25);
		j10.setBounds(825,400,25,25);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true); 


	}



	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == donBtn) {
			frame.dispose();
			BshipPlaceP2 BshipPlaceP2 = new BshipPlaceP2();
		}

	}
}
