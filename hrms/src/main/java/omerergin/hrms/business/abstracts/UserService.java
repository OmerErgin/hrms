package omerergin.hrms.business.abstracts;

import java.util.List;

import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.entities.concretes.JobSeeker;
import omerergin.hrms.entities.concretes.User;

public interface UserService {
		DataResult<List<User>> getAll();
		//DataResult<User> getUserByEmail(String email);
		//DataResult<JobSeeker> getJobSeekerByIdentityId(String identityId);
}
