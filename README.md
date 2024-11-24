# Data Structures GUI Manager

This project provides a **Graphical User Interface (GUI)** for managing and interacting with various data structures in Java. Users can interact with data structures such as arrays, stacks, queues, circular queues, singly linked lists, and doubly linked lists. The interface allows users to create, delete, and display elements within each data structure.

## Features

- **Interactive GUI**: The project offers a simple and user-friendly interface where users can interact with different data structures.
- **Create Elements**: Users can add new elements to the data structure.
- **Delete Elements**: Users can remove elements from the data structure by specifying the position or value.
- **Display Elements**: Users can view the elements present in the data structure at any time.
- **Supports Multiple Data Structures**: Includes implementations of arrays, stacks, queues, circular queues, singly linked lists, and doubly linked lists.

## Data Structures Implemented

### 1. **Array**
   - Allows users to create an array, add, delete, and display elements in the array. Users can specify an index for insertion or deletion.

### 2. **Stack**
   - A stack follows the **Last In First Out (LIFO)** principle. Users can add elements (push), remove elements (pop), and display the current stack.

### 3. **Queue**
   - A queue follows the **First In First Out (FIFO)** principle. Users can enqueue (add), dequeue (remove), and view the queue contents.

### 4. **Circular Queue**
   - A circular queue improves upon the traditional queue by allowing wrap-around behavior. The last element points to the first one, forming a circle. Users can perform enqueue, dequeue, and display operations.

### 5. **Singly Linked List**
   - A singly linked list allows adding, removing, and displaying nodes. It operates in a sequential manner, where each node points to the next.

### 6. **Doubly Linked List**
   - A doubly linked list allows traversing in both directions. It supports adding, removing, and displaying nodes, with each node containing a reference to both the next and previous nodes.

## How to Use the Interface

1. **Launch the Application**:
   - The user opens the program, and a GUI is displayed with buttons to interact with each data structure (Array, Stack, Queue, Circular Queue, Singly Linked List, Doubly Linked List).

2. **Choose a Data Structure**:
   - Click on any of the available data structures to start interacting with it.

3. **Perform Operations**:
   - **Create**: Add elements by entering values and specifying positions (where applicable).
   - **Delete**: Remove elements from a data structure by specifying the position or value to be deleted.
   - **Display**: View the current elements in the selected data structure.

### Example Workflow for Array

1. Click on **Array**.
2. Select the **Create** button to add a new element to the array. You will be prompted to enter a value and index.
3. To delete an element, click **Delete** and enter the index of the element you want to remove.
4. Click **Display** to see the elements in the array.

### Example Workflow for Stack

1. Click on **Stack**.
2. To add an element, click **Push** and enter the value.
3. To remove an element, click **Pop**.
4. Click **Display** to see the current stack contents.

### Example Workflow for Queue

1. Click on **Queue**.
2. To add an element, click **Enqueue** and enter the value.
3. To remove an element, click **Dequeue**.
4. Click **Display** to see the elements in the queue.

### Example Workflow for Circular Queue

1. Click on **Circular Queue**.
2. To add an element, click **Enqueue**.
3. To remove an element, click **Dequeue**.
4. Click **Display** to see the elements in the circular queue.

### Example Workflow for Singly Linked List

1. Click on **Singly Linked List**.
2. To add a node, click **Add Node** and enter the value.
3. To delete a node, click **Delete Node**.
4. Click **Display** to view the nodes in the list.

### Example Workflow for Doubly Linked List

1. Click on **Doubly Linked List**.
2. To add a node, click **Add Node** and enter the value.
3. To delete a node, click **Delete Node**.
4. Click **Display** to view the nodes in the list.

## Getting Started

### Prerequisites
- **Java 8** or higher

### How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/data-structures-gui.git

2. Compile and run the application:
   ```bash
   javac DataStructureGUI.java
   java DataStructureGUI

## UI Controls

- **Buttons**: Each data structure has buttons for creating, deleting, and displaying elements.
- **Text Fields**: Enter values for creation or deletion and to view the displayed elements.
- **Labels**: Information about the actions performed (success, error messages).

## Example Usages

### Array
- **Create**: Click the **Create** button to add an element to the array.
- **Delete**: Click the **Delete** button to remove an element from the array at a given position.
- **Display**: View the elements currently in the array.

### Stack
- **Push**: Add a new element to the stack by clicking the **Push** button.
- **Pop**: Remove the top element from the stack by clicking the **Pop** button.
- **Display**: View the current stack.

### Queue
- **Enqueue**: Add a new element to the queue by clicking the **Enqueue** button.
- **Dequeue**: Remove the front element from the queue by clicking the **Dequeue** button.
- **Display**: View the elements in the queue.

### Circular Queue
- **Enqueue**: Add an element to the circular queue.
- **Dequeue**: Remove an element from the circular queue.
- **Display**: See the elements in the circular queue.

### Singly Linked List
- **Add Node**: Add a new node at the end or beginning of the list.
- **Delete Node**: Remove a node from the list.
- **Display**: View the linked list nodes.

### Doubly Linked List
- **Add Node**: Add a node at the beginning or end of the doubly linked list.
- **Delete Node**: Remove a node from the list.
- **Display**: View the doubly linked list from both directions.

## Contributions

Feel free to fork the repository and make contributions. Open issues or pull requests for bug fixes, improvements, or new features.
