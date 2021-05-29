package omerergin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.EmployerRegisterService;
import omerergin.hrms.business.abstracts.EmployerService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessDataResult;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.core.utilities.verification.VerificationService;
import omerergin.hrms.dataAccess.abstracts.EmployerDao;
import omerergin.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmployerRegisterService registerService;
	private VerificationService verificationService;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmployerRegisterService registerService,VerificationService verificationService) {
		super();
		this.employerDao = employerDao;
		this.registerService=registerService;
		this.verificationService=verificationService;
	}



	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler getirildi.");
	}



	@Override
	public Result add(Employer employer, String confirmPassword) {
		if(registerService.registerRules(employer, confirmPassword).isSuccess()) {
			verificationService.sendEmail(employer.getEmail());
			employerDao.save(employer);
			return new SuccessResult(registerService.registerRules(employer,confirmPassword).getMessage()+". "+verificationService.sendEmail(employer.getEmail()).getMessage());
		}else {
			return new  ErrorResult(registerService.registerRules(employer, confirmPassword).getMessage());
		}
	}

}
