package dodge_game;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.*;
import java.awt.image.*;

public class Game_GUI extends JFrame implements ActionListener {	
	
	// Create Background image
	ImageIcon BackImg = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/background/Background.jpg");
    Image backImg = BackImg.getImage();
    
    ImageIcon StartImg = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/background/StartBackground.jpg");
    Image startImg = StartImg.getImage();
    
    // Create Instagram image
    ImageIcon Instagram = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/sns/instagram.png");
    Image instagram = Instagram.getImage();
    Image chinstagram = instagram.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon chInstagram = new ImageIcon(chinstagram);
    
    // Create Facebook image
    ImageIcon Facebook = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/sns/facebook.png");
    Image facebook = Facebook.getImage();
    Image chfacebook = facebook.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon chFacebook = new ImageIcon(chfacebook);
    
    ImageIcon Start = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/background/start.png");
    Image start = Start.getImage();
    Image chstart = start.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    ImageIcon chStart = new ImageIcon(chstart);
    
    // Font on the background
    private JLabel top, content;
    
    // Create Nickname textField
    public JTextField nick;
    
    // Create SNS share spot & start
    private JButton ig, fb, st;
    
    // Create MenuBar
    private JMenuBar menubar;
    
    // Menu Tab
    private JMenu menuEdit, menuRank, menuRecord, menuHelp;
    
    // Edit
    private JMenuItem iShip, iName; 
    
    // Rank
    private JMenuItem iRank;
    
    // Recording
    private JMenuItem iRecord, iReplay;
    
    // Help
    private JMenuItem iHow, iContact;
    
    // thread
    private Thread textThread = null;
    private Thread spaceshipThread = null;
    
    // spaceship
    private ImageIcon spaceship;
    public Image img, chgImg;
    private int center_x, center_y;
      
    // face
    private ImageIcon face;
    private Image img2, chgImg2;
    
    // bullet
    private ImageIcon bullet;
    private Image obullet, chgbullet;
    
    // bullet2
    private ImageIcon bullet2;
    private Image obullet2, chgbullet2;
    
    // player
    public String name, changename;
    
    // count time
    public String time, ss, ms;
    
    // Connectivity
    Function_Edit edit = new Function_Edit(this);
    Function_Rank rank = new Function_Rank(this);
    Function_Help help = new Function_Help(this);
    
    //----------------------------Method------------------------------------
	public Game_GUI() {
		
		createMenubar();
		createEditMenu();
		createRankMenu();
		createHelpMenu();
		createMain();
	}
	
	public void createMain() {
		
		setTitle("DODGE GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Size & Location(center)
		setSize(800, 600);
	    Dimension frameSize = this.getSize();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setLocation(((screenSize.width - frameSize.width) / 2), ((screenSize.height - frameSize.height) / 2));
	   
	    // Create background
	    Background background = new Background();
	    background.setLayout(null);
	    add(background);
	    
	    // Create Font
	    top = new JLabel();
	    top.setText("DODGE GAME");
	    top.setFont(new Font("Arial", Font.BOLD, 80));
	    top.setBounds(120, 50, 600, 200);
	    top.setForeground(Color.yellow);
	    top.setVisible(true);
	    background.add(top);  
	    
	    // Add random text thread
	    background.add(new Content());
	    
	    // Add nickname
	    nick = new JTextField();
	    nick.setBounds(300, 300, 200, 40);
	    nick.setText("Nickname");
	    nick.setBackground(Color.black);
	    nick.setForeground(Color.white);
	    nick.setFont(new Font("Arial", Font.ITALIC, 20));
	    nick.setVisible(true);
	    background.add(nick);
	    
	    // Add instagram
	    ig = new JButton(chInstagram);
		ig.setBounds(650, 470, 50, 50);
		ig.setBorderPainted(false);
		ig.setVisible(true);
		ig.addActionListener(this);
		ig.setActionCommand("instagram");
		background.add(ig);
		
		// Add facebook
		fb = new JButton(chFacebook);
		fb.setBounds(710, 470, 50, 50);
		fb.setBorderPainted(false);
		fb.setVisible(true);
		fb.addActionListener(this);
		fb.setActionCommand("facebook");
		background.add(fb);
		
		// Add start button
		st = new JButton(chStart);
		st.addActionListener(this);
		st.setActionCommand("start");
		st.setBounds(360, 350, 70, 70);
		st.setBorderPainted(false);
		st.setVisible(true);
		background.add(st);
	    	    
	    setVisible(true);
	    setResizable(false);
	}
	
	public void createMenubar() {
		menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		
		menuEdit = new JMenu("Edit");
		menubar.add(menuEdit);
		
		menuRank = new JMenu("Rank");
		menubar.add(menuRank);
		
		menuHelp = new JMenu("Help");
		menubar.add(menuHelp);
	}
	
	public void createEditMenu() {
		iShip = new JMenuItem("Change Spaceship");
		iShip.addActionListener(this);
		iShip.setActionCommand("Change SpaceShip");
		menuEdit.add(iShip);
		
		iName = new JMenuItem("Change Player");
		iName.addActionListener(this);
		iName.setActionCommand("Change Player");
		menuEdit.add(iName);
	}
	
	public void createRankMenu() {
		iRank = new JMenuItem("Rank");
		iRank.addActionListener(this);
		iRank.setActionCommand("Rank");
		menuRank.add(iRank);
	}
	
	public void createHelpMenu() {
		iHow = new JMenuItem("How to play");
		iHow.addActionListener(this);
		iHow.setActionCommand("How to play");
		menuHelp.add(iHow);
		
		menuHelp.addSeparator();

		
		iContact = new JMenuItem("Contact to engineer");
		iContact.addActionListener(this);
		iContact.setActionCommand("Contact to engineer");
		menuHelp.add(iContact);
	}
	
	public void createStart() {
		setTitle("DODGE GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Size & Location(center)
		setSize(800, 600);
	    Dimension frameSize = this.getSize();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setLocation(((screenSize.width - frameSize.width) / 2), ((screenSize.height - frameSize.height) / 2));
	   
	    // remove main icon
	    textThread.interrupt();
	    top.setVisible(false);
	    nick.setVisible(false);
	    ig.setVisible(false);
	    fb.setVisible(false);
	    st.setVisible(false);
	    System.out.println("remove main icon");
	    
	    // spaceship image
	    // convert image
	    spaceship = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/spaceship/spaceship1.png");
	    img = spaceship.getImage();
	    chgImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	   
	    // location of center
	    center_x = frameSize.width / 2;
	    center_y = frameSize.height / 2;
	    
	    // face image
	    // convert image
	    face = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/background/start_dodge.png");
	    img2 = face.getImage();
	    chgImg2 = img2.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	    
	    // bullet image
	    // convert image
	    bullet = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/bullet/bullet.png");
	    obullet = bullet.getImage();
	    chgbullet = obullet.getScaledInstance(5, 5, Image.SCALE_SMOOTH);
	    
	    // convert image
	    bullet2 = new ImageIcon("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/imgs/bullet/bullet2.png");
	    obullet2 = bullet2.getImage();
	    chgbullet2 = obullet2.getScaledInstance(5, 5, Image.SCALE_SMOOTH);
	    
	    changename = nick.getText();
	    
	    // Create startship window
	    Startmotion startmotion = new Startmotion(this);
	    addKeyListener(startmotion);
	    requestFocus();
	    setFocusable(true);
	    startmotion.setLayout(null);
	    add(startmotion);    
	    
	    System.out.println("create start");
	    
	    setVisible(true);
	    setResizable(false);
	}
	
	public void instagram() {
		String link = "https://www.instagram.com/";
		
		try { 
			Desktop.getDesktop().browse(new URI(link)); 
		}catch(IOException e) {
			e.printStackTrace();
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void facebook() {
		String link = "https://www.facebook.com/";
		
		try { 
			Desktop.getDesktop().browse(new URI(link)); 
		}catch(IOException e) {
			e.printStackTrace();
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	//------------------------------Class----------------------------------
	
	// Paint main background
	class Background extends JPanel{
		public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(backImg,0,0,getWidth(),getHeight(), null);
        }
	}
	
	// Random text Thread
	class Content extends JLabel implements Runnable{

		public Content() {
			setText(texts());
			setFont(new Font("Arial", Font.ITALIC, 30));
			setHorizontalAlignment(JLabel.CENTER);
			setBounds(100, 150, 600, 200);
			setForeground(Color.yellow);
				
			textThread = new Thread(Content.this);
			textThread.start();
		}
			
		public String texts() {
			String texts[] = {"Don't run into bullet!", "Persist in there to the last!", "Set a new record!"};
			int random = (int)(Math.random() * texts.length);
				
			return texts[random];
		}
			
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						return;
					}
					setText(texts());
			}
		}
	}
	
	// Paint start background
	class Startmotion extends JPanel implements KeyListener, Runnable {
		
		// vector for bullet's location
		private Vector<Point> pointVectorup = new Vector<Point>();
		private Vector<Point> pointVectorleft = new Vector<Point>();
		private Vector<Point> pointVectordown = new Vector<Point>();
		private Vector<Point> pointVectorright = new Vector<Point>();
		private Vector<Point> pointVectorbonus = new Vector<Point>();

		ArrayList upbullet = new ArrayList();
		ArrayList leftbullet = new ArrayList();
		ArrayList downbullet = new ArrayList();
		ArrayList rightbullet = new ArrayList();
		ArrayList bonusbullet = new ArrayList();

		// bullet
		Bullet bu;
		
		// count
		int cnt;
		int size;
		
		// bullet basic speed
		int speed = 3;
		
		// bullet location
		Point pup, pleft, pdown, pright, pbonus;
		int[] angleup, angleleft, angledown, angleright, anglebonus;
		
		int x, y;
		
		// player status
		int player_status = 0;
		
		// location of ship
	    int ship_x, ship_y;
	    int face_x, face_y;
	    
		// key options
	    boolean KeyUp = false;
	    boolean KeyDown = false;
	    boolean KeyLeft = false;
	    boolean KeyRight = false;
	    boolean KeyEnter = false;
	    boolean KeySpace = false;
	    
	    // count bullets
	    String count;
	    
	    // size for crash
	    // size of spaceship
	    int me_x, me_y;
	    // size of bullet
	    int bullet_x, bullet_y;
	    
	    // game over
	    String over, restart;
	    
		public Startmotion(Component c) {
			init();
			main();
			spaceshipThread = new Thread(this);
			spaceshipThread.start();
		}
		
		public void init() {
			cnt = 0;
			ship_x = 400;
			ship_y = 300;
			face_x = 400;
			face_y = 300;
			me_x = 15;
			me_y = 15;
			bullet_x = 3;
			bullet_y = 3;
			name = "Player. " + changename;
			over = "GAME OVER";
			restart = "SPACE TO RESTART";
		}
		
		public void main() {
			makeBulletup();
			makeBulletleft();
			makeBulletdown();
			makeBulletright();
			makeBulletposition();
			System.out.println("main");
		}
		
		// up side
		public void makeBulletup(){
			
			for(int i = pointVectorup.size(); i < 15; i++){
				int x = (int)(Math.random() * 800);
                int y = 0;
                pointVectorup.add(new Point(x, y));
                bu = new Bullet(x, y, 0, speed);
                upbullet.add(bu);
            }
        }
		
		// left side
		public void makeBulletleft(){
			
			for(int i = pointVectorleft.size(); i < 20; i++){
				int x = 0;
                int y = (int)(Math.random() * 600);
                pointVectorleft.add(new Point(x, y));
                bu = new Bullet(x, y, 0, speed);
                leftbullet.add(bu);
            }
        }
		
		// down side
		public void makeBulletdown(){
			
			for(int i = pointVectordown.size(); i < 20; i++){
				int x = (int)(Math.random() * 800);
                int y = 545;
                pointVectordown.add(new Point(x, y));
                bu = new Bullet(x, y, 0, speed);
                downbullet.add(bu);
            }
        }
		
		// right side
		public void makeBulletright(){
	
			for(int i = pointVectorright.size(); i < 20; i++){
				int x = 795;
				int y = (int)(Math.random() * 600);
				pointVectorright.add(new Point(x, y));
				bu = new Bullet(x, y, 0, speed);
                rightbullet.add(bu);
			}
		}
		public void makeBulletbonus(){
			
			int x = (int)(Math.random() * 800);
			int y = 0;
			pointVectorbonus.add(new Point(x, y));
			bu = new Bullet(x, y, 0, speed);
			bonusbullet.add(bu);
            
        }
		
		public void makeBulletposition() {
			angleup = new int[pointVectorup.size()];
			for(int i = 0; i < pointVectorup.size(); i++) {
				angleup[i] = (int)(Math.random() * 180);
			}
			angleleft = new int[pointVectorleft.size()];
			for(int i = 0; i < pointVectorleft.size(); i++) {
				angleleft[i] = (int)(Math.random() * 450) + 270;
			}
			angledown = new int[pointVectordown.size()];
			for(int i = 0; i < pointVectordown.size(); i++) {
				angledown[i] = (int)(Math.random() * 360) + 180;
			}
			angleright = new int[pointVectorright.size()];
			for(int i = 0; i < pointVectorright.size(); i++) {
				angleright[i] = (int)(Math.random() * 270) + 90;
			}
			anglebonus = new int[100];
			for(int i = 0; i < 100; i++) {
				anglebonus[i] = (int)(Math.random() * 180);
			}
		}
		
		public void removeBullet() {
			pointVectorup.clear();
			pointVectorleft.clear();
			pointVectordown.clear();
			pointVectorright.clear();
			pointVectorbonus.clear();
			upbullet.clear();
			leftbullet.clear();
			downbullet.clear();
			rightbullet.clear();
			bonusbullet.clear();
		}
		
		//-----------------------Crash-----------------------------
		public boolean Crash(int x1, int y1, int x2, int y2, int w1, int h1, int w2, int h2) {
			boolean check = false;
			if (Math.abs((x1 + w1 / 2) - (x2 + w2 / 2)) < (w2 / 2 + w1 / 2) && Math.abs((y1 + h1 / 2) - (y2 + h2 / 2)) < (h2 / 2 + h1/ 2)) {
				check = true;
			}
			return check;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					KeyProcess();
					System.out.println("enter : " + KeyEnter + ", space : " + KeySpace);
					if(player_status == 0) {
						init();
						main();
					}
					if(player_status == 1) {
						CountProcess();
						TimeProcess();
						BulletProcess();
						cnt++;
						if(cnt%100==0) {
							makeBulletbonus();
							System.out.println("make!!!!!!!!!!!!");
						}
						System.out.println(cnt);
					}
					else if(player_status == -1) {
						while(KeySpace != true) {
							Thread.sleep(20);
						}
						if(KeySpace == true) {
							removeBullet();
						}
					}
					repaint();
					Thread.sleep(20);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// draw background
		    g.drawImage(startImg,0,0,getWidth(),getHeight(), null);
	        // draw spaceship
			g.drawImage(chgImg, ship_x, ship_y, 20, 20, this);
			if(player_status == 1) {
				// draw player, count, time
				g.setColor(Color.white);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString(name, 10, 30);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("Bullets : ", 330, 30);
				g.drawString(count, 430, 30);
				g.drawString(time, 700, 30);
			}
			// draw face
	        g.drawImage(chgImg2, face_x - 200, face_y - 350, this);
	        // draw press enter
	        g.setFont(new Font("Arial", Font.BOLD, 30));
	        g.setColor(Color.white);
	        g.drawString("Press Enter Start!", face_x - 115, face_y + 100);
	        
	        // draw bullet 
            for(int i = 0; i < pointVectorup.size(); i++){
                pup = pointVectorup.elementAt(i);
                g.drawImage(chgbullet, pup.x, pup.y, 5, 5, this);
                if(Crash(ship_x, ship_y, pup.x, pup.y, me_x, me_y, bullet_x, bullet_y)) {
                	player_status = -1;
                	KeyEnter = false;
                	System.out.println("crash");
                }
            }
            
            for(int i = 0; i < pointVectorleft.size(); i++){
                pleft = pointVectorleft.elementAt(i);
                g.drawImage(chgbullet, pleft.x, pleft.y, 5, 5, this);
                if(Crash(ship_x, ship_y, pleft.x, pleft.y, me_x, me_y, bullet_x, bullet_y)) {
                	player_status = -1;
                	KeyEnter = false;
                	System.out.println("crash");
                }
            }
            
            for(int i = 0; i < pointVectordown.size(); i++){
                pdown = pointVectordown.elementAt(i);
                g.drawImage(chgbullet, pdown.x, pdown.y, 5, 5, this);
                if(Crash(ship_x, ship_y, pdown.x, pdown.y, me_x, me_y, bullet_x, bullet_y)) {
                	player_status = -1;
                	KeyEnter = false;
                	System.out.println("crash");
                }
            }
            
            for(int i = 0; i < pointVectorright.size(); i++){
                pright = pointVectorright.elementAt(i);
                g.drawImage(chgbullet, pright.x, pright.y, 5, 5, this);
                if(Crash(ship_x, ship_y, pright.x, pright.y, me_x, me_y, bullet_x, bullet_y)) {
                	player_status = -1;
                	KeyEnter = false;
                	System.out.println("crash");
                }
            }
            
            for(int i = 0; i < pointVectorbonus.size(); i++){
                pbonus = pointVectorbonus.elementAt(i);
                g.drawImage(chgbullet2, pbonus.x, pbonus.y, 5, 5, this);
                if(Crash(ship_x, ship_y, pbonus.x, pbonus.y, me_x, me_y, bullet_x, bullet_y)) {
                	player_status = -1;
                	KeyEnter = false;
                	System.out.println("crash");
                }
            }
            
            if(player_status == -1) {
            	g.setColor(Color.gray);
				g.setFont(new Font("Arial", Font.BOLD, 30));
				g.drawString(over, 310, 250);
				g.drawString(restart, 250, 300);
            }
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP : 
				KeyUp = true; 
				break;
			case KeyEvent.VK_DOWN : 
				KeyDown = true; 
				break;
			case KeyEvent.VK_LEFT : 
				KeyLeft = true; 
				break;
			case KeyEvent.VK_RIGHT : 
				KeyRight = true; 
				break;
			case KeyEvent.VK_ENTER :
				KeyEnter = true;
				System.out.println("press enter");
				break;
			case KeyEvent.VK_SPACE :
				KeySpace = true;
				System.out.println("press space");
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP : 
				KeyUp = false; 
				break;
			case KeyEvent.VK_DOWN : 
				KeyDown = false; 
				break;
			case KeyEvent.VK_LEFT : 
				KeyLeft = false; 
				break;
			case KeyEvent.VK_RIGHT : 
				KeyRight = false; 
				break;
			}
		}
		
		// -------------------------------process-------------------------------
		public void KeyProcess() {
			if(KeyUp == true) {
				if(ship_y > 0)
					ship_y -= 5;
			}
			if(KeyDown == true) {
				if(ship_y < this.getHeight() - 20)
					ship_y += 5;
			}
			if(KeyLeft == true) {
				if(ship_x > 0)
					ship_x -= 5;
			}
			if(KeyRight == true) {
				if(ship_x < this.getWidth() - 20)
					ship_x += 5;
			}
			if(KeyEnter == true) {
				KeySpace = false;
				player_status = 1;
				face_x += 1000;
				System.out.println(player_status);
			}
			if(KeySpace == true) {
				KeyEnter = false;
				player_status = 0;
				init();
				main();
				System.out.println(player_status);
			}
		}
		
		public void BulletProcess() {
			for(int i = 0; i < pointVectorup.size(); i++){
                pup = pointVectorup.elementAt(i);
                
                pup.setLocation(pup.x + Math.cos(Math.toRadians(angleup[i]))*speed, pup.y + Math.sin(Math.toRadians(angleup[i]))*speed);
                pointVectorup.set(i, pup);
                // new location
                if(pup.x < -10 || pup.x > 805 || pup.y < -10 || pup.y > 555) {
                	angleup[i] += 30;
                }
            }
			
			for(int i = 0; i < pointVectorleft.size(); i++){
                pleft = pointVectorleft.elementAt(i);
                
                pleft.setLocation(pleft.x + Math.cos(Math.toRadians(angleleft[i]))*speed, pleft.y + Math.sin(Math.toRadians(angleleft[i]))*speed);
                pointVectorleft.set(i, pleft);
                // return outed bullet
                if(pleft.x < -10 || pleft.x > 805 || pleft.y < -10 || pleft.y > 555) {
                	angleleft[i] += 60;
                }
            }
			
			for(int i = 0; i < pointVectordown.size(); i++){
                pdown = pointVectordown.elementAt(i);
                
                pdown.setLocation(pdown.x + Math.cos(Math.toRadians(angledown[i]))*speed, pdown.y + Math.sin(Math.toRadians(angledown[i]))*speed);
                pointVectordown.set(i, pdown);
                // return outed bullet
                if(pdown.x < -10 || pdown.x > 805 || pdown.y < -10 || pdown.y > 555) {
                	angledown[i] += 120;
                }
            }
			
			for(int i = 0; i < pointVectorright.size(); i++){
                pright = pointVectorright.elementAt(i);
                
                pright.setLocation(pright.x + Math.cos(Math.toRadians(angleright[i]))*speed, pright.y + Math.sin(Math.toRadians(angleright[i]))*speed);
                pointVectorright.set(i, pright);
                // return outed bullet
                if(pright.x < -10 || pright.x > 805 || pright.y < -10 || pright.y > 555) {
                	angleright[i] += 150;
                }
            }
			
			for(int i = 0; i < pointVectorbonus.size(); i++){
                pbonus = pointVectorbonus.elementAt(i);
                
                pbonus.setLocation(pbonus.x + Math.cos(Math.toRadians(anglebonus[i]))*speed, pbonus.y + Math.sin(Math.toRadians(anglebonus[i]))*speed);
                pointVectorbonus.set(i, pbonus);
                // new location
                if(pbonus.x < -10 || pbonus.x > 805 || pbonus.y < -10 || pbonus.y > 555) {
                	anglebonus[i] += 30;
                }
            }
		}
		
		public void CountProcess() {
			// 3sec. -> + 1 bullet
			count = Integer.toString(80 + (cnt / 100));
		}
		
		public void TimeProcess() {
			// sec.
			ss = Integer.toString((cnt * 2) % (1000 * 60) / 100 % 60);
			// millisec.
			ms = Integer.toString((cnt * 2) % 100);
			time = ss + "." + ms + "sec.";
		}
	}
	
	class Bullet{
		int x;
		int y;
		int angle;
		int speed;
		
		public Bullet(int x, int y, int angle, int speed) {
			this.x = x;
			this.y = y;
			this.angle = angle;
			this.speed = speed;
		}
		
		public void move() {
			// 해당 방향으로 총알 발사
			x += Math.cos(Math.toRadians(angle))*speed;
			y += Math.sin(Math.toRadians(angle))*speed;
		}
	}
	
	public static void main(String[] args) {
		
		// Start Game
		new Game_GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		switch(command) {
		
		case "start" : createStart(); break;
		case "instagram" : instagram(); break;
		case "facebook" : facebook(); break;
		case "Change SpaceShip" : edit.spaceship(); break;
		case "Change Player" : edit.changeplayer(); break;
		case "Rank" : rank.rank(); break;
		case "How to play" : help.how_to_play(); break;
		case "Contact to engineer" : help.contact(); break;
		}
	}
	
	
}
