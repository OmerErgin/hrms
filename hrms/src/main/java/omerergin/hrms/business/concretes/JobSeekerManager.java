package omerergin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.JobSeekerRegisterService;
import omerergin.hrms.business.abstracts.JobSeekerService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessDataResult;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.core.utilities.verification.VerificationService;
import omerergin.hrms.dataAccess.abstracts.JobSeekerDao;
import omerergin.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private JobSeekerRegisterService registerService;
	private VerificationService verificationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,
			JobSeekerRegisterService registerService,VerificationService verificationService) {
		super();
		this.jobSeekerDao=jobSeekerDao;
		this.registerService=registerService;
		this.verificationService=verificationService;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş arayanlar getirildi.");
		
	}

	@Override
	public Result add(JobSeeker jobSeeker,String password) {
		if(registerService.registerRules(jobSeeker, password).isSuccess()) {
			verificationService.sendEmail(jobSeeker.getEmail());
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult(registerService.registerRules(jobSeeker, password).getMessage()+". "+verificationService.sendEmail(jobSeeker.getEmail()).getMessage());
		}else {
			return new  ErrorResult(registerService.registerRules(jobSeeker, password).getMessage());
			}
	}
	
	
	
}
