package jp;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogGenerator {
	
	/**
	 * �w��̃T�C�Y�A�^�C�g���̃E�B���h�E�𐶐�����
	 * ���̊֐��ɂ�萶�������E�B���h�E�́~�{�^���ɂ��N���[�Y����ƃV�X�e�����I������
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
	 * �w��t�H���g�T�C�Y�ƃ��b�Z�[�W������ꂽ���b�Z�[�W�_�C�A���O��\������
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
