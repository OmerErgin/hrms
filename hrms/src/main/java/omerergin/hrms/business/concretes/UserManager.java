package omerergin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.UserService;
import omerergin.hrms.core.utilities.results.DataResult;
import omerergin.hrms.core.utilities.results.SuccessDataResult;
import omerergin.hrms.dataAccess.abstracts.JobSeekerDao;
import omerergin.hrms.dataAccess.abstracts.UserDao;
import omerergin.hrms.entities.concretes.JobSeeker;
import omerergin.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired 
	public UserManager(UserDao userDao,JobSeekerDao jobSeekerDao) {
		super();
		this.userDao=userDao;
		this.jobSeekerDao=jobSeekerDao;

	}
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	//@Override
	//public DataResult<User> getUserByEmail(String email) {
		
	//	return new SuccessDataResult<User>(userDao.findByEmail(email));
	//}
	
	//@Override
	//public DataResult<JobSeeker> getJobSeekerByIdentityId(String identityId) {
		
	//	return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByIdentityId(identityId));
	//}
	
	
	
	
}
