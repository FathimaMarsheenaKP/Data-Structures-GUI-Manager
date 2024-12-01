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

public class DoublyLinkedList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Node first;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinkedList frame = new DoublyLinkedList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class Node {
	    Node preLink;
		int data;
	    Node nextLink;

	    public Node(int data) {
	        this.preLink = null;
	    	this.data = data;
	        this.nextLink = null;
	    }
	}

	/**
	 * Create the frame.
	 */
	public DoublyLinkedList() {
		first = null;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fathi\\OneDrive\\Desktop\\Kodnest\\Java\\DSAImplementation\\Image\\Doubly.png"));
		lblNewLabel.setBounds(0, 0, 773, 640);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DOUBLY LINKED LIST");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(229, 39, 339, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(113, 117, 86, 48);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(209, 117, 137, 48);
		contentPane.add(textField);
		
		JButton btnInsertFront = new JButton("<html><div align='center'>Insert<br> at Front</div></html>");
		btnInsertFront.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsertFront.setBounds(403, 117, 123, 48);
		contentPane.add(btnInsertFront);
		
		btnInsertFront.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                	int element = Integer.parseInt(input);
                    insertAtFront(element);  // Insert at front
//                    JOptionPane.showMessageDialog(SinglyLinkedList.this, "Element inserted at the front: " + element, "Success", JOptionPane.INFORMATION_MESSAGE);
                    textField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
           }
      });
		
		JButton btnInsertRear = new JButton("<html><div align='center'>Insert<br> at Rear</div></html>");
		btnInsertRear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsertRear.setBounds(571, 117, 123, 48);
		contentPane.add(btnInsertRear);
		
		btnInsertRear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                	int element = Integer.parseInt(input);
                    insertAtRear(element);  // Insert at rear
//                    JOptionPane.showMessageDialog(SinglyLinkedList.this, "Element inserted at the rear: " + element, "Success", JOptionPane.INFORMATION_MESSAGE);
                    textField.setText("");
                } catch (NumberFormatException ex) {
                	JOptionPane.showMessageDialog(DoublyLinkedList.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
           }
        });
		
		JButton btndeleteFromFront = new JButton("<html><div align='center'>Delete<br> From Front</div></html>");
		btndeleteFromFront.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndeleteFromFront.setBounds(240, 228, 123, 48);
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
		btndeleteFromRear.setBounds(444, 228, 123, 48);
		contentPane.add(btndeleteFromRear);
		
		btndeleteFromRear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				deleteFromRear();
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(113, 348, 412, 48);
		contentPane.add(textField_1);
		
		JButton btnDisplay = new JButton("<html><div align='center'>Display<br> Forward</div></html>");
		btnDisplay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDisplay.setBounds(571, 348, 123, 48);
		contentPane.add(btnDisplay);
		
		btnDisplay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				displayForward();
			}
		});
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(113, 466, 412, 48);
		contentPane.add(textField_2);
		
		JButton btnDisplay_1 = new JButton("<html><div align='center'>Display<br> Reverse</div></html>");
		btnDisplay_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDisplay_1.setBounds(571, 466, 123, 48);
		contentPane.add(btnDisplay_1);
		
		btnDisplay_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the window;
				displayReverse();
			}
		});
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(352, 557, 107, 48);
		contentPane.add(btnNewButton_1);
		
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
			first = node;
		} else if (first.nextLink == null) {
			first.nextLink = node;
			node.preLink = first;
		} else {
			Node temp = first;
			while (temp.nextLink != null) {
				temp = temp.nextLink;
			}
			temp.nextLink = node;
			node.preLink = temp;
		}
	}
	
	private void insertAtFront(int element) {
		Node node = new Node(element);
		
		if (first == null) {
			first = node;
		} else {
			node.nextLink = first;
			first.preLink = node;
			first = node;
		}
	}
	
	private void deleteFromRear() {
		if (first == null) {
			JOptionPane.showMessageDialog(this, "Deletion not possible: Doubly Linked list is empty.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (first.nextLink == null){
	        JOptionPane.showMessageDialog(this, "Node with data " + first.data + " deleted from the rear.", "Success", JOptionPane.INFORMATION_MESSAGE);
			first = null;
			return;
		} 
		Node temp = first;
		while (temp.nextLink.nextLink != null) {
			temp = temp.nextLink;
		}
        JOptionPane.showMessageDialog(this, "Node with data " + temp.nextLink.data + " deleted from the rear.", "Success", JOptionPane.INFORMATION_MESSAGE);
		temp.nextLink.preLink = null;
		temp.nextLink = null;
	}
	
	private void deleteFromFront() {
		if (first == null) {
			JOptionPane.showMessageDialog(this, "Deletion not possible: Doubly Linked list is empty.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} 
		if (first.nextLink == null) {
	        JOptionPane.showMessageDialog(this, "Node with data " + first.data + " deleted from the front.", "Success", JOptionPane.INFORMATION_MESSAGE);
			first = null;
			return;
		} 
        JOptionPane.showMessageDialog(this, "Node with data " + first.data + " deleted from the front.", "Success", JOptionPane.INFORMATION_MESSAGE);
		first = first.nextLink;
		first.preLink.nextLink = null;
		first.preLink = null;	
	}
	
	private void displayForward() {
		if (first == null) {
			textField_1.setText("");
			JOptionPane.showMessageDialog(this, "Doubly Linked list is empty!.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Node temp = first;
		StringBuilder listContent = new StringBuilder();
		while (temp != null) {
			listContent.append(temp.data).append(" -> ");
			temp = temp.nextLink;
		}
		listContent.append("null");
		textField_1.setText(listContent.toString());
	}
	
	private void displayReverse() {
		if (first == null) {
			textField_2.setText("");
			JOptionPane.showMessageDialog(this, "Doubly Linked list is empty!.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Node temp = first;
		StringBuilder reverseListContent = new StringBuilder();
		
		while (temp.nextLink != null) {
			temp = temp.nextLink;
		}
		
		
		while (temp != null) {
			reverseListContent.append(temp.data).append(" -> ");
			temp = temp.preLink;
		}
		reverseListContent.append("null");
		textField_2.setText(reverseListContent.toString());

	}
	
}
