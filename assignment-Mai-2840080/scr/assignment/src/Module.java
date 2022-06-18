public class Module
{
	private int code; // internal code of the module eg. 5246
	private String name; // name of the module
	private BinaryTree btree; // binary tree that stores the students enrolled in this module
	private Professor prof; // Professor teaching this module
	
	/**
	 * Constructor
	 * @param c internal code
	 * @param n name
	 * @param p Professor
	 */
	public Module(int c, String n, Professor p) {
		this.code = c;
		this.name = n;
		this.btree = new BinaryTree(); // empty
		this.prof = p;
	}
	/**
	 * Constructor
	 * @param c internal code
	 * @param n name
	 * @param bt binaryTree with the students enrolled in the module
	 * @param p Professor
	 */
	public Module(int c, String n, BinaryTree bt, Professor p) {
		this.code = c;
		this.name = n;
		this.btree = bt;
		this.prof = p;
	}
	
	// getters and setters!
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public BinaryTree getBtree() {
		return btree;
	}
	public void setBtree(BinaryTree btree) {
		this.btree = btree;
	}
	
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}

	// From here, we start methods related to the binary tree 
	// that stores the list of students
	/**
	 * Add a Student to the binary tree
	 * @param s The Student
	 */
	public void addStudent(Student s)
	{
		btree.addNode(s);
		s.addModule(1);
	}
	
	/**
	 * In-order traversal method
	 * @return A String with the names of all Students in the tree
	 */
	public String inWalk()
	{
		return btree.inOrderTraversal();
	}

	/**
	 * Find a student in the binary tree using the name
	 * @param name The name of the student you are searching for
	 * @return A reference to the Student that was found or null if no Student found
	 */
	public Person find(String name)
	{
		return btree.find(name);
	}
	
	/**
	 * Method for printing the tree
	 */
	public void describeStudentTree()
	{	
		btree.printTree();
	}

	/**
	 * Get a description of the Module as a String
	 */
	public String toString() {
		return "Module: " + code + " - " + name + " -- Students: " + btree.inOrderTraversal(); 
	}
	public int compareTo(Module module) {
		// TODO Auto-generated method stub
		return 0;
	}
}
