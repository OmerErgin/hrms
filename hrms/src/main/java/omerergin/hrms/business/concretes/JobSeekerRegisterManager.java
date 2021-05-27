package omerergin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.JobSeekerRegisterService;
import omerergin.hrms.business.abstracts.UserService;
import omerergin.hrms.core.utilities.adapters.FakeMernisAdapter;
import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.JobSeekerDao;
import omerergin.hrms.dataAccess.abstracts.UserDao;
import omerergin.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerRegisterManager implements JobSeekerRegisterService {
	
	private FakeMernisAdapter mernisAdapter;
	private UserDao userDao;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerRegisterManager(FakeMernisAdapter mernisAdapter,UserDao userDao,JobSeekerDao jobSeekerDao) {
		super();
		this.mernisAdapter=mernisAdapter;
		this.userDao=userDao;
		this.jobSeekerDao=jobSeekerDao;
	}
	
	
	@Override
	public Result emptyValue(JobSeeker jobSeeker,String confirmPassword) {
		if(!(jobSeeker.getEmail()==null)&&!(jobSeeker.getDateOfYear()==null)&&!(jobSeeker.getFirstName()==null)&&
				!(jobSeeker.getLastName()==null)&&!(jobSeeker.getIdentityId()==null)&&!(jobSeeker.getPassword()==null)
				&&!(confirmPassword==null)) {
			return new SuccessResult();
		}else {
		return new ErrorResult("The field cannot be empty. Please enter a value");}
	}

	@Override
	public Result mernisValidation(JobSeeker jobSeeker) {
		if(mernisAdapter.checkIfRealPerson(jobSeeker)) {
			return new SuccessResult();
		}
		else{
			return new ErrorResult("Mernis validation has failed.");
		}
	}

	@Override
	public Result alreadyAccount(String identityId,String email) {
		
		if(userDao.findByEmail(email).isEmpty()&&
				jobSeekerDao.findByIdentityId(identityId).isEmpty()) {
			return new SuccessResult();
		}else {
			return new ErrorResult("Account already added.");
		}
		
	}
	
	@Override
	public Result confirmPassword(JobSeeker jobSeeker, String password) {
		if(!(jobSeeker.getPassword()==password)) {
			return new SuccessResult();
		}else {
			return new ErrorResult("Password did not mashed.");
		}
	}


	@Override
	public Result registerRules(JobSeeker jobSeeker, String confirmPassword) {
		
		if(!emptyValue(jobSeeker, confirmPassword).isSuccess()) {
			return new ErrorResult(emptyValue(jobSeeker, confirmPassword).getMessage());
		}
		if(!mernisValidation(jobSeeker).isSuccess()) {
			return new ErrorResult(mernisValidation(jobSeeker).getMessage());
		}
		if(!alreadyAccount(jobSeeker.getIdentityId(),jobSeeker.getEmail()).isSuccess()) {
			return new ErrorResult(alreadyAccount(jobSeeker.getIdentityId(),jobSeeker.getEmail()).getMessage());
		}
		if(!confirmPassword(jobSeeker, confirmPassword).isSuccess()) {
			return new ErrorResult(confirmPassword(jobSeeker, confirmPassword).getMessage());
		}
		
		
		else {
			return new SuccessResult("Registered");
		}
		
	}

	
}
