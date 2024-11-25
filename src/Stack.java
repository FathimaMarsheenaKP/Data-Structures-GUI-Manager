import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Stack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_size;
	private JTextField textField_ele;
	private JTextField textField_pos;
	private JTextField textField_get;
	private JTextField textField_display;
	private int size = 0;
	private int[] stack;
	private int top = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fathi\\Downloads\\output-onlinepngtools (7).png"));
		lblNewLabel.setBounds(0, -10, 773, 640);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("STACK");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(319, 37, 116, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(132, 116, 68, 48);
		contentPane.add(lblNewLabel_2);
		
		textField_size = new JTextField();
		textField_size.setColumns(10);
		textField_size.setBounds(210, 116, 298, 48);
		contentPane.add(textField_size);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(568, 116, 107, 48);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the array size from the text field
				createStack(size);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Element");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(96, 229, 86, 33);
		contentPane.add(lblNewLabel_3);
		
		textField_ele = new JTextField();
		textField_ele.setColumns(10);
		textField_ele.setBounds(212, 226, 173, 48);
		contentPane.add(textField_ele);
		
		JButton btnPush = new JButton("Push");
		btnPush.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPush.setBounds(426, 226, 82, 48);
		contentPane.add(btnPush);
		
		btnPush.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int element = Integer.parseInt(textField_ele.getText().trim());
					push(element);
					textField_ele.setText("");
				} catch (NumberFormatException ex) {
					 JOptionPane.showMessageDialog(null, "Please enter valid integers for element.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnPop = new JButton("Pop");
		btnPop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPop.setBounds(568, 226, 107, 48);
		contentPane.add(btnPop);
		
		btnPop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					pop();
			}
		});
		
		JLabel lblNewLabel_3_2 = new JLabel("Position");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(96, 337, 86, 56);
		contentPane.add(lblNewLabel_3_2);
		
		textField_pos = new JTextField();
		textField_pos.setColumns(10);
		textField_pos.setBounds(210, 346, 175, 48);
		contentPane.add(textField_pos);
		
		JButton btnGet = new JButton("Get");
		btnGet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGet.setBounds(426, 345, 82, 48);
		contentPane.add(btnGet);
		
		textField_get = new JTextField();
		textField_get.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_get.setColumns(10);
		textField_get.setBounds(568, 346, 107, 48);
		contentPane.add(textField_get);
		
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
		
		textField_display = new JTextField();
		textField_display.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_display.setColumns(10);
		textField_display.setBounds(96, 449, 412, 48);
		contentPane.add(textField_display);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDisplay.setBounds(568, 449, 107, 48);
		contentPane.add(btnDisplay);
		
		btnDisplay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		
		JButton btnNewButton_1_2 = new JButton("BACK");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(339, 536, 107, 48);
		contentPane.add(btnNewButton_1_2);
		
		btnNewButton_1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				dispose();
			}
		});
		
	}
	
	private void createStack(int size) {
		try {
			size = Integer.parseInt(textField_size.getText().trim());
			this.size = size;
			// Validate the size
			if (size <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid positive integer for stack size.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            	stack = new int[size];
            	JOptionPane.showMessageDialog(this, "Stack of size " + size + " created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid integer for stack size.", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			textField_size.setText("");
		}
	}
	
	private void push(int element) {
		if (stack == null) {
	        JOptionPane.showMessageDialog(this, "Stack is not created yet. Please create stack first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		if (top == size - 1) {
			JOptionPane.showMessageDialog(this, "Stack is full!", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		++top;
		stack[top] = element;
		JOptionPane.showMessageDialog(this, "Element " + element + " pushed to the stack!.", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void pop() {
		if (stack == null) {
	        JOptionPane.showMessageDialog(this, "Stack is not created yet. Please create stack first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (top == -1) {
			JOptionPane.showMessageDialog(this, "Stack is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(this, "Element " + stack[top] + " deleted from the stack!.", "Success", JOptionPane.INFORMATION_MESSAGE);
		stack[top] = 0;	
		--top;
	}
	
	private void getElement(int index) {
		int count = -1;
		if (stack == null) {
	        JOptionPane.showMessageDialog(this, "Stack is not created yet. Please create an Stack first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (top == -1) {
	        JOptionPane.showMessageDialog(this, "Stack is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
		
		if (index > top) {
	        JOptionPane.showMessageDialog(this, "Invalid position. Please enter a position between 0 and " + top + ".", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
		}
		
		if (index <= top) {
			StringBuilder stackElement = new StringBuilder("");
			stackElement.append(stack[index]);
			textField_get.setText(stackElement.toString());
		}
	}
	
	private void display() {
		if (stack == null) {
	        JOptionPane.showMessageDialog(this, "Stack is not created yet. Please create an Stack first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (top == -1) {
			textField_display.setText("");
	        JOptionPane.showMessageDialog(this, "Stack is empty!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
		
		 // Create a string to represent stack elements
	    StringBuilder stackContent = new StringBuilder("Stack elements: ");
	    for (int i = 0; i <= top; i++) {
	        stackContent.append(stack[i]).append(" ");
	    }
	    textField_display.setText(stackContent.toString());
	}
	
}
