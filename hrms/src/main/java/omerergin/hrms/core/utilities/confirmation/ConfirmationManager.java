package omerergin.hrms.core.utilities.confirmation;

import org.springframework.stereotype.Service;

import omerergin.hrms.core.utilities.results.ErrorResult;
import omerergin.hrms.core.utilities.results.Result;
import omerergin.hrms.core.utilities.results.SuccessResult;
import omerergin.hrms.dataAccess.abstracts.EmployeeDao;
import omerergin.hrms.dataAccess.abstracts.EmployerDao;
import omerergin.hrms.entities.concretes.Employee;
import omerergin.hrms.entities.concretes.Employer;

@Service
public class ConfirmationManager implements ConfirmationService {
	
	private EmployeeDao employeeDao;
	private EmployerDao employerDao;
	private Employer employer;
	
	public ConfirmationManager(EmployeeDao employeeDao,EmployerDao employerDao) {
		super();
		this.employeeDao = employeeDao;
		this.employerDao = employerDao;
	}

	@Override
	public Result confirmationToEmployer(Employee employee,String employerName) {
		
		if(employeeDao.findByEmail(employee.getEmail()).isEmpty()||employerDao.findByEmail(employerName).isEmpty()) {
			return new ErrorResult("Uncorrect confirmation fields.");
		}else {
			for (Employer employer1: employerDao.findByEmail(employerName)) {
				employer=employer1;
			} employer.setConfirm(true);
			employerDao.save(employer);
			return new SuccessResult(employer.getName()+" confirmed successfully.");
		}
		
	}

}
