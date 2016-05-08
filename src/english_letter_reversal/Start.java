/**
 * 项目名称：english_letter_reversal
 * 类名称：Start
 * 类描述：
 * 创建人：padeoe
 * 创建时间：2014年12月10日 下午2:37:58
 * 修改人：padeoe
 * 修改时间：2014年12月10日 下午2:37:58
 * 修改备注：
 *
 * @version
 */
package english_letter_reversal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Start {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame();
        frame.setTitle("Word Trick");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JLabel jLabel = new JLabel("英文语句翻转");
        jLabel.setFont(new Font("微软雅黑", 0, 15));
        frame.add(jLabel);
        jLabel.setBounds(10, 5, 100, 50);
        final JTextField input_reverse = new JTextField();
        input_reverse.setFont(new Font("arial", 0, 15));
        frame.add(input_reverse);
        input_reverse.setBounds(20, 50, 255, 30);
        JButton button = new JButton();
        frame.add(button);
        button.setBounds(190, 122, 84, 25);
        button.setFont(new Font("arial", 0, 15));
        button.setText("convert");
        final JTextField output_reverse = new JTextField();
        output_reverse.setFont(new Font("arial", 0, 15));
        frame.add(output_reverse);
        output_reverse.setBounds(20, 85, 255, 30);
        button.addActionListener(e -> reverse(input_reverse, output_reverse));
        input_reverse.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    reverse(input_reverse, output_reverse);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        output_reverse.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    reverse(output_reverse, input_reverse);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });


        JLabel jLabel2 = new JLabel("特殊字符欺骗");
        jLabel2.setFont(new Font("微软雅黑", 0, 15));
        frame.add(jLabel2);
        jLabel2.setBounds(10, 120, 100, 50);

        final JTextField input_obfuscate = new JTextField();
        input_obfuscate.setFont(new Font("arial", 0, 15));
        frame.add(input_obfuscate);
        input_obfuscate.setBounds(20, 165, 255, 30);
        JButton button2 = new JButton();
        frame.add(button2);
        button2.setBounds(190, 237, 84, 25);
        button2.setFont(new Font("arial", 0, 15));
        button2.setText("convert");
        final JTextField output_obfuscate = new JTextField();
        output_obfuscate.setFont(new Font("arial", 0, 15));
        frame.add(output_obfuscate);
        output_obfuscate.setBounds(20, 200, 255, 30);
        button2.addActionListener(e -> obfuscate(input_obfuscate, output_obfuscate));
        input_obfuscate.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    obfuscate(input_obfuscate, output_obfuscate);
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }

    private static char reverse_letter(char a) {
        char s1[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', '\'', '，', '。', '.', ' ', '?', '∼', '，', '/',
                'I', 'A', 'E', 'H', 'M', 'O', 'X', 'Z', '^', '_', '→', '(', ')'};
        char s2[] = {'ɐ', 'q', 'ɔ', 'p', 'ə', 'ɟ', 'ƃ', 'ɥ', '!', 'ɾ', 'ʞ',
                'l', 'ɯ', 'u', 'o', 'd', 'b', 'ɹ', 's', 'ʇ', 'n', 'ʌ', 'ʍ',
                'x', 'ʎ', 'z', ',', '‘', '°', '·', ' ', '¿', '∼', '‘', '\\',
                'I', '∀', '∃', 'H', 'W', 'O', 'X', 'Z', 'v', '￣', '←', ')', '('};
        // ArrayList user1=new ArrayList();
        if (find_index(s1, a) == -1 && find_index(s2, a) == -1)
            return a;
        else {
            if (find_index(s1, a) == -1)
                return s1[Start.find_index(s2, a)];
            else
                return s2[Start.find_index(s1, a)];
        }

    }

    private static char obfuscated_letter(char c) {
        char s1[] = {'a', 'c', 'd', 'e', 'g', 'h', 'i', 'j',
                'n', 'o', 'p', 's', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'E', 'F', 'H', 'I', 'J', 'K',
                'M', 'N', 'O', 'P', 'S', 'T', 'U', 'W', 'X',
                'Y', 'Z'};
        //注意！下面的字符全是特殊字符，不是拉丁英文字母！
        char s2[] = {'а', 'ϲ', 'ԁ', 'е', 'ɡ', 'һ', 'і', 'ј',
                'ո', 'օ', 'р', 'ѕ', 'ᴠ', 'ᴡ', 'х', 'у', 'ᴢ',
                'Α', 'В', 'С', 'Ε', 'Ϝ', 'Н', 'Ӏ', 'Ј', 'Κ',
                'М', 'Ν', 'О', 'Р', 'Տ', 'Т', 'Ս', 'Ԝ', 'Х',
                'Ү', 'Ζ'};
        int index = find_index(s1, c);
        return index == -1 ? c : s2[index];
    }

    /**
     * 将英文字符串中的字母用Unicode中长相神似的特殊字符替换。可以用于欺骗敏感词过滤，防止搜索引擎搜索
     *
     * @param inputString 输入的英文字符串，其中无法转换的字符将会原始输出
     * @return 替换后的字符串
     */
    public static String obfuscate(String inputString) {
        StringBuilder input = new StringBuilder(inputString);
        for (int i = 0; i < input.length(); i++) {
            input.setCharAt(i, obfuscated_letter(input.charAt(i)));
        }
        return input.toString();
    }

    private static int find_index(char s[], char a) {
        int i;
        for (i = 0; i < s.length; i++)
            if (s[i] == a)
                break;
        return i == s.length ? -1 : i;
    }

    private static void reverse(JTextField input, JTextField output) {
        output.setText(reverse(input.getText()));
    }

    private static void obfuscate(JTextField input, JTextField output) {
        output.setText(obfuscate(input.getText()));
    }

    /**
     * 将英文字符串颠倒180°。
     *
     * @param inputString 输入的英文字符串，其中无法转换的字符将会原始输出
     * @return inputString符串颠倒180°后的字符串
     */
    public static String reverse(String inputString) {
        StringBuilder input = new StringBuilder(inputString);
        for (int i = 0; i < input.length(); i++) {
            input.setCharAt(i, reverse_letter(input.charAt(i)));
        }
        //反转排列顺序
        for (int i = 0; i < input.length() / 2; ++i) {
            char tmp = input.charAt(i);
            input.setCharAt(i, input.charAt(input.length() - i - 1));
            input.setCharAt(input.length() - i - 1, tmp);
        }
        return input.toString();

    }
}
