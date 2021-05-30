package omerergin.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.JobAdvertisementRuleService;
import omerergin.hrms.business.abstracts.JobAdvertisementService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessDataResult;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.JobAdvertisementDao;
import omerergin.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao; 
	private JobAdvertisementRuleService jobAdvertisementRuleService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,JobAdvertisementRuleService jobAdvertisementRuleService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.jobAdvertisementRuleService=jobAdvertisementRuleService;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisementRuleService.checkFields(jobAdvertisement).isSuccess()) {
			jobAdvertisement.setCreateDate(LocalDate.now());
			jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Job Advertisement added");
		}else {
			return new ErrorResult("Check fields.");
		}
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		 
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Job Advertisements");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveTrue(),"Active Job Advertisements");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByCreateDateAsc() {
		return new SuccessDataResult<List<JobAdvertisement>> (jobAdvertisementDao.getByIsActiveTrueOrderByCreateDateAsc(),"Sorted for create date");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveTrueAndEmployerId(employerId));
	}

	@Override
	public Result changeJobAdvertisementStatus(int employerId, int jobAdvertisementId, boolean status) {
		
		List<JobAdvertisement> jobAdvertisements=this.jobAdvertisementDao.getByIsActiveTrueAndEmployerId(employerId);
		if(jobAdvertisements.isEmpty()) {
			return new ErrorResult("Check jobAdvertisementId");
		}
		for (JobAdvertisement jobAdvertisement: jobAdvertisements) {
			if(jobAdvertisementId==jobAdvertisement.getId()) {
				jobAdvertisement.setActive(status);
				this.jobAdvertisementDao.save(jobAdvertisement);
				return new SuccessResult("Advertisement "+jobAdvertisementId+("'s status has been changed."));
			}}
		return new ErrorResult("Check fields.");

	}
}
