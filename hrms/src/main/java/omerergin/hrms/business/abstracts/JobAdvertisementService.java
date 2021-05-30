package omerergin.hrms.business.abstracts;

import java.util.List;

import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdversitement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByCreateDateAsc();
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(int employerId);
	Result changeJobAdvertisementStatus(int employerId,int jobAdvertisementId,boolean status);
}
