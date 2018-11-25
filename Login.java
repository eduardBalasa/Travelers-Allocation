package login;
import javax.swing.JFrame;

import gui.Main;

public class Login extends LoginFrame {
	
	public static void main(String[] a) {
		
		/*LoginFrame frame = new LoginFrame();
		frame.setTitle("Login Window");
		frame.setVisible(true);
		frame.setBounds(10, 10, 370, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);*/
		
		Main form = new Main();
		form.setVisible(true);

	}

}