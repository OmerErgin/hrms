package omerergin.hrms.business.abstracts;

import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementRuleService {
	Result checkJobPosition(JobAdvertisement jobAdvertisement);
	Result checkDescription(JobAdvertisement jobAdvertisement);
	Result checkCity(JobAdvertisement jobAdvertisement);
	Result checkQuantity(JobAdvertisement jobAdvertisement);
	Result checkFields(JobAdvertisement jobAdvertisement);
}
