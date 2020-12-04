import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("TitleName");
        setBounds(300, 200, 500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JButton[] jButtons = new JButton[5];
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton("Кнопка " + i);
        }

        setLayout(new BorderLayout());   // выбор компоновщика элементов
        add(jButtons[0], BorderLayout.EAST); // добавление кнопки на форму
//        add(jButtons[1], BorderLayout.WEST);
//        add(jButtons[2], BorderLayout.SOUTH);
//        add(jButtons[3], BorderLayout.NORTH);
//        add(jButtons[4], BorderLayout.CENTER);

        JMenuBar jMenuBar = new JMenuBar();
        add(jMenuBar, BorderLayout.NORTH);
        JMenu jMenu = new JMenu("Menu");
        jMenuBar.add(jMenu);


        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.green);
        add(jPanel, BorderLayout.WEST);

        JMenuItem subMenuRed = jMenu.add(new StyledEditorKit.ForegroundAction("Red", Color.RED));
        JMenuItem subMenuBlue = jMenu.add(new StyledEditorKit.ForegroundAction("Blue", Color.BLUE));

        subMenuBlue.addMouseListener(new ColorMenuMouseListener(Color.BLUE, jPanel));
        subMenuRed.addMouseListener(new ColorMenuMouseListener(Color.RED, jPanel));

        JTextArea jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        add(jTextArea, BorderLayout.CENTER);
        jTextArea.setBackground(Color.GRAY);
        jTextArea.setForeground(Color.GREEN);

        JTextField jTextField = new JTextField();
        jTextField.setBackground(Color.CYAN);
        add(jTextField, BorderLayout.SOUTH);
        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                jTextArea.append(e.getActionCommand() + "\n");
                jTextField.setText("");
            }
        });

        setVisible(true);
    }
}
