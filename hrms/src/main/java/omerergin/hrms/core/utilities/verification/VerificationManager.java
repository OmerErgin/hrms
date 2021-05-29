package omerergin.hrms.core.utilities.verification;

import org.springframework.stereotype.Service;

import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessResult;

@Service
public class VerificationManager implements VerificationService {
	
	
	
	@Override
	public Result sendEmail(String email) {
		
		return new SuccessResult("Verification mail has been sent. Check your mailbox.");
	}

	@Override
	public Result verifyAccount(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
