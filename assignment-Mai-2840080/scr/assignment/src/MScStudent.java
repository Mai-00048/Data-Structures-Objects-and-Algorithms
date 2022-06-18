/**
 * Please provide your student ID below.
 * 
 * 	Student ID: 2840080
 */
// class MscStudent that inherits from Student Class
public class MScStudent extends Student {

	// attributes
    protected String researchTitle;
    protected Professor supervisor;
	
	// constructor of MscStudent
    public MScStudent(String fn, int registrationNumber, String email, String researchTitle, Professor supervisor) {
        super(fn, registrationNumber, email);
        this.researchTitle = researchTitle;
        this.supervisor = supervisor;
    }
	
	// method toString displaying fullname,registrationNumber, researchTitle and supervisor
    @Override
    public String toString() {
        return super.toString() + " researchTitle=" + researchTitle + ", supervisor=" + supervisor;
    }

}
