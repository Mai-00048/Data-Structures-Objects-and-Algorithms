public class Professor implements Person
{
	protected String fullName;
	protected int registrationNumber;
	
	public Professor(String fn, int registrationNumber, String email) {
		this.fullName = fn;
		this.registrationNumber = registrationNumber;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fn) {
		this.fullName = fn;
	}

	public int getRegistrationNumber(){
		return registrationNumber;
	}
	public void setRegistrationNumber(int rn) {
		this.registrationNumber = rn;
	}
	
	public String toString() {
		return "Professor: " + fullName; 
	}
}
