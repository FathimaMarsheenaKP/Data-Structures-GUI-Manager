import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fathi\\Downloads\\output-onlinepngtools (5).png"));
		lblNewLabel.setBounds(0, 0, 773, 640);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DATA STRUCTURES");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1.setBounds(203, 32, 406, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Array");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(74, 129, 236, 83);
		contentPane.add(btnNewButton);
		
		// Action Listener to open Array window
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Open the Array window
				Array array = new Array();
				array.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Stack");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(462, 129, 236, 83);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Open the Array window
				Stack stack = new Stack();
				stack.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Queue");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(74, 285, 236, 83);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Open the Array window
				Queue queue = new Queue();
				queue.setVisible(true);
			}
		});
		
		JButton btnCircularQueue = new JButton("<html><div align='center'>Circular<br> Queue</div></html>");
		btnCircularQueue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCircularQueue.setBounds(462, 285, 236, 83);
		btnCircularQueue.setHorizontalAlignment(SwingConstants.CENTER);  // Center horizontally
		btnCircularQueue.setVerticalAlignment(SwingConstants.CENTER); 
		contentPane.add(btnCircularQueue);
		
		btnCircularQueue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Open the Array window
				CircularQueue circularQueue = new CircularQueue();
				circularQueue.setVisible(true);
			}
		});
		
		JButton btnSingleLinkedlist = new JButton("<html><div align='center'>Singly<br> Linked<br> List</div></html>");
		btnSingleLinkedlist.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSingleLinkedlist.setBounds(74, 455, 236, 83);
		btnSingleLinkedlist.setHorizontalAlignment(SwingConstants.CENTER);  // Center horizontally
		btnSingleLinkedlist.setVerticalAlignment(SwingConstants.CENTER); 
		contentPane.add(btnSingleLinkedlist);
		
		JButton btnDoublyLinkedList = new JButton("<html><div align='center'>Doubly<br>Linked<br>List</div></html>");
		btnDoublyLinkedList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDoublyLinkedList.setBounds(462, 455, 236, 83);
		btnDoublyLinkedList.setHorizontalAlignment(SwingConstants.CENTER);  // Center horizontally
		btnDoublyLinkedList.setVerticalAlignment(SwingConstants.CENTER);    // Center vertically
		contentPane.add(btnDoublyLinkedList);

	}
}
