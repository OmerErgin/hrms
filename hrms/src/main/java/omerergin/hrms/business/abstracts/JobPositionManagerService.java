package omerergin.hrms.business.abstracts;

import java.util.List;

import omerergin.hrms.entities.concretes.JobPosition;

public interface JobPositionManagerService {
	List<JobPosition> getAll();
}
