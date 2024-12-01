import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Array extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_size;
	private JTextField textField_ele;
	private JTextField textField_pos1;
	private JTextField textField_pos2;
	private JTextField textField_display;
	private int[] arr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
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
	public Array() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\DSAImplementation\\Image\\Array.png"));
		lblNewLabel.setBounds(0, 0, 773, 640);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ARRAY");
		lblNewLabel_1.setOpaque(true);  // Make the label opaque so the background color is visible
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1.setBounds(290, 36, 156, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(61, 151, 68, 48);
		contentPane.add(lblNewLabel_2);
		
		textField_size = new JTextField();
		textField_size.setBounds(124, 151, 438, 48);
		contentPane.add(textField_size);
		textField_size.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(599, 151, 107, 48);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createArray();
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Element");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(61, 242, 86, 33);
		contentPane.add(lblNewLabel_3);
		
		textField_ele = new JTextField();
		textField_ele.setBounds(157, 236, 140, 48);
		contentPane.add(textField_ele);
		textField_ele.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Position");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(334, 235, 86, 49);
		contentPane.add(lblNewLabel_3_1);
		
		textField_pos1 = new JTextField();
		textField_pos1.setBounds(430, 236, 135, 48);
		contentPane.add(textField_pos1);
		textField_pos1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(599, 235, 107, 49);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int element = Integer.parseInt(textField_ele.getText().trim());
					int position = Integer.parseInt(textField_pos1.getText().trim());
					insertElement(position, element);
					textField_ele.setText("");
					textField_pos1.setText("");
				} catch (NumberFormatException ex) {
					 JOptionPane.showMessageDialog(null, "Please enter valid integers for element and position.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JLabel lblNewLabel_3_2 = new JLabel("Position");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(61, 322, 86, 56);
		contentPane.add(lblNewLabel_3_2);
		
		textField_pos2 = new JTextField();
		textField_pos2.setBounds(157, 330, 405, 48);
		contentPane.add(textField_pos2);
		textField_pos2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(599, 330, 107, 48);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int position = Integer.parseInt(textField_pos2.getText().trim());
					deleteElement(position);
					textField_pos2.setText("");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter valid integer position.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		textField_display = new JTextField();
		textField_display.setColumns(10);
		textField_display.setBounds(61, 431, 504, 48);
		contentPane.add(textField_display);
		
		JButton btnNewButton_1_1 = new JButton("Display");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(599, 434, 107, 45);
		contentPane.add(btnNewButton_1_1);
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display(arr);
			}
		});
		
		JButton btnNewButton_1_2 = new JButton("BACK");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(334, 528, 107, 48);
		contentPane.add(btnNewButton_1_2);
		
		// Action Listener to close the Array window
		btnNewButton_1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				dispose();
			}
		});
		
	}
	
	private void createArray() {
		try {
			if (!isNull()) {
	            JOptionPane.showMessageDialog(this, "Array already exists! Please delete the existing array to create a new one.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
			// Get the array size from the text field
			int size = Integer.parseInt(textField_size.getText().trim());
			// Validate the size
			if (size <= 0) {
                JOptionPane.showMessageDialog(this, "Please enter a valid positive integer for array size.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            	arr = new int[size];
            	JOptionPane.showMessageDialog(this, "Array of size " + size + " created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid integer for array size.", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			textField_size.setText("");
		}
	}
	
	private void insertElement(int position, int element) {
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Array is not created yet. Please create an array first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (position < 0 || position > arr.length) {
	        JOptionPane.showMessageDialog(this, "Invalid position. Please enter a position between 0 and " + arr.length + ".", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		arr[position] = element;
	    JOptionPane.showMessageDialog(this, "Element " + element + " inserted at position " + position + ".", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void deleteElement(int position) {
		if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Array is not created yet. Please create an array first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

		if (isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Array is empty. Cannot delete elements.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		if (position < 0 || position >= arr.length) {
	        JOptionPane.showMessageDialog(this, "Invalid position. Please enter a position between 1 and " + arr.length + ".", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		arr[position] = 0;
		JOptionPane.showMessageDialog(this, "Element at position " + position + " deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	
	private void display(int[] arr) {
	    if (isNull()) {
	        JOptionPane.showMessageDialog(this, "Array is not created yet. Please create an array first.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    if (isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Array is empty.", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	 // Create a string to display all elements of the array
	    StringBuilder arrayContent = new StringBuilder("Array elements: ");
	    boolean allZeroes = true;

	    for (int i = 0; i < arr.length; i++) {
	        arrayContent.append(arr[i]);
	        if (arr[i] != 0) {
	            allZeroes = false;  // If any element is not 0, set this flag to false
	        }
	        
	        if (i < arr.length - 1) {
	            arrayContent.append(", ");
	        }
	    }

	    if (allZeroes) {
	    	textField_display.setText("");
	        JOptionPane.showMessageDialog(this, "Array is empty.", "Info", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        // Show the array contents if it's not empty
	    	textField_display.setText(arrayContent.toString());
	    }
	}
	
	private boolean isNull() {
		return arr == null;
	}
	
	private boolean isEmpty() {
	    for (int value : arr) {
	        if (value != 0) { // Assuming 0 represents an empty value
	            return false; // Found a non-empty element
	        }
	    }
	    return true; // All elements are empty
	}
}