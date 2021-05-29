package omerergin.hrms.core.utilities.verification;

import omerergin.hrms.core.utilities.results.Result;

public interface VerificationService {
	Result sendEmail(String email);
	Result verifyAccount(String email,String password);
}
