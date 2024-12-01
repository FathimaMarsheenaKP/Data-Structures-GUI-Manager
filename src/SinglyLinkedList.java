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

public class SinglyLinkedList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_ele;
	private JTextField textField_display;
	
	private Node first;
	private JTextField textField_reverse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLinkedList frame = new SinglyLinkedList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class Node {
	    int data;
	    Node nextLink;

	    public Node(int data) {
	        this.data = data;
	        this.nextLink = null;
	    }
	}

	/**
	 * Create the frame.
	 */
	public SinglyLinkedList() {
		
		first = null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\DSAImplementation\\Image\\Singly.png"));
		lblNewLabel.setBounds(0, 10, 773, 630);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SINGLY LINKED LIST");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(225, 36, 339, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(75, 123, 86, 48);
		contentPane.add(lblNewLabel_3);
		
		textField_ele = new JTextField();
		textField_ele.setColumns(10);
		textField_ele.setBounds(191, 123, 137, 48);
		contentPane.add(textField_ele);
		
		JButton btnInsertFront = new JButton("<html><div align='center'>Insert<br> at Front</div></html>");
		btnInsertFront.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsertFront.setBounds(383, 123, 123, 48);
		contentPane.add(btnInsertFront);
		
		btnInsertFront.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField_ele.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(SinglyLinkedList.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                	int element = Integer.parseInt(input);
                    insertAtFront(element);  // Insert at front
//                    JOptionPane.showMessageDialog(SinglyLinkedList.this, "Element inserted at the front: " + element, "Success", JOptionPane.INFORMATION_MESSAGE);
                    textField_ele.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SinglyLinkedList.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
           }
      });
		
		JButton btnInsertRear = new JButton("<html><div align='center'>Insert<br> at Rear</div></html>");
		btnInsertRear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsertRear.setBounds(556, 123, 123, 48);
		contentPane.add(btnInsertRear);
		
		btnInsertRear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField_ele.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(SinglyLinkedList.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                	int element = Integer.parseInt(input);
                    insertAtRear(element);  // Insert at rear
//                    JOptionPane.showMessageDialog(SinglyLinkedList.this, "Element inserted at the rear: " + element, "Success", JOptionPane.INFORMATION_MESSAGE);
                    textField_ele.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SinglyLinkedList.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
           }
      });
		
		JButton btndeleteFromFront = new JButton("<html><div align='center'>Delete<br> From Front</div></html>");
		btndeleteFromFront.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndeleteFromFront.setBounds(241, 252, 123, 48);
		contentPane.add(btndeleteFromFront);
		
		btndeleteFromFront.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				deleteFromFront();
			}
		});
		
		JButton btndeleteFromRear = new JButton("<html><div align='center'>Delete<br> From Rear</div></html>");
		btndeleteFromRear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndeleteFromRear.setBounds(455, 252, 123, 48);
		contentPane.add(btndeleteFromRear);
		
		btndeleteFromRear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				deleteFromRear();
			}
		});
		
		textField_display = new JTextField();
		textField_display.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_display.setColumns(10);
		textField_display.setBounds(75, 352, 412, 48);
		contentPane.add(textField_display);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDisplay.setBounds(556, 348, 123, 48);
		contentPane.add(btnDisplay);
		
		btnDisplay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(353, 542, 107, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnReverse = new JButton("Reverse");
		btnReverse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReverse.setBounds(556, 454, 123, 48);
		contentPane.add(btnReverse);
		
		textField_reverse = new JTextField();
		textField_reverse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_reverse.setColumns(10);
		textField_reverse.setBounds(75, 454, 412, 48);
		contentPane.add(textField_reverse);
		
		btnReverse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reverse();
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				dispose();
			}
		});
	}
	
	private void insertAtRear(int element) {
		Node node = new Node(element);
		if (first == null) {
			// If the list is empty, set the new node as the first node
			first = node;
		} else if (first.nextLink == null) {
			// If there's only one node in the list, link it to the new node
			first.nextLink = node;
		} else {
			// If there are multiple nodes, traverse to the last node and link the new node
			Node temp = first;
			while (temp.nextLink != null) {
				temp = temp.nextLink;
			}
			temp.nextLink = node;
		}
	}
	
	private void insertAtFront(int element) {
		Node node = new Node(element);
		if (first == null) {
			first = node;
		} else {
			node.nextLink = first;
			first = node;
		}
	}
	
	private void deleteFromRear() {
		if (first == null) {
			JOptionPane.showMessageDialog(this, "Deletion not possible: Linked list is empty.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}  
		if (first.nextLink == null) {
	        JOptionPane.showMessageDialog(this, "Node with data " + first.data + " deleted from the end.", "Success", JOptionPane.INFORMATION_MESSAGE);
			first = null;
			return;
		} 
		Node temp = first;
		while (temp.nextLink.nextLink != null) {
			temp = temp.nextLink;
		}
        JOptionPane.showMessageDialog(this, "Node with data " + temp.nextLink.data + " deleted from the end.", "Success", JOptionPane.INFORMATION_MESSAGE);
		temp.nextLink = null;
	}
	
	private void deleteFromFront() {
		if (first == null) {
			JOptionPane.showMessageDialog(this, "Deletion not possible: Linked list is empty.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (first.nextLink == null) {
			JOptionPane.showMessageDialog(this, "Node with data " + first.data + " deleted from the front.", "Success", JOptionPane.INFORMATION_MESSAGE);
			first = null;
			return;
		}
		
        JOptionPane.showMessageDialog(this, "Node with data " + first.data + " deleted from the front.", "Success", JOptionPane.INFORMATION_MESSAGE);
		first = first.nextLink;
	}
	
	private void display() {
		if (first == null) {
			textField_display.setText("");
			JOptionPane.showMessageDialog(this, "Linked list is empty!.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Node temp = first;
		StringBuilder listContent = new StringBuilder();
		
		 while (temp != null) {
			 listContent.append(temp.data).append(" -> ");  // Add each node's data
		        temp = temp.nextLink;  // Move to the next node
		    }
		    
		 listContent.append("null");  // End of the list
		    
		    // Set the text of textField_display to show the linked list
		    textField_display.setText(listContent.toString());
	}
	
	private void reverse() {
		if (first == null) {
		    textField_reverse.setText("");
	        JOptionPane.showMessageDialog(this, "Linked list is empty!", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		
		Node previous = null;
	    Node current = first;
	    Node next = null;
	    
	    while (current != null) {
	        next = current.nextLink; // Store the next node
	        current.nextLink = previous; // Reverse the current node's pointer
	        previous = current; // Move the previous pointer forward
	        current = next; // Move the current pointer forward
	    }
	    
	    first = previous; // Update the head to the new first node
	    
	    Node temp = first;
	    StringBuilder reversedListContent = new StringBuilder();
	    
	    while (temp != null) {
	        reversedListContent.append(temp.data).append(" -> "); // Add each node's data
	        temp = temp.nextLink; // Move to the next node
	    }
	    reversedListContent.append("null"); // End of the list

	    textField_reverse.setText(reversedListContent.toString());
	}
}
