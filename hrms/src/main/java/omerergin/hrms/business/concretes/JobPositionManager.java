package omerergin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import omerergin.hrms.business.abstracts.JobPositionManagerService;
import omerergin.hrms.dataAccess.abstracts.JobPositionDao;
import omerergin.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionManagerService {
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		
		this.jobPositionDao=jobPositionDao;
		
	}
	
	@Override
	public List<JobPosition> getAll() {
		
		return this.jobPositionDao.findAll();
		
		
	}
	
}
