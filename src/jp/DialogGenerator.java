package jp;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogGenerator {
	
	/**
	 * 指定のサイズ、タイトルのウィンドウを生成する
	 * この関数により生成したウィンドウは×ボタンによりクローズするとシステムが終了する
	 * @param w
	 * @param h
	 * @param title
	 * @return
	 */
	public static JFrame generateWindow(int w,int h,String title){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(w,h);
		frame.setLocationRelativeTo(null);
		frame.setTitle(title);
		
		return frame;
	}
	
	/**
	 * 指定フォントサイズとメッセージが内包されたメッセージダイアログを表示する
	 * @param fontSize
	 * @param msgs
	 */
	public static void generateMessageDialog(int w,int h,int fontSize,String... msgs) {
		JFrame dialog = generateWindow(w,h,"GlobalIPGetter");
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
