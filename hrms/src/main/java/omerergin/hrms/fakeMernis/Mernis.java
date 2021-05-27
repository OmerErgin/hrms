package omerergin.hrms.fakeMernis;

public class Mernis {
	
	public boolean fakeValidation(int yearOfBirth) {
		if ((2021-yearOfBirth)>18) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
