package omerergin.hrms.business.abstracts;

import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.Employer;

public interface EmployerRegisterService {
	Result emptyValue(Employer employer,String password);
	Result emailWebsiteCheck(Employer employer);
	Result alreadyAccount(String email);
	Result confirmPassword(Employer employer,String password);
	Result eMailFormat(Employer employer);
	Result registerRules(Employer employer,String password);
}
