import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Queue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_size;
	private JTextField textField_ele;
	private JLabel lblNewLabel_3;
	private JButton btnEnqueue;
	private JButton btnDequeue;
	private JLabel lblNewLabel_3_1;
	private JTextField textField_pos;
	private JButton btnGet;
	private JTextField textField_get;
	private JTextField textField_display;
	private JButton btnDisplay;
	private JButton btnNewButton_1;
	private int size = 0;
	private int[] queue = null;
	private int front = -1;
	private int rear = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
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
	public Queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\DSAImplementation\\queue.png"));
		lblNewLabel.setBounds(0, 0, 783, 640);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("QUEUE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(319, 35, 116, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(109, 102, 68, 48);
		contentPane.add(lblNewLabel_2);
		
		textField_size = new JTextField();
		textField_size.setColumns(10);
		textField_size.setBounds(187, 102, 298, 48);
		contentPane.add(textField_size);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(557, 102, 123, 48); 
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the array size from the text field
				createQueue(size);
			}
		});
		
		lblNewLabel_3 = new JLabel("Element");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(74, 210, 86, 48);
		contentPane.add(lblNewLabel_3);
		
		textField_ele = new JTextField();
		textField_ele.setColumns(10);
		textField_ele.setBounds(187, 210, 137, 48);
		contentPane.add(textField_ele);
		
		btnEnqueue = new JButton("Enqueue");
		btnEnqueue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEnqueue.setBounds(364, 210, 123, 48);
		contentPane.add(btnEnqueue);
		
		btnEnqueue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int element = Integer.parseInt(textField_ele.getText().trim());
					enqueue(element);
					textField_ele.setText("");
				} catch (NumberFormatException ex) {
					 JOptionPane.showMessageDialog(null, "Please enter valid integers for element.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnDequeue = new JButton("Dequeue");
		btnDequeue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDequeue.setBounds(557, 210, 123, 48);
		contentPane.add(btnDequeue);
		
		btnDequeue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				dequeue();
			}
		});
		
		lblNewLabel_3_1 = new JLabel("Position");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(74, 333, 86, 56);
		contentPane.add(lblNewLabel_3_1);
		
		textField_pos = new JTextField();
		textField_pos.setColumns(10);
		textField_pos.setBounds(187, 333, 137, 48);
		contentPane.add(textField_pos);
		
		btnGet = new JButton("Get");
		btnGet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGet.setBounds(364, 333, 123, 48);
		contentPane.add(btnGet);
		
		btnGet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int index = Integer.parseInt(textField_pos.getText().trim());
					getElement(index);
					textField_pos.setText("");
				} catch (NumberFormatException ex) {
					 JOptionPane.showMessageDialog(null, "Please enter valid integer for position.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		textField_get = new JTextField();
		textField_get.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_get.setColumns(10);
		textField_get.setBounds(557, 333, 123, 48);
		contentPane.add(textField_get);
		
		textField_display = new JTextField();
		textField_display.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_display.setColumns(10);
		textField_display.setBounds(74, 450, 412, 48);
		contentPane.add(textField_display);
		
		btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDisplay.setBounds(557, 450, 123, 48);
		contentPane.add(btnDisplay);
		
		btnDisplay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(334, 541, 107, 48);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				dispose();
			}
		});
	}
	
	private void createQueue(int size) {
		try {
			if (!isNull()) {
	            JOptionPane.showMessageDialog(this, "Queue already exists! Please delete the existing queue to create a new one.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
			size = Integer.parseInt(textField_size.getText().trim());
			this.size = size;
			// Validate the size
			if (size <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid positive integer for queue size.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            	queue = new int[size];
            	JOptionPane.showMessageDialog(this, "Queue of size " + size + " created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid integer for queue size.", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			textField_size.setText("");
		}
	}
	
	private void enqueue(int element) {
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Queue is not created yet. Please create queue first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (isFull()) {
			JOptionPane.showMessageDialog(this, "Queue is full!", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		++rear;
		queue[rear] = element;
		JOptionPane.showMessageDialog(this, "Element " + element + " added to the queue!.", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void dequeue() {
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Queue is not created yet. Please create queue first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Queue is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
		
		++front;
		JOptionPane.showMessageDialog(this, "Element " + queue[front] + " deleted from the queue!.", "Success", JOptionPane.INFORMATION_MESSAGE);
		queue[front] = 0;
	}
	
	private void getElement(int index) {
		
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Queue is not created yet. Please create an Queue first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Queue is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
		}
		
		if (index < front || index > rear){
	        JOptionPane.showMessageDialog(this, "Invalid position. Please enter a position between " + (front + 1) + " and " + rear + ".", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
		}	
		
		StringBuilder queueElement = new StringBuilder("");
		queueElement.append(queue[index]);
		textField_get.setText(queueElement.toString());
	}
	
	private void display() {
		
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Queue is not created yet. Please create an Queue first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (isEmpty()) {
			textField_display.setText("");
	        JOptionPane.showMessageDialog(this, "Queue is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
		}
		
		StringBuilder queueContent = new StringBuilder("Queue elements: ");
	    for (int i = 0; i <= rear; i++) {
	        queueContent.append(queue[i]).append(" ");
	    }
	    textField_display.setText(queueContent.toString());
		
	}
	
	private boolean isNull() {
		return queue == null;
	}
	
	private boolean isFull() {
		return rear == size - 1;
	}
	
	private boolean isEmpty() {
		return rear == -1 || front == size - 1;
	}

}
