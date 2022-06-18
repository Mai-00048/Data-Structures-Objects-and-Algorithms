/**
 * Please provide your student ID below.
 * 
 * 	Student ID: ????????
 */

/**Student ID: 2840080
 * BinaryTree - An example of a Binary Tree built using Node objects. Some of
 * the functionality for this class is provided for you (and may provide clues
 * as to how to implement assignment methods). Your task is to implement the
 * method bodies for:
 * 
 * protected void inOrder(Node n, StringBuffer sb)
 * protected Person find(String name, Node n)
 * 
 */
public class BinaryTree {

	private Node root; // The root node of the tree
	private int size; // A count of the nodes in the tree

	public BinaryTree(Person[] sdtList) {
		root = null;
		size = 0;
		
		for (Person s : sdtList) {
			addNode(s);
		}
	}

	public BinaryTree() {
		root = null;
		size = 0;
	}

	/**
	 * Returns the number of nodes in the tree.
	 * 
	 * @return Number of nodes in the tree.
	 */
	public int size() {
		return size;
	}

	/**
	 * Empties the tree
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Determines if the tree is empty or not.
	 * 
	 * @return true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (root == null);
	}
	
	/**
	 * Adds a Node containing a reference to a Person to the tree.
	 * 
	 * @param a   The content of the node that will be added
	 */
	public void addNode(Person a) {
		Node node = new Node(a);

		// If tree is empty, make our new node the root and leave
		if (root == null) {
			root = node;
			size = 1;
		} else {
			// Start the recursive calls to add the descendants of node 'p'
			addNode(node, root);
			size = size + 1;
		}

	}

	/**
	 * Internal recursive method to add a node to the tree.
	 * 
	 * @param c   The content to place in the tree
	 * @param n   The current node to consider, will not be null
	 */
	private void addNode(Node c, Node n) {
		// Is our new node content less than our current node content?
		// If it is, we add it to the left side of the tree so that when
		// we walk it with an in-order traversal, the tree content will
		// come out in alphabetic order. Conversely add it to the right if it
		// is greater.
		if (c.compareTo(n) < 0) {
			if (n.hasLeft())
				addNode(c, n.left());
			else {
				// The current left node is null so we can
				// attach our new node to the left of the current node
				n.setLeft(c);
				return;
			}
		} else {
			if (n.hasRight())
				addNode(c, n.right());
			else {
				// The current right node is null so we can
				// attach our new node to the right of the current node
				n.setRight(c);
				return;
			}
		}
	}

	/**
	 * Public call to start a recursive in-order traversal using the root of the
	 * tree. In-order traversal is often called in-fix traversal.
	 * 
	 * @return A reference to a comma separated String containing the trees contents
	 *         as determined by an in-order traversal.
	 */
	public String inOrderTraversal() {
		StringBuffer buff = new StringBuffer();

		if (root == null)
			return "Empty Tree!";
		else
			inOrder(root, buff);

		return buff.toString();

	}

	/**
	 * Private method used to make a recursive in-order traversal from node 'n' You
	 * should provide the correct recursive implementation for this method.
	 * 
	 * @param n The node to perform the inOrder walk from
	 * @param sb The string that will be returned in the end of the process
	 */
	protected void inOrder(Node n, StringBuffer sb) {
		 if (n.left() == null && n.right() == null) {
	            sb.append(n.getPersonName() + ",");
	        } else {
	            sb.append(n.getPersonName() + ",");
	            if (n.left() != null) inOrder(n.left(),sb);
	            else sb.append("");
	            if (n.right() != null) inOrder(n.right(),sb);
	            sb.append("");
	        }
		
	}

	

	/**
	 * Find the reference for a given Person by 'name'
	 * 
	 * @param name The Person name to search for
	 * @return A reference to the Person that was found or null if no Person found
	 */
	public Person find(String name) {
		return find(name, root);
	}

	/**
	 * Internal protected method used to search the tree from node 'n' looking for a
	 * Person with the given 'name'. You should provide the correct recursive
	 * implementation for this method. Some helpful lines of code have been
	 * included...
	 * 
	 * @param name	The name of the Person to search for
	 * @param n		The current node in the tree to search from
	 * @return		A reference to the node that was found or null if not found
	 */
	protected Person find(String name, Node n) {
		
	    while (n != null) {
	        if (name.compareTo(n.getPersonName()) == 0) {
	            return n;
	        }
	        // This will drop out of the loop naturally if there's no appropriate subnode
	        n = 1 < name.compareTo(n.getPersonName()) ? n.left() : n.right();
	    }
	    return null;
	}
		


	public void printTree() {
		printTree(root, 0);
	}

	/**
	 * Internal method used to make a recursive reverse order walk from node 'n'.
	 * This method is useful to see the current structure of the tree (turned on its
	 * side)
	 * 
	 * @param n   	The node to start the reverse order walk from
	 * @param depth	The current depth of the node in the tree
	 */
	private void printTree(Node n, int depth) {
		if (n.hasRight())
			printTree(n.right(), depth + 1);

		// Show depth of current code by indenting to the right
		for (int d = 0; d < depth; d++)
			System.out.print("  ");

		System.out.println(n.getPersonName());

		if (n.hasLeft())
			printTree(n.left(), depth + 1);
	}

}
