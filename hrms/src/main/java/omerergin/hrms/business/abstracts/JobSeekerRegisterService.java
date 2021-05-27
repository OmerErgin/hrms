package omerergin.hrms.business.abstracts;

import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.JobSeeker;

public interface JobSeekerRegisterService {
	Result registerRules(JobSeeker jobSeeker,String confirmPassword);
	Result emptyValue(JobSeeker jobSeeker,String confirmPassword);
	Result mernisValidation(JobSeeker jobSeeker);
	Result alreadyAccount(String identityId,String email);
	Result confirmPassword(JobSeeker jobSeeker, String password);
}
