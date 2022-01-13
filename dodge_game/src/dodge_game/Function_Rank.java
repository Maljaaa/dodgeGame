package dodge_game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Function_Rank {
	Game_GUI gui;
	
	public String[] record = new String[5];
	public int[] rank;
	public String[] p = new String[5];
	public int[] t = new int[5];

	//--------------------------------Method-----------------------------
	public Function_Rank(Game_GUI gui) {
		this.gui = gui;
	}
	
	public void rank() {
		RankGUI rankgui = new RankGUI();
	}
	
	//-------------------------------Class--------------------------------
	class RankGUI extends JFrame implements ActionListener{
		private JButton add;
		public RankGUI() {
			createwindow();
		}
		
		public void createwindow() {
			setTitle("Rank");
			setLayout(new BorderLayout());
			
			setSize(400, 450);
			Dimension frameSize = this.getSize();
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    this.setLocation(((screenSize.width - frameSize.width) / 2), ((screenSize.height - frameSize.height) / 2));
			
		    add = new JButton();
			add.setText("Add!");
			add.addActionListener(this);
			add.setActionCommand("Add!");
			add(add, BorderLayout.SOUTH);
		    RankPaint rankpaint = new RankPaint();
			add(rankpaint, BorderLayout.CENTER);
			
		    setVisible(true);
		}
		
		public void addrank() {
			File file = new File("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/rankdb.txt");
			String str = gui.changename + "\t" + gui.time;
			System.out.println(str);
			try {
			    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			    writer.write("\n"+str);
			    writer.close();
			    System.out.println("write");
			    String Recent = str.replaceAll("[^0-9]", "");
			    int recent = Integer.parseInt(Recent);
			    System.out.println(recent);
			    for(int i = 0; i < 5; i++) {
			    	System.out.println(t[i]);
			    }
			    for(int i = 0; i < 4; i++) {
			    	if(t[i] < recent && recent < t[i+1]) {
			    		record[i] = str;
			    		System.out.println(record[i]+"->"+str);
			    	}
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			
			switch(command) {
			case "Add!" : addrank(); break;
			}
		}
	}
	
	class RankPaint extends JPanel{
		public RankPaint() {
			Scanner scanner;
			try {
				scanner = new Scanner(new File("/Users/sinseungmin/Desktop/Programming/Project/DodgeGame/rankdb.txt"));
				while (scanner.hasNext()) {
					for(int i = 0; i < 5; i++) {
						record[i] = scanner.nextLine();
						//rank[i] = Integer.parseInt(record[i]);
						System.out.println(record[i]);
						//System.out.println(rank);
						p[i] = record[i].replaceAll("[^0-9]", "");
						t[i] = Integer.parseInt(p[i]);
						System.out.println("p["+i+"]"+p[i]);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return;
			}

		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.setFont(new Font("timesRoman", Font.BOLD, 50));
			g.drawString("Top  5", 130, 60);
			g.setFont(new Font("timesRoman", Font.ITALIC, 30));
			g.setColor(Color.yellow);
			g.drawString("1.", 30, 120);
			g.drawString(record[0], 100, 120);
			g.setColor(Color.MAGENTA);
			g.drawString("2.", 30, 170);
			g.drawString(record[1], 100, 170);
			g.setColor(Color.lightGray);
			g.drawString("3.", 30, 220);
			g.drawString(record[2], 100, 220);
			g.setColor(Color.blue);
			g.drawString("4.", 30, 270);
			g.drawString(record[3], 100, 270);
			g.setColor(Color.green);
			g.drawString("5.", 30, 320);
			g.drawString(record[4], 100, 320);
		}
	}
	
	
}
