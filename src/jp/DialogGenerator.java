package jp;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogGenerator {
	public static JFrame generateWindow(int w,int h,String title){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(w,h);
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		
		return frame;
	}
	
	public static void generateMessageDialog(int fontSize,String... msgs) {
		JFrame dialog = generateWindow(400,100,"GlobalIPGetter");
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		
		for(String msg : msgs) {
			JLabel labe = new JLabel(msg);
			labe.setAlignmentX(0.5f);
			labe.setFont(new Font(Font.DIALOG,Font.PLAIN,fontSize));
			pane.add(labe);
		}
		
		dialog.add(pane);
		
		dialog.setVisible(true);
	}
}
