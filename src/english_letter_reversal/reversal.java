/**   
 *    
 * 项目名称：english_letter_reversal   
 * 类名称：reversal
 * 类描述：   
 * 创建人：padeoe   
 * 创建时间：2014年12月10日 下午2:37:58   
 * 修改人：padeoe   
 * 修改时间：2014年12月10日 下午2:37:58   
 * 修改备注：   
 * @version    
 *    
 */
package english_letter_reversal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class reversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setTitle("英文字母反转");
		frame.setSize(300, 150);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		final JTextField comp = new JTextField();
		frame.add(comp);
		comp.setBounds(20, 20, 255, 30);
		JButton button = new JButton();
		frame.add(button);
		button.setBounds(200, 92, 74, 20);
		button.setFont(new Font("Simsun", 0, 10));
		button.setText("convert");
		final JTextField comp2 = new JTextField();
		frame.add(comp2);
		comp2.setBounds(20, 55, 255, 30);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				convert(comp, comp2);
			}

		});
		comp.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					convert(comp, comp2);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		comp2.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					convert(comp2, comp);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	static char convert_letter(char a) {
		char s1[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '\'', '，', '。', '.', ' ', '?', '∼', '，', '/',
				'I', 'A', 'E', 'H', 'M', 'O', 'X', 'Z', '^', '_', '→', '(', ')' };
		char s2[] = { 'ɐ', 'q', 'ɔ', 'p', 'ə', 'ɟ', 'ƃ', 'ɥ', '!', 'ɾ', 'ʞ',
				'l', 'ɯ', 'u', 'o', 'd', 'b', 'ɹ', 's', 'ʇ', 'n', 'ʌ', 'ʍ',
				'x', 'ʎ', 'z', ',', '‘', '°', '·', ' ', '¿', '∼', '‘', '\\',
				'I', '∀', '∃', 'H', 'W', 'O', 'X', 'Z', 'v', '￣', '←', ')', '(' };
		// ArrayList user1=new ArrayList();
		if (find_index(s1, a) == -1 && find_index(s2, a) == -1)
			return a;
		else {
			if (find_index(s1, a) == -1)
				return s1[reversal.find_index(s2, a)];
			else
				return s2[reversal.find_index(s1, a)];
		}

	}

	static int find_index(char s[], char a) {
		int i;
		for (i = 0; i < s.length; i++) {
			if (s[i] == a)
				break;
		}
		if (i == s.length)
			return -1;
		else
			return i;
	}

	static void convert(JTextField comp, JTextField comp2) {
		StringBuffer input = new StringBuffer(comp.getText());
		for (int i = 0; i < input.length(); i++) {
			input.setCharAt(i, convert_letter(input.charAt(i)));
		}
		// char tmp;
		for (int i = 0; i < input.length() / 2; ++i) {
			char tmp = input.charAt(i);
			input.setCharAt(i, input.charAt(input.length() - i - 1));
			input.setCharAt(input.length() - i - 1, tmp);
		}
		comp2.setText(input.toString());
	}
}
