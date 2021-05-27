package omerergin.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import omerergin.hrms.entities.concretes.JobSeeker;
import omerergin.hrms.fakeMernis.Mernis;

@Service
public class FakeMernisAdapter {
		
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		try {Mernis mernis = new Mernis();
			return mernis.fakeValidation(jobSeeker.getDateOfYear());
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
