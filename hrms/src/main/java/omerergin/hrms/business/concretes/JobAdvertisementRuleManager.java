package omerergin.hrms.business.concretes;

import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.JobAdvertisementRuleService;
import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementRuleManager implements JobAdvertisementRuleService {
	
	
	public Result checkJobPosition(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getJobPosition()==null) {
			return new ErrorResult("Select job position!");
		}else {
			return new SuccessResult();
		}
	}
	public Result checkDescription(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getDescription().isEmpty()) {
			return new ErrorResult("Description cannot be empty.");
		}else {
			return new SuccessResult();
		}
	}
	
	public Result checkCity(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getCity()==null) {
			return new ErrorResult("Select city.");
		}else {
			return new SuccessResult();
		}
	}
	
	public Result checkQuantity(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getQuantity()<=0) {
			return new ErrorResult("Quantity number!");
		}else {
			return new SuccessResult();
		}
	}
	@Override
	public Result checkFields(JobAdvertisement jobAdvertisement) {
		if(!checkJobPosition(jobAdvertisement).isSuccess()) {
			return new ErrorResult(checkJobPosition(jobAdvertisement).getMessage());
		}
		if(!checkDescription(jobAdvertisement).isSuccess()) {
			return new ErrorResult(checkDescription(jobAdvertisement).getMessage());
		}
		if(!checkCity(jobAdvertisement).isSuccess()) {
			return new ErrorResult(checkCity(jobAdvertisement).getMessage());
		}
		if(!checkQuantity(jobAdvertisement).isSuccess()) {
			return new ErrorResult(checkQuantity(jobAdvertisement).getMessage());
		}else {
			return new SuccessResult();
		}
		
	}
}
