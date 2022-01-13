package dodge_game;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Function_Help {
	Game_GUI gui;
	
	//--------------------------------Method-----------------------------
	public Function_Help(Game_GUI gui) {
		this.gui = gui;
	}
	
	public void how_to_play() {
		Play play = new Play();
	}
	
	public void contact() {
		Contact contact = new Contact();
	}
	
	class Play extends JFrame{
		private JLabel how;
		public Play() {
			setTitle("How to play");
			
			how = new JLabel("<html>1. 키보드에 손을 올리세요.<br/><br/>2. 방향키를 누르세요.<br/><br/>3. bullet을 피해 도망치세요!</html>", SwingConstants.CENTER);
			
			setSize(300, 200);
			Dimension frameSize = this.getSize();
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    this.setLocation(((screenSize.width - frameSize.width) / 2), ((screenSize.height - frameSize.height) / 2));
			
		    setVisible(true);
		    add(how);
		}
	}
	
	class Contact extends JFrame{
		private JLabel contact;
		public Contact() {
			setTitle("Contact to engineer");
			
			contact = new JLabel("<html>Email : seungmin4452@gmail.com<br/><br/>Adress : 전주시 완산구 천잠로 303 전주대학교 404호</html>", SwingConstants.CENTER);
			
			setSize(400, 200);
			Dimension frameSize = this.getSize();
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    this.setLocation(((screenSize.width - frameSize.width) / 2), ((screenSize.height - frameSize.height) / 2));
		    
		    setVisible(true);
		    add(contact);
		}
	}
	
}
