package java核心技术;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class FileReaderWriteDemo extends JFrame {

	private JPanel contentPane =new JPanel();
	private JTextArea textArea =new JTextArea();
	private JScrollPane textAreaScroll =new JScrollPane(textArea);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileReaderWriteDemo frame = new FileReaderWriteDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileReaderWriteDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("写入文件");
		btnNewButton.addActionListener((e) -> {  
				File file = new File("D:/GitRespository/Java从入门到精通/FileDemo/word.txt");
				try {
					FileWriter fw = new FileWriter(file);
					String areaText = textArea.getText();
					fw.write(areaText);//写入
					fw.close();
				} catch (Exception e1) {
					System.out.println("文件写入异常");
					e1.printStackTrace();
				}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("读取文件");
		btnNewButton_1.addActionListener((e) -> {  
				File file = new File("D:/GitRespository/Java从入门到精通/FileDemo/word.txt");
				try {
					FileReader fr = new FileReader(file);
					char[] fileReaderCharArr = new char[1024];
					int lenth = fr.read(fileReaderCharArr);
					textArea.setText(new String(fileReaderCharArr,0,lenth));
				} catch (Exception e1) {
					System.out.println("文件读取异常");
					e1.printStackTrace();
				}
		});
		panel_1.add(btnNewButton_1);
		textArea.setSelectedTextColor(Color.red);//选中颜色
		textArea.setLineWrap(true);//激活自动换行功能 
		textArea.setWrapStyleWord(true);//激活断行不断字功能
		contentPane.add(textAreaScroll, BorderLayout.CENTER);
	}

}
