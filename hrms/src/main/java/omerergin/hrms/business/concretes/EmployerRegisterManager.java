package omerergin.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.EmployerRegisterService;
import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.UserDao;
import omerergin.hrms.entities.concretes.Employer;

@Service
public class EmployerRegisterManager implements EmployerRegisterService {
	
	private UserDao userDao;

	
	public EmployerRegisterManager( UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result emptyValue(Employer employer, String confirmPassword) {
		if(!(employer.getEmail()==null)&&!(employer.getWebSite()==null)&&!(employer.getName()==null)&&
				!(employer.getPhoneNumber()==null)&&!(employer.getPassword()==null)
				&&!(confirmPassword==null)) {
			return new SuccessResult();
		}else {
		return new ErrorResult("The field cannot be empty. Please enter a value");}
	}

	@Override
	public Result alreadyAccount(String email) {
		if(userDao.findByEmail(email).isEmpty()) {
			return new SuccessResult();
		}else {
			return new ErrorResult("Account already added.");
		}
	}

	@Override
	public Result confirmPassword(Employer employer, String password) {
		if(!(employer.getPassword()==password)) {
			return new SuccessResult();
		}else {
			return new ErrorResult("Password did not mashed.");
		}
	}
	
	@Override
	public Result emailWebsiteCheck(Employer employer) {
		String[] email=employer.getEmail().split("@");
		if(employer.getWebSite().contains(email[1]))  {
			return new SuccessResult(); }
		else {
			return new ErrorResult("Domain is not correct!");
		}
		}
	
	@Override
	public Result eMailFormat(Employer employer) {
		Pattern pattern =Pattern.compile("^([a-zA-Z0-9+_.-])+@([a-zA-Z0-9-]+).([a-z]{2,20})(.[a-z]{2,20})?$");
		Matcher matcher=pattern.matcher(employer.getEmail());
		if(matcher.matches()) {
		return new SuccessResult();}
		else {
			return new ErrorResult("Check format of email!");
		}
	}
	

	@Override
	public Result registerRules(Employer employer, String password) {
		if(!emptyValue(employer, password).isSuccess()) {
			return new ErrorResult(emptyValue(employer, password).getMessage());
		}
		if(!eMailFormat(employer).isSuccess()) {
			return new ErrorResult(eMailFormat(employer).getMessage());
		}
		
		if(!emailWebsiteCheck(employer).isSuccess()) {
			return new ErrorResult(emailWebsiteCheck(employer).getMessage());
		}
		if(!alreadyAccount(employer.getEmail()).isSuccess()) {
			return new ErrorResult(alreadyAccount(employer.getEmail()).getMessage());
		}
		if(!confirmPassword(employer, password).isSuccess()) {
			return new ErrorResult(confirmPassword(employer, password).getMessage());
		}

		
		else {
			return new SuccessResult("Employer Registered");
		}
	}

	

}
