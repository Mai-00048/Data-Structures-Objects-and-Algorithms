/**
 * Please provide your student ID below.
 * 
 * 	Student ID: 2840080
 */
public class Student implements Person {

    protected static int MAX_NUM_MODULES = 5; // maximum number of modules that a student can enroll

    protected String fullName;
    protected int registrationNumber;
    protected String email;
    protected int numberModules;
    protected String programmeName;
    protected boolean isARUAA;

    /**
     * Constructor
     *
     * @param fn Full Name
     * @param registrationNumber Registration Number
     * @param email Email
     */
    public Student(String fn, int registrationNumber, String email) {
        this.fullName = fn;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.numberModules = 0;
        // question [2]
        this.programmeName = "Bachelor of Science";
        this.isARUAA = false;
    }

    /**
     * @return the full name of the student
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set/change the full name of the student
     *
     * @param fn The new full name
     */
    public void setFullName(String fn) {
        this.fullName = fn;
    }

    /**
     * @return the registration number of the student
     */
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Set/change the registration number of the student
     *
     * @param rn The new registration number
     */
    public void setRegistrationNumber(int rn) {
        this.registrationNumber = rn;
    }

    /**
     * @param inter - add/increment this many modules to this student
     * @return true if the modules were added successfully
     */
    /**
     * @return the Number of Modules of the student
     */
    public int getNumberModule() {
        return this.numberModules;
    }

    //-----------------------------------
	// Getter method for ProgrammeName
    public String getProgrammeName() {
        return programmeName;
    }
	// Setter method for ProgrammeName
    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

	// Constructor
    public Student(String fullName, int registrationNumber, String email, String programmeName) {
        this.fullName = fullName;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.programmeName = programmeName;
		// initialize isARUAA to false
        this.isARUAA = false;
    }
	// Getter method for isARUAA
    public boolean isARUAA() {
        return isARUAA;
    }
	// Set isARUAA to true
    public void isARUAAStudent() {
        this.isARUAA = true;
    }
	// set isARUAA to false
    public void isNotARUAAStudent() {
        this.isARUAA = false;
    }
	
	// method to add module with check max number of modules  
    public boolean addModule(int inter) {
        boolean isAltered = false;
        if (numberModules < MAX_NUM_MODULES) {
            this.numberModules = this.numberModules + inter;
            isAltered = true;
        }
        return isAltered;
    }

    //------------------------------------------
    /**
     * Get a description of the Student as a String
     */
    public String toString() {
        return "Student: " + fullName + " - StudentNo: " + registrationNumber;
    }
}
