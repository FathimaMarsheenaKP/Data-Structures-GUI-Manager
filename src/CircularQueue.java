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

public class CircularQueue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_size;
	private JTextField textField_ele;
	private JTextField textField_peek;
	private JTextField textField_display;
	
	private int size = 0;
	private int[] cqueue = null;
	private int front = -1;
	private int rear = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\DSAImplementation\\Image\\Circular.png"));
		lblNewLabel.setBounds(0, 0, 773, 640);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CIRCULAR QUEUE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(254, 32, 295, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(88, 98, 68, 48);
		contentPane.add(lblNewLabel_2);
		
		textField_size = new JTextField();
		textField_size.setColumns(10);
		textField_size.setBounds(166, 98, 298, 48);
		contentPane.add(textField_size);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(546, 98, 123, 48);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the array size from the text field
				createCQueue(size);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Element");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(70, 206, 86, 48);
		contentPane.add(lblNewLabel_3);
		
		textField_ele = new JTextField();
		textField_ele.setColumns(10);
		textField_ele.setBounds(166, 206, 137, 48);
		contentPane.add(textField_ele);
		
		JButton btnEnqueue = new JButton("Enqueue");
		btnEnqueue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEnqueue.setBounds(341, 206, 123, 48);
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
		
		JButton btnDequeue = new JButton("Dequeue");
		btnDequeue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDequeue.setBounds(546, 206, 123, 48);
		contentPane.add(btnDequeue);
		
		btnDequeue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				dequeue();
			}
		});
		
		textField_peek = new JTextField();
		textField_peek.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_peek.setColumns(10);
		textField_peek.setBounds(70, 319, 412, 48);
		contentPane.add(textField_peek);
		
		JButton btnPeek = new JButton("Peek");
		btnPeek.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPeek.setBounds(546, 319, 123, 48);
		contentPane.add(btnPeek);
		
		btnPeek.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				peek();
			}
		});
		
		textField_display = new JTextField();
		textField_display.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_display.setColumns(10);
		textField_display.setBounds(70, 435, 412, 48);
		contentPane.add(textField_display);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDisplay.setBounds(546, 435, 123, 48);
		contentPane.add(btnDisplay);
		
		btnDisplay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(341, 532, 107, 48);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				dispose();
			}
		});
	}
	
	private boolean isNull() {
		return cqueue == null;
	}
	
	private void createCQueue(int size) {
		try {
			if (!isNull()) {
	            JOptionPane.showMessageDialog(this, "Circular Queue already exists! Please delete the existing circular queue to create a new one.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
			size = Integer.parseInt(textField_size.getText().trim());
			this.size = size;
			// Validate the size
			if (size <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid positive integer for Circule queue size.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            	cqueue = new int[size];
            	JOptionPane.showMessageDialog(this, "Circular Queue of size " + size + " created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid integer for Circular queue size.", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			textField_size.setText("");
		}
	}
	
	private boolean isFull() {
		return (rear + 1) % size == front;
	}
	
	private boolean isEmpty() {
		return front == -1;
	}
	
	private void enqueue(int element) {
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Circular Queue is not created yet. Please create circular queue first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (isFull()) {
			JOptionPane.showMessageDialog(this, "Circular Queue is full!", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if (front == -1) {
			front = 0;
		} 
		
		rear = (rear + 1) % size;
		cqueue[rear] = element;
		JOptionPane.showMessageDialog(this, "Element " + element + " added to the circular queue!.", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void dequeue() {
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Circular Queue is not created yet. Please create circular queue first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Circular Queue is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
		}
		
		JOptionPane.showMessageDialog(this, "Element " + cqueue[front] + " removed from the circular queue!.", "Success", JOptionPane.INFORMATION_MESSAGE);
		if (front == rear) {
			front = rear = -1;
			return;
		}
		front = (front + 1) % size;
	}
	
	private void peek() {
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Circular Queue is not created yet. Please create circular queue first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (isEmpty()) {
			textField_peek.setText("");
	        JOptionPane.showMessageDialog(this, "Circular Queue is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
		}
		
		StringBuilder cqueueElement = new StringBuilder("Peek element is ");
		cqueueElement.append(cqueue[front]);
		textField_peek.setText(cqueueElement.toString());
	}
	
	private void display() {
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Circular Queue is not created yet. Please create circular queue first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (isEmpty()) {
			textField_display.setText("");
	        JOptionPane.showMessageDialog(this, "Circular Queue is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
		}
		
		StringBuilder cqueueContent = new StringBuilder("Circular Queue elements: ");
		int i = front;
		while (true) {
			cqueueContent.append(cqueue[i]).append(" ");
			if (rear == i) {
				break;
			}
			i = (i + 1) % size;
		}
		textField_display.setText(cqueueContent.toString());
	}

}
