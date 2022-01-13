package dodge_game;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Function_Edit {
	Game_GUI gui;
	
	//------------------spaceships---------------------------------------
	ImageIcon[] spaceships = {
			new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/spaceship/spaceship1.png"),
			new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/spaceship/spaceship2.png"),
			new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/spaceship/spaceship3.png"),
			new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/spaceship/spaceship4.png"),
			new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/spaceship/spaceship5.png"),
			new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/spaceship/spaceship6.png"),
			new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/spaceship/spaceship7.png")
	};
	Image[] img = new Image[spaceships.length];
	Image[] chgImg = new Image[spaceships.length];
	ImageIcon[] chgships = new ImageIcon[spaceships.length];
	JButton[] spaceship = new JButton[7];
	
	//-----------------player--------------------------------------------
	
	JLabel id;
	JTextField name;
	JButton ok;
	
	//--------------------------------Method-----------------------------
	public Function_Edit(Game_GUI gui) {
		this.gui = gui;
	}
	
	public void spaceship() {
		Spaceship spaceship = new Spaceship();
	}
	
	public void changeplayer() {
		Player player = new Player();
	}
	
	//---------------------------------Class------------------------------
	class Spaceship extends JFrame implements ActionListener{
		public Spaceship() {
			setTitle("Change spaceship");
			setLayout(new GridLayout(2, 4));
			setSize(400, 300);
			Dimension frameSize = this.getSize();
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    this.setLocation(((screenSize.width - frameSize.width) / 2), ((screenSize.height - frameSize.height) / 2));
		    
			for(int i = 0; i < 7; i++) {
				img[i] = spaceships[i].getImage();
				chgImg[i] = img[i].getScaledInstance(90, 120, Image.SCALE_SMOOTH);
				chgships[i] = new ImageIcon(chgImg[i]);
				spaceship[i] = new JButton(chgships[i]);
				spaceship[i].addActionListener(this);
				spaceship[i].setActionCommand("spaceship"+(i+1));
				String test = spaceship[i].getActionCommand();
				System.out.println(test);
				add(spaceship[i]);
			}
			
		    setVisible(true);
		}
		
		public void changeship1() {
			System.out.println("ok");
			gui.chgImg = img[0].getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			setVisible(false);
		}
		public void changeship2() {
			System.out.println("ok");
			gui.chgImg = img[1].getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			setVisible(false);
		}
		public void changeship3() {
			System.out.println("ok");
			gui.chgImg = img[2].getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			setVisible(false);
		}
		public void changeship4() {
			System.out.println("ok");
			gui.chgImg = img[3].getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			setVisible(false);
		}
		public void changeship5() {
			System.out.println("ok");
			gui.chgImg = img[4].getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			setVisible(false);
		}
		public void changeship6() {
			System.out.println("ok");
			gui.chgImg = img[5].getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			setVisible(false);
		}
		public void changeship7() {
			System.out.println("ok");
			gui.chgImg = img[6].getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			
			switch(command) {
			case "spaceship1" : changeship1(); break;
			case "spaceship2" : changeship2(); break;
			case "spaceship3" : changeship3(); break;
			case "spaceship4" : changeship4(); break;
			case "spaceship5" : changeship5(); break;
			case "spaceship6" : changeship6(); break;
			case "spaceship7" : changeship7(); break;
			}
		}
	}
	
	class Player extends JFrame implements ActionListener {
		
		public Player() {
			createwindow();
		}
		
		public void createwindow() {
			setTitle("Change Player");
			setSize(300, 200);
			setLayout(null);
			// no resizable
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			// location : center
			Dimension frameSize = this.getSize();
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    this.setLocation(((screenSize.width - frameSize.width) / 2), ((screenSize.height - frameSize.height) / 2));
		    
		    // id label
		    id = new JLabel("Player : ");
		    id.setBounds(10, 55, 50, 40);
		    add(id);
		    
		    // name textfield
		    name = new JTextField();
		    name.setBounds(60, 55, 200, 40);
		    name.setText("Change your name!");
		    name.setFont(new Font("Arial", Font.ITALIC, 20));
		    add(name);
		    
		    // ok button
		    ok = new JButton();
		    ok.setText("Change!");
		    ok.addActionListener(this);
		    ok.requestFocus();
		    ok.setFocusable(true);
		    ok.setActionCommand("Change!");
		    ok.setBounds(110, 120, 80, 30);
		    ok.setFont(new Font("Arial", Font.ITALIC, 15));
		    add(ok);
		 
		    setVisible(true);
		}
		
		public void changename() {
			gui.changename = name.getText();
			gui.name = "Player. " + gui.changename;
			setVisible(false);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			
			switch(command) {
			case "Change!" : changename(); break;
			}
		}
	}
}
