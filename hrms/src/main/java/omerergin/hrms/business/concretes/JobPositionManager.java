package omerergin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.JobPositionService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessDataResult;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.JobPositionDao;
import omerergin.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao=jobPositionDao;
		
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"İş Pozisyonları getirildi.");
		
		
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (alreadyAccount(jobPosition.getName()).isSuccess()) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("The Job Position has been successfully registered in the system.");
		}else {
			return new ErrorResult("Job Position has already registered in system. Try again.");
		}
		
	}
	
	@Override
	public Result alreadyAccount(String name) {
		
		if(jobPositionDao.findByName(name).isEmpty()) {
			return new SuccessResult();
		}else {
			return new ErrorResult();
		}
		
	}
	
}
