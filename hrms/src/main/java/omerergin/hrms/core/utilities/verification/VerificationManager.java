package omerergin.hrms.core.utilities.verification;

import org.springframework.stereotype.Service;

import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.EmployerDao;
import omerergin.hrms.dataAccess.abstracts.JobSeekerDao;
import omerergin.hrms.entities.concretes.Employer;
import omerergin.hrms.entities.concretes.JobSeeker;

@Service
public class VerificationManager implements VerificationService {
	
	private EmployerDao employerDao;
	private JobSeekerDao jobSeekerDao;
	private Employer employer;
	private JobSeeker jobSeeker;
	
	public VerificationManager(EmployerDao employerDao, JobSeekerDao jobSeekerDao) {
		super();
		this.employerDao = employerDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result sendEmail(String email) {
		
		return new SuccessResult("Verification mail has been sent. Check your mailbox.");
	}

	@Override
	public Result fakeVerifyAccount(String email) {
		if(!employerDao.findByEmail(email).isEmpty()) {
			for (Employer employer1: employerDao.findByEmail(email)) {
				employer=employer1;
			}employer.setVerify(true);
			employerDao.save(employer);
			return new SuccessResult(employer.getEmail()+" verified.");}
		if(!jobSeekerDao.findByEmail(email).isEmpty()) {
			for (JobSeeker jobSeeker1: jobSeekerDao.findByEmail(email)) {
				jobSeeker=jobSeeker1;
			}jobSeeker.setVerify(true);
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult(jobSeeker.getEmail()+" verified.");}
		else {
			return new ErrorResult("Check your email.");
		}
		
			
		}
	
	
	
	
	
	
}
